package org.selenium_cucumber.pages;

import org.openqa.selenium.WebElement;
import org.selenium_cucumber.utilities.Find;

/**
 * @author szucs-gabor-92 - 2024
 */
public class ContextMenuPage {

    public static WebElement hotSpotBox() {
        return Find.elementById("hot-spot");
    }
}
