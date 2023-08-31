package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

import java.time.Duration;

public class NotificationSelection extends BaseClass {

    @FindBy(id = "btn_primary")
    private WebElement DONE_BTN;

    @FindBy(id = "dismiss_modal")
    private WebElement DISMISS_BTN;

    public NotificationSelection() {
        PageFactory.initElements(driver,this);
    }

    public void waitForPageToLoad() {
        waitForElementPresent(DONE_BTN, Duration.ofSeconds(2));
    }

    public void clickDone() {
        waitForElementPresent(DONE_BTN,Duration.ofSeconds(2));
        DONE_BTN.click();
    }

    public void dismissModal() {
        waitForElementPresent(DISMISS_BTN,Duration.ofSeconds(2));
        DISMISS_BTN.click();
    }
}
