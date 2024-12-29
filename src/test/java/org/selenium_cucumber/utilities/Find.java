package org.selenium_cucumber.utilities;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.selenium_cucumber.TestConstants.TOTAL_RETRY_COUNT;
import static org.selenium_cucumber.stepdefinitions.TestBase.driver;
import static org.selenium_cucumber.stepdefinitions.TestBase.log;

/**
 * @author szucs-gabor-92 - 2024
 */
public class Find {

    /**
     * This method finds an element by its id
     *
     * @param id the id to look for
     * @return the method returns a web element
     */
    public static WebElement elementById(final String id) {
        log.get().info("Finding element by id: {}", id);
        return handleStaleElement(() -> Wait.forElementToBeVisible(driver.get().findElement(By.id(id))));
    }

    /**
     * This method finds an element by its text
     *
     * @param text the text to look for
     * @return the method returns a web element
     */
    public static WebElement elementByText(final String text) {
        log.get().info("Finding element by text: {}", text);
        return handleStaleElement(() -> Wait.forElementToBeVisible(driver.get().findElement(By.xpath("//*[text()='" + text + "']"))));
    }

    /**
     * This method finds an element by its class name
     *
     * @param className the class name to look for
     * @return the method returns a list of web elements
     */
    public static WebElement elementByClass(final String className) {
        log.get().info("Finding element by class name: {}", className);
        return handleStaleElement(() -> driver.get().findElement(By.className(className)));
    }

    /**
     * This method finds an element by css selector
     *
     * @param cssSelector the css selector to look for
     * @return the method returns a list of web elements
     */
    public static WebElement elementByCssSelector(final String cssSelector) {
        log.get().info("Finding element by css selector: {}", cssSelector);
        return handleStaleElement(() -> driver.get().findElement(By.cssSelector(cssSelector)));
    }

    /**
     * This method finds elements by their class name
     *
     * @param className the class name to look for
     * @return the method returns a list of web elements
     */
    public static List<WebElement> elementsByClass(final String className) {
        log.get().info("Finding elements by class name: {}", className);
        handleStaleElement(() -> Wait.forElementToBeVisible(driver.get().findElements(By.className(className)).get(0)));
        return handleStaleElement(() -> driver.get().findElements(By.className(className)));
    }

    /**
     * This method finds elements by their type
     *
     * @param attribute      the attribute to look for
     * @param attributeValue the attribute value to look for
     * @return the method returns a list of web elements
     */
    public static List<WebElement> elementsByAttributeValue(String attribute, String attributeValue) {
        log.get().info("Finding elements by attribute-value: {}-{}", attribute, attributeValue);
        handleStaleElement(() -> Wait.forElementToBeVisible(driver.get().findElements(By.cssSelector("[" + attribute + "='" + attributeValue + "']")).get(0)));
        return handleStaleElement(() -> driver.get().findElements(By.cssSelector("[" + attribute + "='" + attributeValue + "']")));
    }

    /**
     * This method finds elements by the given locator
     *
     * @param by the locator to look for
     * @return the method returns a list of web elements
     */
    public static List<WebElement> elements(By by) {
        log.get().info("Finding elements by locator: {}", by);
        return handleStaleElement(() -> driver.get().findElements(by));
    }

    /**
     * This method handles stale and no such element exceptions
     * if it catches one of these elements it will try to find the element again
     * for a total times set by TOTAL_RETRY_COUNT
     *
     * @param block the method we want to stabilize
     * @return the method itself is returned
     */
    private static <T> T handleStaleElement(final Supplier<T> block) {
        for (int i = 0; i < TOTAL_RETRY_COUNT; ++i) {
            try {
                return block.get();
            } catch (final StaleElementReferenceException | NoSuchElementException ex) {
                log.get().error("Got stale or no such element exception: " + ex);
            }
        }
        Assert.fail("Retries exhausted");
        return null;
    }
}
