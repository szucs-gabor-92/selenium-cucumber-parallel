package org.selenium_cucumber.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.selenium_cucumber.stepdefinitions.TestBase.log;
import static org.selenium_cucumber.stepdefinitions.TestBase.wait;

/**
 * @author szucs-gabor-92 - 2024
 */
public class Wait {

    /**
     * This method waits until the given element is visible
     *
     * @param element the element to wait for
     * @return this method returns a web element
     */
    public static WebElement forElementToBeVisible(WebElement element) {
        log.get().info("Waiting until element is present on page: {}", element);
        return wait.get().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method waits until the given number of elements are visible
     *
     * @param elementLocator the elements to wait for
     */
    public static void forElementsToBeVisible(By elementLocator, int expectedNumberOfElements) {
        log.get().info("Waiting until [{}] elements are present on page {} times", elementLocator, expectedNumberOfElements);
        wait.get().until(ExpectedConditions.numberOfElementsToBe(elementLocator, expectedNumberOfElements));
    }
}
