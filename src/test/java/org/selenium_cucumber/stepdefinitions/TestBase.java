package org.selenium_cucumber.stepdefinitions;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium_cucumber.utilities.ScreenshotUtility;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import static org.selenium_cucumber.TestConstants.WAIT_INTERVAL_IN_SECONDS;

/**
 * @author szucs-gabor-92 - 2024
 */
public class TestBase {
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    public static final ThreadLocal<Logger> log = new ThreadLocal<>();
    public static final ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();

    @Before
    public void suiteSetup() throws IOException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser"));
        desiredCapabilities.setPlatform(Platform.valueOf(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platform")));

        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities));
        driver.get().manage().window().maximize();
        wait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(WAIT_INTERVAL_IN_SECONDS)));
        log.set(LogManager.getLogger(TestBase.class));
        softAssert.set(new SoftAssert());
    }

    @After
    public static void suiteCleanUp(Scenario scenario) {
        ScreenshotUtility.takeScreenshotOfFailure(scenario);
        try {
            driver.get().quit();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        driver.remove();
        wait.remove();
        log.remove();
        softAssert.remove();
    }
}
