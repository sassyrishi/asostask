package step_definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;


import cucumber.api.PendingException;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageobjects.AsosHomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AsosStepDefs {
    public WebDriver driver;

    public AsosStepDefs() {
        driver = Hooks.driver;
    }

    @Given("^I'm on ASOS Homepage$")
    public void i_m_on_ASOS_Homepage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://www.asos.com");
        PageFactory.initElements(driver, AsosHomePage.class);

    }


    @When("^I search for yellow t shirts in the Australian store$")
    public void i_search_for_yellow_t_shirts_in_the_Australian_store() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AsosHomePage.search_box.sendKeys("Yellow Tshirts");
        AsosHomePage.search_button.click();
    }

    @Then("^I should see some yellow t shirts$")
    public void i_should_see_some_yellow_t_shirts() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AsosHomePage.countSearchResults("Yellow");
    }

    @Given("^I have searched for yellows t shirts on the Australian store$")
    public void i_have_searched_for_yellows_t_shirts_on_the_Australian_store() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AsosHomePage.SelectCountry("Australia");
        AsosHomePage.search_box.sendKeys("Yellow Tshirts");
        AsosHomePage.search_button.click();

    }

    @Given("^I have some yellow t shirts displayed$")
    public void i_have_some_yellow_t_shirts_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AsosHomePage.countSearchResults("Yellow");
    }

    @When("^I organize them in (\\d+) columns$")
    public void i_organize_them_in_columns(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        AsosHomePage.small_images.click();
        TimeUnit.SECONDS.sleep(5);

    }

    @Then("^I should see some yellow t shirts organized in (\\d+) columns$")
    public void i_should_see_some_yellow_t_shirts_organized_in_columns(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AsosHomePage.isFourGrid();
    }

    @When("^I search for purple t shirts$")
    public void i_search_for_purple_t_shirts() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AsosHomePage.search_box.sendKeys("purple tshirts");
        AsosHomePage.search_button.click();
    }

    @Then("^I should see some purple t shirts$")
    public void i_should_see_some_purple_t_shirts() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AsosHomePage.countSearchResults("Purple");
    }


    @And("^I select Australia as locale$")
    public void iSelectAustraliaAsLocale() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AsosHomePage.SelectCountry("Australia");
    }

    @Then("^I choose one tshirt?$")
    public void i_choose_one_tshirt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AsosHomePage.tshirtlink.click();
    }

    @Then("^I save tshirt for later purchase?$")
    public void i_save_tshirt_for_later_purchase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AsosHomePage.saveLaterBtn.click();
    }

    @Then("^I click on saved items link?$")
    public void i_click_on_saved_items_link() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AsosHomePage.savedItemsLink.click();
        TimeUnit.SECONDS.sleep(5);

    }

    @Then("^I can see my saved tshirt$")
    public void i_can_see_my_saved_tshirt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Boolean itemFound = driver.getPageSource().contains("ASOS PLUS T-Shirt In Purple With Roll Sleeve");
        Assert.assertTrue("Items getting saved", itemFound);
    }
}