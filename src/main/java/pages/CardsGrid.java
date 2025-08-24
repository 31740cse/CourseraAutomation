package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.WaitHelper;

public class CardsGrid {
	
	private WebDriver driver=null;
	private WaitHelper waitHelper;
	
	public CardsGrid(WebDriver driver, WaitHelper waitHelper) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.waitHelper= waitHelper;
	}
	
	
	List<WebElement> lst= new ArrayList<WebElement>();
	public List<WebElement> selectCards(int numberOfRequireCards) {
		for(int i=1;i<=numberOfRequireCards;i++) {
			By xpath= By.xpath("//*[@id='searchResults']/div[1]/div/ul/li["+i+"]");
			WebElement card= driver.findElement(xpath);
			lst.add(card);
		}
		return lst;
	}
	
	
	

}
