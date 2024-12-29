package org.selenium_cucumber.pages;

import org.openqa.selenium.WebElement;
import org.selenium_cucumber.utilities.Find;

/**
 * @author szucs-gabor-92 - 2024
 */
public class LoginPage {
    public static String logoutButtonLocator = "button secondary radius";
    public static String loginSubHeaderLocator = "subheader";

    public static WebElement usernameField() {
        return Find.elementById("username");
    }

    public static WebElement passwordField() {
        return Find.elementById("password");
    }

    public static WebElement loginButton() {
        return Find.elementByClass("radius");
    }

    public static WebElement logoutButton() {
        return Find.elementByCssSelector(".button.secondary.radius");
    }

    public static WebElement feedbackMessage() {
        return Find.elementById("flash");
    }

    public static WebElement loginSubHeader() {
        return Find.elementByClass(loginSubHeaderLocator);
    }
}
