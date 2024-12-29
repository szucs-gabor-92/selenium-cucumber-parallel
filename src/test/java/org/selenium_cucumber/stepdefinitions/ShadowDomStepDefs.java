package org.selenium_cucumber.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.selenium_cucumber.pages.ShadowDomPage;
import org.selenium_cucumber.utilities.Navigate;
import org.selenium_cucumber.utilities.Verify;
import org.selenium_cucumber.utilities.Wait;

import static org.selenium_cucumber.TestConstants.SHADOW_DOM_FIRST_PARAGRAPH;
import static org.selenium_cucumber.TestConstants.SHADOW_DOM_FIRST_PARAGRAPH_SHADOW;
import static org.selenium_cucumber.TestConstants.SHADOW_DOM_SECOND_PARAGRAPH;
import static org.selenium_cucumber.TestConstants.SHADOW_DOM_SECOND_PARAGRAPH_SHADOW;

/**
 * @author szucs-gabor-92 - 2024
 */
public class ShadowDomStepDefs {

    @Given("the user navigates to the shadow dom page")
    public void theUserNavigatesToTheShadowDomPage() {
        Navigate.toShadowDomPage();
    }

    @When("the page is loaded")
    public void thePageIsLoaded() {
        Wait.forElementToBeVisible(ShadowDomPage.header());
        Verify.elementIsPresentOnPage(ShadowDomPage.header());
    }

    @Then("the first paragraph appears with correct text")
    public void theFirstParagraphAppearsWithCorrectText() {
        Verify.elementHasText(ShadowDomPage.firstParagraph(), SHADOW_DOM_FIRST_PARAGRAPH);
        Verify.elementHasText(ShadowDomPage.firstParagraphShadow(), SHADOW_DOM_FIRST_PARAGRAPH_SHADOW);
    }

    @And("the second paragraph appears with correct text")
    public void theSecondParagraphAppearsWithCorrectText() {
        Verify.elementHasText(ShadowDomPage.secondParagraph(), SHADOW_DOM_SECOND_PARAGRAPH);
        Verify.elementHasText(ShadowDomPage.secondParagraphShadow(), SHADOW_DOM_SECOND_PARAGRAPH_SHADOW);
    }
}
