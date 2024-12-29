package org.selenium_cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * @author szucs-gabor-92 - 2024
 */
@CucumberOptions(tags = "@SmokeTests", features = {"features"}, glue = {"org/selenium_cucumber/stepdefinitions"})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
