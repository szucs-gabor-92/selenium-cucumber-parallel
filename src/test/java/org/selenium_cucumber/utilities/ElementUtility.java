package org.selenium_cucumber.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.selenium_cucumber.stepdefinitions.TestBase;

/**
 * @author szucs-gabor-92 - 2024
 */
public class ElementUtility {

    /**
     * This method returns every element attribute as a string
     * @return the attribute list of the element as a string
     */
    public static String getElementAttributes(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) TestBase.driver.get();
        return executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; index++) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element).toString();
    }

    /**
     * This method right-clicks on an element
     */
    public static void rightClickOnElement(WebElement element){
        new Actions(TestBase.driver.get()).contextClick(element).perform();
    }
}
