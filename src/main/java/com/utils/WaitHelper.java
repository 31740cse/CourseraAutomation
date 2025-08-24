package com.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public WaitHelper(WebDriver driver, int timeOutInSeconds) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
	}
	
	
	public boolean waitForElementVisible(WebElement elmt) {
		try {
			wait.until(ExpectedConditions.visibilityOf(elmt));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	public boolean isXpathIsValid(String xpath) {
		try {
			WebElement temp=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			return temp!=null;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	

	
	public WebElement waitForElementClickable(WebElement elmt) {
		return wait.until(ExpectedConditions.visibilityOf(elmt));
	}

}
