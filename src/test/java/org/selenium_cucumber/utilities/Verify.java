package org.selenium_cucumber.utilities;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium_cucumber.stepdefinitions.TestBase;

import static org.selenium_cucumber.stepdefinitions.TestBase.log;
import static org.selenium_cucumber.stepdefinitions.TestBase.softAssert;

/**
 * @author szucs-gabor-92 - 2024
 */
public class Verify {
    /**
     * This method verifies a given element is displayed on the page
     *
     * @param element the element to look for
     */
    public static void elementIsPresentOnPage(WebElement element) {
        log.get().info("The element is present on page: {}", element);
        softAssert.get().assertTrue(element.isDisplayed());
        softAssert.get().assertAll();
    }

    /**
     * This method verifies a given element is not displayed on the page
     *
     * @param locator the element locator to look for
     */
    public static void elementIsNotPresentOnPage(String locator) {
        log.get().info("The element is not present on page: {}", locator);
        softAssert.get().assertTrue(!Objects.requireNonNull(TestBase.driver.get().getPageSource()).contains(locator));
        softAssert.get().assertAll();
    }

    /**
     * This method verifies that the correct number of elements are present on the page
     *
     * @param elements the elements to look for
     */
    public static void numberOfElementsArePresentOnPage(List<WebElement> elements, int count) {
        log.get().info("The number of elements for {} should be: {}", elements, count);
        softAssert.get().assertTrue(elements.size() == count);
        softAssert.get().assertAll();
    }

    /**
     * This method verifies that a checkbox element is checked
     *
     * @param element the element to look for
     */
    public static void checkboxElementIsChecked(WebElement element) {
        try {
            softAssert.get().assertTrue(ElementUtility.getElementAttributes(element).contains("checked"));
        } catch (Exception e) {
            softAssert.get().fail();
        } finally {
            softAssert.get().assertAll();
        }
    }

    /**
     * This method verifies that a checkbox element is not checked
     *
     * @param element the element to look for
     */
    public static void checkboxElementIsNotChecked(WebElement element) {
        try {
            softAssert.get().assertTrue(!ElementUtility.getElementAttributes(element).contains("checked"));
        } catch (Exception e) {
            softAssert.get().fail();
        } finally {
            softAssert.get().assertAll();
        }
    }

    /**
     * This method verifies that an element has the correct text
     *
     * @param element the element to look for
     * @param text    the text to look for
     */
    public static void elementHasText(WebElement element, String text) {
        log.get().info("The element {} has actual text: {}", element, element.getText());
        log.get().info("The element {} has expected text: {}", element, text);
        softAssert.get().assertEquals(element.getText(), text);
        softAssert.get().assertAll();
    }

    /**
     * This method verifies that no javascript alert is present
     */
    public static void alertIsNotPresent() {
        try {
            softAssert.get().assertTrue(ExpectedConditions.alertIsPresent().toString().isEmpty());
        } catch (Exception e) {
            softAssert.get().fail();
        } finally {
            softAssert.get().assertAll();
        }
    }

    /**
     * This method verifies that a javascript alert is present
     */
    public static void alertIsPresent() {
        try {
            softAssert.get().assertTrue(!ExpectedConditions.alertIsPresent().toString().isEmpty());
        } catch (Exception e) {
            softAssert.get().fail();
        } finally {
            softAssert.get().assertAll();
        }
    }

    /**
     * This method verifies that a javascript alert has the correct text
     */
    public static void alertHasCorrectText(String text) {
        try {
            softAssert.get().assertEquals(TestBase.driver.get().switchTo().alert().getText(), text);
        } catch (Exception e) {
            softAssert.get().fail();
        } finally {
            softAssert.get().assertAll();
        }
    }

    /**
     * This method verifies that the current page url is what it should be
     */
    public static void pageHasCorrectUrl(String expectedUrl) {
        softAssert.get().assertTrue(Objects.equals(TestBase.driver.get().getCurrentUrl(), expectedUrl));
        softAssert.get().assertAll();
    }
}
