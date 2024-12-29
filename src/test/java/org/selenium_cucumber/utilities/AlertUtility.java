package org.selenium_cucumber.utilities;

import org.selenium_cucumber.stepdefinitions.TestBase;


/**
 * @author szucs-gabor-92 - 2024
 */
public class AlertUtility {

    /**
     * This method accepts the javascript alert present on the page
     */
    public static void acceptAlert() {
        TestBase.driver.get().switchTo().alert().accept();
    }
}
