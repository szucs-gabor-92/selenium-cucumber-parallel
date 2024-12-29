package org.selenium_cucumber.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.selenium_cucumber.pages.AddOrRemoveElementsPage;
import org.selenium_cucumber.utilities.Navigate;
import org.selenium_cucumber.utilities.Verify;

/**
 * @author szucs-gabor-92 - 2024
 */
public class AddOrRemoveElementsStepDefs {
    public int numberOfElements;

    @Given("the user navigates to the add or remove element page")
    public void theUserNavigatesToTheAddOrRemoveElementPage() {
        Navigate.toAddOrRemoveElementPage();
    }

    @And("the user clicks on the add element button 'count' times")
    public void theUserClicksOnTheAddElementButtonCountTimes(DataTable count) {
        numberOfElements = Integer.parseInt(count.asMaps(String.class, String.class).get(0).get("value"));
        AddOrRemoveElementsPage.addNumberOfElements(numberOfElements);
    }

    @And("the correct number of delete element buttons appears on the page")
    public void theCorrectNumberOfDeleteElementButtonsAppearsOnThePage() {
        Verify.numberOfElementsArePresentOnPage(AddOrRemoveElementsPage.deleteButtons(), numberOfElements);
    }

    @When("the user clicks on the delete button 'count' times")
    public void theUserClicksOnTheDeleteButtonCountTimes(DataTable count) {
        numberOfElements = Integer.parseInt(count.asMaps(String.class, String.class).get(0).get("value"));
        AddOrRemoveElementsPage.deleteNumberOfElements(numberOfElements);
    }

    @Then("the elements disappear")
    public void theElementsDisappear() {
        Verify.numberOfElementsArePresentOnPage(AddOrRemoveElementsPage.deleteButtons(), 0);
    }
}
