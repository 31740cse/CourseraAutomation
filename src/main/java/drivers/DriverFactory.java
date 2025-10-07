/*package drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	
		public static WebDriver getDriver(String browser) {
			WebDriver driver=null;
			try {
				if(browser.toLowerCase().contains("chrome")) {
					driver= new ChromeDriver();
				}else if(browser.toLowerCase().contains("edge")) {
					driver= new EdgeDriver();
				}else {
					System.out.println("Browser Not found");
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
			}catch(Exception e) {
				System.out.println("Error initializing the browser. "+e.getMessage());
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        try {
            browser = browser.toLowerCase();

            if (browser.contains("chrome")) {
                WebDriverManager.chromedriver().setup(); // Auto-download ChromeDriver
                ChromeOptions options = new ChromeOptions();

                // Headless mode for online environments
                if (isOnlineEnvironment()) {
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }

                driver = new ChromeDriver(options);

            } else if (browser.contains("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

            } else if (browser.contains("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            } else {
                System.out.println("Browser Not found: " + browser);
                return null;
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

        } catch (Exception e) {
            System.out.println("Error initializing the browser. " + e.getMessage());
            e.printStackTrace();
        }
        return driver;
    }

    // Detect if running in a typical online workspace / CI environment
    private static boolean isOnlineEnvironment() {
        String env = System.getenv("CI"); // Commonly set in GitHub Actions, GitLab CI, etc.
        return env != null && env.equalsIgnoreCase("true");
    }
}


