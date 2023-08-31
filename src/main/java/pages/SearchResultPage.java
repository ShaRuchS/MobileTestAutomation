package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

import java.time.Duration;

public class SearchResultPage extends BaseClass {

    @FindBy(xpath = "//*[contains(@text,'ALL')]")
    private WebElement ALL_TAB;

    @FindBy(xpath = "//*[contains(@text,'TEAMS')]")
    private WebElement TEAMS_TAB;

    @FindBy(xpath = "//*[contains(@text,'PLAYERS')]")
    private WebElement PLAYERS_TAB;

    @FindBy(xpath = "//*[contains(@text,'NEWS')]")
    private WebElement NEWS_TAB;

    public static String TEAM_TO_SELECT = "//android.widget.TextView[contains(@text,'%s')]";

    public SearchResultPage() {
        PageFactory.initElements(driver,this);
    }

    public void selectTeam(String teamName) {
        findElementUsingXpath(String.format(TEAM_TO_SELECT,teamName)).click();
    }

    public void verifyPageOpen() {
        Assertions.assertTrue(ALL_TAB.isDisplayed() && TEAMS_TAB.isDisplayed() && PLAYERS_TAB.isDisplayed() && NEWS_TAB.isDisplayed()
                , "Search Result page is displayed");
    }
}
