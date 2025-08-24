package pages;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.WaitHelper;

public class OpenDetails {

	private WebDriver driver=null;
	private WaitHelper waitHelper;
	private String parentWindow;

	List<String>lst = new ArrayList<>();

	public OpenDetails(WebDriver driver, WaitHelper waitHelper) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.waitHelper= waitHelper;
	}


	public void extractCardsDetails(WebElement card, List<String>requiredDetails){
		card.click();
		Set <String> windows=driver.getWindowHandles();
		parentWindow=driver.getWindowHandle();
		for (String window:windows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				waitHelper.isXpathIsValid("//*[@id='rendered-content']/div/main//*[@data-e2e='hero-title']");
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				if(requiredDetails.contains("course names")) {
					lst.add("course names:"+driver.findElement(By.xpath("//*[@id='rendered-content']/div/main//*[@data-e2e='hero-title']")).getText());
				}

				if(requiredDetails.contains("Modules information")) {
					lst.add("Modules information:"+driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div[2]/div[1]")).getText());
				}

				if(requiredDetails.contains("Ratings")) {
					lst.add("Ratings:"+driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div[2]/div[2]")).getText());

				}

				if(requiredDetails.contains("level")) {
					lst.add("level:"+driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div[2]/div[3]")).getText());
				}

				if(requiredDetails.contains("learning hours")) {
					lst.add("learning hours:"+driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div[2]/div[4]")).getText());
				}


				if(requiredDetails.contains("likes")) {
					lst.add("likes:"+driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/main/section[2]/div/div/div[2]/div/div[2]/div[1]")).getText());
				}

				driver.close();
			}
		}
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.switchTo().window(parentWindow);
	}


	public void logDetails() {

		for(String key:lst) {
			System.out.println(key.split(":")[0]+"--->"+key.split(":")[1]);
		}

		System.out.println("\n");
		
	}
}
