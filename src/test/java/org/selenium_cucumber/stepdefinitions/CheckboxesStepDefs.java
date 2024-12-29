package org.selenium_cucumber.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.selenium_cucumber.pages.CheckboxesPage;
import org.selenium_cucumber.utilities.Navigate;
import org.selenium_cucumber.utilities.Verify;

/**
 * @author szucs-gabor-92 - 2024
 */
public class CheckboxesStepDefs {

    @Given("the user navigates to the checkboxes page")
    public void theUserNavigatesToTheCheckboxesPage() {
        Navigate.toCheckboxesPage();
    }

    @And("the first checkbox is not selected")
    public void theFirstCheckboxIsNotSelected() {
        Verify.checkboxElementIsNotChecked(CheckboxesPage.firstCheckbox());
    }

    @And("the second checkbox is selected")
    public void theSecondCheckboxIsSelected() {
        Verify.checkboxElementIsChecked(CheckboxesPage.secondCheckbox());
    }

    @When("the user clicks on the first checkbox")
    public void theUserClicksOnTheFirstCheckbox() {
        CheckboxesPage.firstCheckbox().click();
    }

    @And("the user clicks on the second checkbox")
    public void theUserClicksOnTheSecondCheckbox() {
        CheckboxesPage.secondCheckbox().click();
    }

    @Then("the first checkbox is selected")
    public void theFirstCheckboxIsSelected() {
        Verify.checkboxElementIsChecked(CheckboxesPage.firstCheckbox());
    }

    @And("the second checkbox is not selected")
    public void theSecondCheckboxIsNotSelected() {
        Verify.checkboxElementIsNotChecked(CheckboxesPage.secondCheckbox());
    }
}
