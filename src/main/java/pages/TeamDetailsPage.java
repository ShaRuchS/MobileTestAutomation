package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

import java.time.Duration;

public class TeamDetailsPage extends BaseClass {

    @FindBy(id = "team_name")
    private WebElement TEAM_NAME_HEADER;

    @FindBy(xpath = "//*[contains(@text,'SCHEDULE')]")
    private WebElement SCHEDULE_TAB;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Preseason')]")
    private WebElement PRESEASON_LBL;

    public TeamDetailsPage() {
        PageFactory.initElements(driver,this);
    }

    public void waitForPageToLoad() {
        waitForElementPresent(TEAM_NAME_HEADER, Duration.ofSeconds(2));
    }

    public void verifyTeamHeader(String teamName) {
        Assertions.assertTrue(TEAM_NAME_HEADER.getText().equalsIgnoreCase(teamName),teamName+" is displayed in header as expected");
    }

    public void selectScheduleTab() {
        SCHEDULE_TAB.click();
    }

    public void verifyScheduleTab() {
        waitForElementPresent(PRESEASON_LBL,Duration.ofSeconds(2));
        Assertions.assertTrue(PRESEASON_LBL.isDisplayed(),"Pre season schedule is displayed as expected");
    }
}
