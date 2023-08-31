package utility;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * Base class contains all reusable methods at page class level.
 * current implementation supports only Android application automation, can be extended for iOS apps automation.
 *
 */

public class BaseClass {

    public static AndroidDriver driver;
    public static Properties appProps;

    public AndroidDriver getDriver() {

        loadProperties();

        final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        if(appProps.getProperty("platformName").equalsIgnoreCase("android")){

            desiredCapabilities.setCapability("automationName",appProps.getProperty("automationName"));
            desiredCapabilities.setCapability("platformName",appProps.getProperty("platformName"));
            desiredCapabilities.setCapability("deviceName",appProps.getProperty("deviceName"));
            desiredCapabilities.setCapability("udid",appProps.getProperty("udid"));
            desiredCapabilities.setCapability("noReset",appProps.getProperty("noReset"));
            desiredCapabilities.setCapability("appPackage",appProps.getProperty("appPackage"));
            desiredCapabilities.setCapability("appActivity",appProps.getProperty("appActivity"));

            try {
                driver =  new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return driver;
    }

    public void loadProperties(){
        appProps = new Properties();
        try {
            appProps.load(new FileInputStream("./resources/application.properties"));
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).info("Exception occurred while loading properties");
            e.printStackTrace();
        }
    }

    public void waitForElementPresent(WebElement element, Duration waitTimeSec){
        WebDriverWait wait = new WebDriverWait(driver, waitTimeSec);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement findElementUsingXpath(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        this.waitForElementPresent(element,Duration.ofSeconds(2));
        return element;
    }
}
