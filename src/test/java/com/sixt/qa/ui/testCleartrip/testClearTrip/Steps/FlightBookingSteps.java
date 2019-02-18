package com.sixt.qa.ui.testCleartrip.testClearTrip.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@BddStepDefinition
@Component
public class FlightBookingSteps {
    
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

    @Given("^URL to book from '(.*)'$")
    public void urlToBookFromHttpsWwwCleartripCom(String URL) throws Throwable {
        driver = new ChromeDriver();
        driver.navigate().to(URL);
        waitFor(2000);
    }

    @And("^Select one way option$")
    public void selectOneWayOption() throws Throwable {
        driver.findElement(By.id("OneWay")).click();
    }

    @And("^User wants to travel from 'Bangalore' to 'Delhi'$")
    public void userWantsToTravelFromBangaloreToDelhi() throws Throwable {
        driver.findElement(By.id("FromTag")).clear();
        driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
        waitFor(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();
        waitFor(2000);
        driver.findElement(By.id("ToTag")).clear();
        driver.findElement(By.id("ToTag")).sendKeys("Delhi");
        waitFor(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();
    }

    @And("^User Pick any date$")
    public void userPickAnyDate() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"DepartDate\"]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[5]/a")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
        driver.findElement(By.xpath("//*[@id=\"ReturnDate\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[5]/a")).click();

    }

    @When("^User clicks on search button$")
    public void userClicksOnSearchButton() throws Throwable {
        driver.findElement(By.id("SearchBtn")).click();
    }

    @Then("^User is present with search results$")
    public void userIsPresentWithSearchResults() throws Throwable {
        waitFor(5000);
        assertThat(" Success is not true",isElementPresent(By.className("searchSummary")) , equalTo(true));
        driver.close();
    }

    @And("^Select two way option$")
    public void selectTwoWayOption() {
        driver.findElement(By.id("RoundTrip")).click();
    }

    @Then("^Verify user is on search result page$")
    public void verifyUserIsOnSearchResultPage() {
        String tittle = driver.getTitle();
        System.out.println(tittle);
        assertThat("Flight search page does not come up",tittle,equalTo("#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities."));
    }

    @Then("^User clicks on book button$")
    public void userClicksOnBookButton() {
        WebElement bookButton = driver.findElement(By.xpath("//button[@class=\"booking fRight\"][0]"));
        Actions action = new Actions(driver);
        action.moveToElement(bookButton).click().build().perform();
    }
}
