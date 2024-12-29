package org.selenium_cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.selenium_cucumber.utilities.Find;

/**
 * @author szucs-gabor-92 - 2024
 */
public class ShadowDomPage {

    public static By paragraphHost = By.tagName("my-paragraph");

    public static WebElement header() {
        return Find.elementById("content");
    }

    public static WebElement firstParagraph() {
        return Find.elements(paragraphHost).get(0);
    }

    public static WebElement secondParagraph() {
        return Find.elements(paragraphHost).get(1);
    }

    public static WebElement firstParagraphShadow() {
        WebElement host = firstParagraph();
        SearchContext root = host.getShadowRoot();
        return root.findElement(By.name("my-text"));
    }

    public static WebElement secondParagraphShadow() {
        WebElement host = secondParagraph();
        SearchContext root = host.getShadowRoot();
        return root.findElement(By.name("my-text"));
    }
}
