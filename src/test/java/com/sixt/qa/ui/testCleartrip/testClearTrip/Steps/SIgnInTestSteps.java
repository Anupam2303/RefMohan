package com.sixt.qa.ui.testCleartrip.testClearTrip.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@BddStepDefinition
public class SIgnInTestSteps {
    private WebDriver driver;

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Given("^URL to sign in on '(.*)'$")
    public void urlToSignInOnHttpsWwwCleartripCom(String URL) throws Throwable {
        driver = new ChromeDriver();
        driver.navigate().to(URL);
        waitFor(2000);
    }

    @And("^User click on your trips$")
    public void userClickOnYourTrips() throws Throwable {
        driver.findElement(By.id("userAccountLink")).click();
    }

    @Then("^Verify login section opens$")
    public void verifyLoginSectionOpens() throws Throwable {
        driver.findElement(By.id("SignIn")).click();
        waitFor(2000);
    }

    @And("^Click on Sign in button$")
    public void clickOnSignInButton() throws Throwable {
        driver.findElement(By.id("signInButton")).click();
        waitFor(2000);
    }

    @Then("^Verify errors '(.*)'$")
    public void verifyErrors(String errorMessage) throws Throwable {
        String errorText = driver.findElement(By.id("errors1")).getText();
        assertThat("Error text doesn't matches",errorText.contains(errorMessage), equalTo(true));
        driver.close();
    }

}
