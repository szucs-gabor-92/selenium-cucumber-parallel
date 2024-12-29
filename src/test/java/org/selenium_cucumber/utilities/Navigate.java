package org.selenium_cucumber.utilities;

import org.selenium_cucumber.pages.AddOrRemoveElementsPage;
import org.selenium_cucumber.pages.CheckboxesPage;
import org.selenium_cucumber.pages.ContextMenuPage;

import static org.selenium_cucumber.TestConstants.ADD_REMOVE_ELEMENTS_URL;
import static org.selenium_cucumber.TestConstants.CHECKBOXES_URL;
import static org.selenium_cucumber.TestConstants.CONTEXT_MENU_URL;
import static org.selenium_cucumber.TestConstants.LOGIN_URL;
import static org.selenium_cucumber.TestConstants.SHADOW_DOM_URL;
import static org.selenium_cucumber.stepdefinitions.TestBase.driver;
import static org.selenium_cucumber.stepdefinitions.TestBase.log;

/**
 * @author szucs-gabor-92 - 2024
 */
public class Navigate {

    /**
     * This method navigates to the add or remove element page
     */
    public static void toAddOrRemoveElementPage() {
        navigateToUrl(ADD_REMOVE_ELEMENTS_URL);
        Verify.elementIsPresentOnPage(AddOrRemoveElementsPage.addElementButton());
    }

    /**
     * This method navigates to the checkboxes page
     */
    public static void toCheckboxesPage() {
        navigateToUrl(CHECKBOXES_URL);
        Verify.elementIsPresentOnPage(CheckboxesPage.firstCheckbox());
    }

    /**
     * This method navigates to the context menu page
     */
    public static void toContextMenuPage() {
        navigateToUrl(CONTEXT_MENU_URL);
        Verify.elementIsPresentOnPage(ContextMenuPage.hotSpotBox());
    }

    /**
     * This method navigates to the login page
     */
    public static void toLoginPage() {
        navigateToUrl(LOGIN_URL);
    }

    /**
     * This method navigates to the shadow dom page
     */
    public static void toShadowDomPage() {
        navigateToUrl(SHADOW_DOM_URL);
    }

    private static void navigateToUrl(String url) {
        log.get().info("Navigating to page: {}", url);
        driver.get().get(url);
    }
}
