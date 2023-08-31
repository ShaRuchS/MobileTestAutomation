package pages;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

import java.time.Duration;

public class FavoritesTab extends BaseClass {

    @FindBy(id = "search_bar_text_view")
    private WebElement SEARCH_BAR;

    @FindBy(id = "search_src_text")
    private WebElement SEARCH_INPUT;

    public FavoritesTab() {
        PageFactory.initElements(driver,this);
    }

    public void clickSearchBar() {
        SEARCH_BAR.click();
    }

    public void waitForPageToLoad() {
        waitForElementPresent(SEARCH_BAR, Duration.ofSeconds(2));
    }

    public void searchText(String teamName) {
        waitForElementPresent(SEARCH_INPUT,Duration.ofSeconds(2));
        SEARCH_INPUT.sendKeys(teamName);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
