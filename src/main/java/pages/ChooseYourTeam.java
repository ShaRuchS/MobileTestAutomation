package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

import java.time.Duration;

public class ChooseYourTeam extends BaseClass {

    @FindBy(xpath = "//*[contains(@text,'Choose your favorite teams')]")
    private WebElement TEAM_SELECTION_TITLE;

    @FindBy(id = "btn_primary")
    private WebElement CONTINUE_BTN;

    public ChooseYourTeam() {
        PageFactory.initElements(driver,this);
    }

    public static String TEAM_TXT = "//android.widget.TextView[contains(@text,'%s')]";


    public void waitForPageToLoad() {
        waitForElementPresent(TEAM_SELECTION_TITLE, Duration.ofSeconds(2));
    }

    public void selectTeam(String teamName) {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToBeginning(100000)"));
        findElementUsingXpath(String.format(TEAM_TXT,teamName)).click();
        CONTINUE_BTN.click();
    }
}
