package org.example.stepDefs;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import io.cucumber.java.After;

public class Hooks {

    public static WebDriver driver;

        @Before
        public static void OpenBrowser()
        {
            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

                setDriver(new ChromeDriver());

            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            getDriver().get("https://demo.nopcommerce.com/");

        }

        @After
        public static void quitDriver() throws InterruptedException {
            //Thread.sleep(3000);
            //getDriver().quit();
        }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Hooks.driver = driver;
    }


}

