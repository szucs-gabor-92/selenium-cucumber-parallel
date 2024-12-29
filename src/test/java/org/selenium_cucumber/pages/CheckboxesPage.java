package org.selenium_cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.selenium_cucumber.utilities.Find;

/**
 * @author szucs-gabor-92 - 2024
 */
public class CheckboxesPage {

    public static WebElement firstCheckbox() {
        return checkBoxes().get(0);
    }

    public static WebElement secondCheckbox() {
        return checkBoxes().get(1);
    }

    private static List<WebElement> checkBoxes() {
        return Find.elementsByAttributeValue("type", "checkbox");
    }
}
