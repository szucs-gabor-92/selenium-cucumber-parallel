package org.selenium_cucumber.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.selenium_cucumber.pages.ContextMenuPage;
import org.selenium_cucumber.utilities.AlertUtility;
import org.selenium_cucumber.utilities.ElementUtility;
import org.selenium_cucumber.utilities.Navigate;
import org.selenium_cucumber.utilities.Verify;

import static org.selenium_cucumber.TestConstants.CONTEXT_MENU_ALERT_TEXT;

/**
 * @author szucs-gabor-92 - 2024
 */
public class ContextMenuStepDefs {

    @Given("the user navigates to the context menu page")
    public void theUserNavigatesToTheContextMenuPage() {
        Navigate.toContextMenuPage();
    }

    @And("the alert is not present on the page")
    public void theAlertIsNotPresentOnThePage() {
        Verify.alertIsNotPresent();
    }

    @When("the user right clicks on the hotspot")
    public void theUserRightClicksOnTheHotspot() {
        ElementUtility.rightClickOnElement(ContextMenuPage.hotSpotBox());
    }

    @Then("the javascript alert appears with correct text")
    public void theJavascriptAlertAppearsWithCorrectText() {
        Verify.alertHasCorrectText(CONTEXT_MENU_ALERT_TEXT);
    }

    @And("the alert is accepted")
    public void theAlertIsAccepted() {
        AlertUtility.acceptAlert();
    }

    @And("the alert disappears")
    public void theAlertDisappears() {
        Verify.alertIsNotPresent();
    }
}
