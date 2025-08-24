package TesCases;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.WaitHelper;

import config.ConfigReader;
import drivers.DriverFactory;
import pages.CampusEnterPriseHomePage;
import pages.CardsGrid;
import pages.HomePage;
import pages.LanguageLearningHomePage;
import pages.OpenDetails;
import pages.SearchResultPage;

public class CourSeraTest {

	private WebDriver driver;
	private ConfigReader config;
	private WaitHelper waitHelper;
	@BeforeClass
	public void setup() throws IOException {
		config=new ConfigReader();
		driver= DriverFactory.getDriver(config.getBrowser());
		driver.get(config.getBaseUrl());
		waitHelper=new WaitHelper(driver, 10);
	}

	@Test
	public void startTest1() {
		HomePage homePage = new HomePage(driver, waitHelper);
		homePage.searchInSearchBar(config.getSearchtext());

		SearchResultPage searchRespg=new SearchResultPage(driver, waitHelper);
		searchRespg.applyFilters(config.getFiltersrequirements());

		//collect all required Cards
		CardsGrid cardsGrid = new CardsGrid(driver, waitHelper);
		List<WebElement> cards= cardsGrid.selectCards(config.getNumberOfRequireCards());


		//extract details from every card and print that
		OpenDetails openDetails= new OpenDetails(driver, waitHelper);
		for(WebElement card: cards) {
			openDetails.extractCardsDetails(card, config.getQueryListForDetails());//implement this with waitHelper function
			openDetails.logDetails();
		}
		
		
		int actualCardCountOfDesiredLevel=cards.size();
		int expectedCardCountOfDesiredLevel=config.getNumberOfRequireCards();
		
		Assert.assertEquals(actualCardCountOfDesiredLevel, expectedCardCountOfDesiredLevel);
		
		
		
		
	}

	
	@Test
	public void startTest2() {
		//Task 2
		//Now find language learning link and by click go to that
		LanguageLearningHomePage languageLearningHomePage = new LanguageLearningHomePage(driver, waitHelper);
		languageLearningHomePage.getLanguageLearningPageLink().click();
		languageLearningHomePage.getQueryResult(config.getQueryAttributeName());
		
		Assert.assertTrue(driver.getTitle().contains("Language Learning"));
	}



	@Test
	public void startTest3() {
		//task 3
		CampusEnterPriseHomePage campusEnterPriseHomePage = new CampusEnterPriseHomePage(driver, waitHelper);
		campusEnterPriseHomePage.getCampusEnterPriseLink().click();
		campusEnterPriseHomePage.fillFormDetails(config.getFormData());
		campusEnterPriseHomePage.hitSubmitButton();

		Assert.assertTrue(campusEnterPriseHomePage.readErrorMessageAndLogIf());

	}


	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}


}
