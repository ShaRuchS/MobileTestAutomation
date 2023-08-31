package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

import java.time.Duration;

public class WelcomePage extends BaseClass {

    @FindBy(id="btn_primary")
    private WebElement WELCOME_LBL;

    @FindBy(id="btn_primary")
    private WebElement GET_STARTED_BTN;

    public WelcomePage() {
        PageFactory.initElements(driver,this);
    }

    public void waitForPageToLoad() {
        waitForElementPresent(WELCOME_LBL, Duration.ofSeconds(2));
        waitForElementPresent(GET_STARTED_BTN, Duration.ofSeconds(2));
    }

    public void clickGetStarted() {
        GET_STARTED_BTN.click();
    }
}
