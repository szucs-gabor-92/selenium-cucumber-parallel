package org.selenium_cucumber.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.selenium_cucumber.stepdefinitions.TestBase;
import org.testng.Reporter;

/**
 * @author szucs-gabor-92 - 2024
 */
public class ScreenshotUtility {
    /**
     * This method takes a screenshot in case of a failed test
     * @param scenario the scenario store that contains the test results
     */
    public static void takeScreenshotOfFailure(Scenario scenario) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
        String methodName = scenario.getName();
        File screenShotFile = null;
        if (scenario.isFailed()) {
            screenShotFile = ((TakesScreenshot) TestBase.driver.get()).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = "test-output";
                File destinationFile = new File(reportDirectory + "/failure_screenshots/" + methodName + "_" + formatter.format(calendar.getTime()) + ".png");
                FileUtils.copyFile(screenShotFile, destinationFile);
                Reporter.log("<a href='" + destinationFile.getAbsolutePath() + "'> <img src='" + destinationFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
