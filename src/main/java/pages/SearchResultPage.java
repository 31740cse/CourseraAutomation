package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.WaitHelper;

public class SearchResultPage {
	private WebDriver driver;
	private WaitHelper waitHelper;
	public SearchResultPage(WebDriver driver, WaitHelper waitHelper) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.waitHelper= waitHelper;
	}

	public void applyFilters(Map<String,ArrayList<String>> filtersrequirements) {

		for(String key:filtersrequirements.keySet()) {
			for(String value:filtersrequirements.get(key)) {
				String xpath= "//*[@id='main']/div[1]/div/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[@data-testid='search-filter-group-"+key+"']//div[contains(@data-testid, '"+value+"')]/label";
				if(driver.findElements(By.xpath(xpath)).isEmpty()) {
					driver.findElement(By.xpath("//*[@id='main']/div[1]/div/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[@data-testid='search-filter-group-"+key+"']//span[contains(text(), 'Show')]")).click();
				}
				if(waitHelper.isXpathIsValid(xpath)) {
					WebElement section= driver.findElement(By.xpath(xpath));
					section.click();
				}
			}
		}
	}



	public static ArrayList<String> extractParticularSectionDetails(WebDriver driver, String section, WaitHelper waitHelper) {

		String path= "//*[@id='main']//div[@data-testid='search-filter-group-"+section+"']/div/div";
		
		waitHelper.isXpathIsValid(path);

		List<WebElement> textList=driver.findElements(By.xpath(path));

		ArrayList<String> ans= new ArrayList<String>();
		for(WebElement elm:textList) {
			ans.add(elm.getText().replaceAll("\\s", " ").trim());
		}

		return ans;

	}


	public static void extractInfoAboutFilter(WebElement elmt, String section, WebDriver driver, WaitHelper waitHelper) {
		
		String languageName= elmt.getText();
		elmt.click();
		
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		ArrayList<String> filterResult;
		filterResult= SearchResultPage.extractParticularSectionDetails(driver, section, waitHelper);

		SearchResultPage.log(filterResult, section, languageName);
		
		
		
		driver.navigate().back();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	private static void log(ArrayList<String> filterResult, String section, String languageName) {
		System.out.println("For "+languageName+" "+section+" information is below\n");
		for(String ele:filterResult) {
			System.out.println(ele);
		}
		System.out.println("\n");
		return;		
	}



}
