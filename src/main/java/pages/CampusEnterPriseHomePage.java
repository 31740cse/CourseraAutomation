package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.WaitHelper;

public class CampusEnterPriseHomePage {

	public WebDriver driver;
	private WaitHelper waitHelper;

	public CampusEnterPriseHomePage(WebDriver driver, WaitHelper waitHelper) {
		this.driver=driver;
		this.waitHelper= waitHelper;
	}


	public WebElement getCampusEnterPriseLink() {
		return driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div[1]//*[@class='css-1dswftd'][3]"));
	}


	public void fillFormDetails(String[] formData) {
		// TODO Auto-generated method stub
		((JavascriptExecutor) driver).executeScript("document.getElementById('mktoForm_1512').scrollIntoView();");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}

		driver.findElement(By.id("FirstName")).sendKeys(formData[0]);
		driver.findElement(By.id("LastName")).sendKeys(formData[1]);
		driver.findElement(By.id("Email")).sendKeys(formData[2]);
		driver.findElement(By.id("Phone")).sendKeys(formData[3]);
		CampusEnterPriseHomePage.selectOptions(driver, "Institution_Type__c", formData[4]);
		driver.findElement(By.id("Company")).sendKeys(formData[5]);
		CampusEnterPriseHomePage.selectOptions(driver, "Title", formData[6]);		
		CampusEnterPriseHomePage.selectOptions(driver, "Department", formData[7]);		
		CampusEnterPriseHomePage.selectOptions(driver, "What_the_lead_asked_for_on_the_website__c", formData[8]);
		CampusEnterPriseHomePage.selectOptions(driver, "Country", formData[9]);
		CampusEnterPriseHomePage.selectOptions(driver, "State", formData[10]);
	}

	public static void selectOptions(WebDriver driver, String id, String arg) {
		Select dropdown = new Select(driver.findElement(By.id(id)));
		List<WebElement> options = dropdown.getOptions();

		boolean found = false;
		for (WebElement option : options) {
			if (option.getText().equals(arg)) {
				dropdown.selectByVisibleText(arg);
				found = true;
				break;
			}
		}

		if (!found) {
			for (WebElement option : options) {
				if (option.getText().equals("Other")) {
					dropdown.selectByVisibleText("Other");
					found = true;
					break;
				}
			}
		}

		if (!found) {
			System.out.println("Invalid option: " + arg);
		}
	}



	public void hitSubmitButton() {
		driver.findElement(By.xpath("//*[@id=\"mktoForm_1512\"]/div[50]/span/button")).click();

	}


	public boolean readErrorMessageAndLogIf() {
		try {
			List<WebElement> elements = driver.findElements(By.id("ValidMsgEmail"));
			if(elements.size()==0) {
				System.out.println("No Error Found");
				return true;
			}
			System.out.println("Error message flexing from 'Ready to transform' Form");
			for(WebElement element:elements) {
				
				System.out.println(element.getText());
			}
			return true;
		}catch(Exception e) {
			return false;
		}


	}









}
