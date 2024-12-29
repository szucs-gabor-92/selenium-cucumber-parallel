package org.selenium_cucumber.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.selenium_cucumber.pages.LoginPage;
import org.selenium_cucumber.utilities.Navigate;
import org.selenium_cucumber.utilities.Verify;

import static org.selenium_cucumber.TestConstants.LOGIN_SECURE_AREA_TEXT;
import static org.selenium_cucumber.TestConstants.LOGIN_SUCCESS_URL;
import static org.selenium_cucumber.TestConstants.LOGIN_TEXT;
import static org.selenium_cucumber.TestConstants.LOGIN_URL;
import static org.selenium_cucumber.TestConstants.LOGOUT_TEXT;

/**
 * @author szucs-gabor-92 - 2024
 */
public class LoginStepDefs {

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        Navigate.toLoginPage();
    }

    @And("the user fills out the username field with 'username'")
    public void theUserFillsOutTheUsernameFieldWithUsername(DataTable loginData) {
        String username = loginData.asMaps(String.class, String.class).get(0).get("value");
        LoginPage.usernameField().sendKeys(username);
    }

    @And("the user fills out the password field with 'password'")
    public void theUserFillsOutThePasswordFieldWithPassword(DataTable loginData) {
        String password = loginData.asMaps(String.class, String.class).get(0).get("value");
        LoginPage.passwordField().sendKeys(password);
    }

    @When("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        LoginPage.loginButton().click();
    }


    @Then("the error message 'error' appears")
    public void theErrorMessageErrorAppears(DataTable errorData) {
        String errorMessage = errorData.asMaps(String.class, String.class).get(0).get("value");
        Verify.elementHasText(LoginPage.feedbackMessage(), errorMessage);
    }

    @And("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        Verify.elementHasText(LoginPage.feedbackMessage(), LOGIN_TEXT);
        Verify.elementHasText(LoginPage.loginSubHeader(), LOGIN_SECURE_AREA_TEXT);
        Verify.elementIsPresentOnPage(LoginPage.logoutButton());
        Verify.pageHasCorrectUrl(LOGIN_SUCCESS_URL);
    }

    @When("the user clicks on the logout button")
    public void theUserClicksOnTheLogoutButton() {
        LoginPage.logoutButton().click();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        Verify.elementHasText(LoginPage.feedbackMessage(), LOGOUT_TEXT);
        Verify.elementIsNotPresentOnPage(LoginPage.logoutButtonLocator);
        Verify.pageHasCorrectUrl(LOGIN_URL);
    }
}
