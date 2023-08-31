package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

import java.time.Duration;

public class ChooseYourLeague extends BaseClass {

    @FindBy(id = "title_onboarding")
    private WebElement ONBOARDING_TITLE;

    @FindBy(id = "btn_disallow")
    private WebElement LOCATION_DISALLOW;

    @FindBy(id = "btn_primary")
    private WebElement CONTINUE_BTN;

    public ChooseYourLeague() {
        PageFactory.initElements(driver,this);
    }

    public static String LEAGUE_TXT = "//android.widget.TextView[contains(@text,'%s')]";

    public void waitForPageToLoad() {
        waitForElementPresent(ONBOARDING_TITLE, Duration.ofSeconds(2));
    }

    public void selectLeague(String leagueName) {
        findElementUsingXpath(String.format(LEAGUE_TXT,leagueName)).click();
    }

    public void denyLocationPermission() {
        LOCATION_DISALLOW.click();
    }

    public void clickContinue() {
        CONTINUE_BTN.click();
    }
}
