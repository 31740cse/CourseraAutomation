
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

