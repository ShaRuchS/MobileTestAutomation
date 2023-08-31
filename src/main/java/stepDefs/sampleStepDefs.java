package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import utility.BaseClass;

import java.net.MalformedURLException;

public class sampleStepDefs {
    @Given("User launches the score app")
    public void userLaunchesTheScoreApp() {
        BaseClass baseClass = new BaseClass();
        baseClass.getDriver();
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.waitForPageToLoad();
    }

    @When("User clicks on get started")
    public void userClicksOnGetStarted() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickGetStarted();
    }

    @And("User selects favorite league as {string}")
    public void userSelectsFavoriteLeague(String leagueName) {
        ChooseYourLeague chooseYourLeague = new ChooseYourLeague();
        chooseYourLeague.waitForPageToLoad();
        chooseYourLeague.selectLeague(leagueName);
        chooseYourLeague.clickContinue();
        chooseYourLeague.denyLocationPermission();
    }

    @And("User selects favorite team as {string}")
    public void userSelectsFavoriteTeam(String teamName) {
        ChooseYourTeam chooseYourTeam = new ChooseYourTeam();
        chooseYourTeam.waitForPageToLoad();
        chooseYourTeam.selectTeam(teamName);
    }

    @And("User finalizes notification preferences")
    public void userFinalizesNotificationPreferences() {
        NotificationSelection notificationSelection = new NotificationSelection();
        notificationSelection.waitForPageToLoad();
        notificationSelection.clickDone();
        notificationSelection.dismissModal();
    }

    @And("User searches for team {string}")
    public void userSearchesForTeam(String teamName) {
        FavoritesTab favoritesTab = new FavoritesTab();
        favoritesTab.waitForPageToLoad();
        favoritesTab.clickSearchBar();
        favoritesTab.searchText(teamName);
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.selectTeam(teamName);
    }

    @And("Verify that the team {string} details are displayed")
    public void verifyThatTheTeamDetailsAreDisplayed(String teamName) {
        TeamDetailsPage teamDetailsPage = new TeamDetailsPage();
        teamDetailsPage.waitForPageToLoad();
        teamDetailsPage.verifyTeamHeader(teamName);
    }

    @And("User selects Schedule tab")
    public void userSelectsScheduleTab() {
        TeamDetailsPage teamDetailsPage = new TeamDetailsPage();
        teamDetailsPage.selectScheduleTab();
    }

    @And("Verify that the team schedule is displayed")
    public void verifyThatTheTeamScheduleIsDisplayed() {
        TeamDetailsPage teamDetailsPage = new TeamDetailsPage();
        teamDetailsPage.verifyScheduleTab();
    }

    @And("User navigates back in the app")
    public void userNavigatesBackInTheApp() {
        BaseClass.driver.navigate().back();
    }

    @And("Verify that the user is navigated back to search results")
    public void verifyThatTheUserIsNavigatedBackToSearchResults() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.verifyPageOpen();
    }
}
