package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utils.WaitHelper;

public class HomePage {

	private WebDriver driver=null;
	private WaitHelper waitHelper;

	public HomePage(WebDriver driver, WaitHelper waitHelper) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.waitHelper= waitHelper;
	}


	public void searchInSearchBar(String searchtext) {
		// TODO Auto-generated method stub

		driver.findElement(By.xpath("//*[@id='search-autocomplete-input']")).sendKeys(searchtext);
		driver.findElement(By.xpath("//*[@id='search-autocomplete-input']")).sendKeys(Keys.ENTER);

	}


	public void switchToHomePage() {
		driver.findElement(By.xpath("//*[@id=\"rendered-content\"]//*[@class='css-o1szhl']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}


	}

}
