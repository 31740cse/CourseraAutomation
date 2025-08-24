package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.WaitHelper;

public class LanguageLearningHomePage {

	public WebDriver driver;
	private WaitHelper waitHelper;

	public LanguageLearningHomePage(WebDriver driver, WaitHelper waitHelper) {
		this.driver=driver;
		this.waitHelper= waitHelper;
	}



	public WebElement getLanguageLearningPageLink() {
		WebElement exploreButton = driver.findElement(By.xpath("//*[@data-testid='simplified-megaMenu-wrapper']"));
		Actions actions= new Actions(driver);
		actions.moveToElement(exploreButton).perform();
		if(waitHelper.waitForElementVisible(exploreButton) && waitHelper.waitForElementVisible(driver.findElement(By.xpath("//*[@data-testid=\"megamenu-item~Language Learning\"]"))))
			return driver.findElement(By.xpath("//*[@data-testid=\"megamenu-item~Language Learning\"]"));
		return null;
	}

	public static int setListOfAllLanguages(WebDriver driver) {
		By xpath= By.xpath("//*[@id='rendered-content']/div/div/div/div[2]/section/div[2]/section/div/div[1]/div[1]/div/div/div");
		return driver.findElements(xpath).size();
	}


	//	LanguageLearningHomePage languageLearningHomePage = new LanguageLearningHomePage(driver, waitHelper);
	public void getQueryResult(String section) {
		int sizeOfListOfAllLanguages = LanguageLearningHomePage.setListOfAllLanguages(driver);
		for(int i=1;i<=sizeOfListOfAllLanguages;i++) {
			waitHelper.isXpathIsValid("//*[@id='rendered-content']/div/div/div/div[2]/section/div[2]/section/div/div[1]/div[1]/div/div/div["+i+"]");

			WebElement elmt= driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/div/div[2]/section/div[2]/section/div/div[1]/div[1]/div/div/div["+i+"]"));



			SearchResultPage.extractInfoAboutFilter(elmt, section, driver, waitHelper);

		}

	}




}
