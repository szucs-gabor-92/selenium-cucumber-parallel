package org.selenium_cucumber.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium_cucumber.utilities.Find;
import org.selenium_cucumber.utilities.Wait;

/**
 * @author szucs-gabor-92 - 2024
 */
public class AddOrRemoveElementsPage {

    public static By deleteButtonClass = By.className("added-manually");

    public static WebElement addElementButton() {
        return Find.elementByText("Add Element");
    }

    public static List<WebElement> deleteButtons() {
        return Find.elements(deleteButtonClass);
    }

    public static void addNumberOfElements(int count) {
        for (int i = 0; i <= count - 1; i++) {
            addElementButton().click();
            Wait.forElementsToBeVisible(deleteButtonClass, i + 1);
        }
    }

    public static void deleteNumberOfElements(int count) {
        for (int i = 0; i <= count - 1; i++) {
            deleteButtons().get(0).click();
            Wait.forElementsToBeVisible(deleteButtonClass, count - (i + 1));
        }
    }
}
