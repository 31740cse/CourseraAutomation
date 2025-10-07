/*
package drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        try {
            if (browser.toLowerCase().contains("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.toLowerCase().contains("edge")) {
                driver = new EdgeDriver();
            } else {
                System.out.println("Browser Not found");
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Error initializing the browser. " + e.getMessage());
            e.printStackTrace();
        }
        return driver;
    }

}



*/

package drivers;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        try {
            // Detect if running in headless environment (e.g., Codespaces)
            // You can set this env variable in Codespaces: HEADLESS=true
            boolean isHeadless = Boolean.parseBoolean(System.getenv("HEADLESS"));

            if (browser == null) {
                browser = "chrome"; // default browser
            }

            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (isHeadless) {
                        chromeOptions.addArguments("--headless=new");
                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-dev-shm-usage");
                        chromeOptions.addArguments("--disable-gpu");
                        chromeOptions.addArguments("--window-size=1920,1080");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        firefoxOptions.addArguments("--headless");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (isHeadless) {
                        edgeOptions.addArguments("--headless=new");
                        edgeOptions.addArguments("--no-sandbox");
                        edgeOptions.addArguments("--disable-dev-shm-usage");
                        edgeOptions.addArguments("--disable-gpu");
                        edgeOptions.addArguments("--window-size=1920,1080");
                    }
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    System.out.println("Browser not recognized! Defaulting to Chrome.");
                    driver = new ChromeDriver();
                    break;
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

        } catch (Exception e) {
            System.out.println("Error initializing the browser. " + e.getMessage());
            e.printStackTrace();
        }
        return driver;
    }

    // Example main() so you can test this in Codespaces or locally
    public static void main(String[] args) {
        WebDriver driver = getDriver("chrome");
        if (driver != null) {
            driver.get("https://example.com");
            System.out.println("Page title is: " + driver.getTitle());
            driver.quit();
        } else {
            System.out.println("Driver initialization failed.");
        }
    }
}