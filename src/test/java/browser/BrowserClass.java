package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserClass {

    public WebDriver getWebDriver(Browser browser) {

        WebDriver driver;

        switch (browser){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver/chromedriver");
                driver = new ChromeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                return driver;

            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "driver/yandexdriver/yandexdriver");
                driver = new ChromeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                return driver;

            default:
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver/chromedriver");
                driver = new ChromeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                return driver;
        }

   }

}
