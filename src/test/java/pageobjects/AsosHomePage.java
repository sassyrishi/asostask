package pageobjects;

import org.apache.poi.util.SystemOutLogger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AsosHomePage extends BaseClass {

    public AsosHomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.ID, using = "txtSearch")
    public static WebElement search_box;

    @FindBy(how = How.CLASS_NAME, using = "go")
    public static WebElement search_button;

    @FindBy(how = How.XPATH, using = "//a[@href='#siteSelectorList']")
    public static WebElement locale_currency_menu;

    @FindBy(how = How.ID, using = "currencyList")
    public static WebElement currency_menu;

    @FindBy(how = How.XPATH, using = "//*[@data-imagesize='xl']")
    public static WebElement large_images;

    @FindBy(how = How.XPATH, using = "//*[@data-imagesize='l']")
    public static WebElement small_images;

    @FindBy(how = How.CSS, using = "div#results#four-grid")
    public static WebElement four_grid;


    //Type something in search box
    public void EnterSearch(String searchTerm) {
        search_box.sendKeys(searchTerm);
        search_button.click();
    }

    //Define Password Enter Method
    public static void SelectCurrency(String currency) {
        locale_currency_menu.click();
        Select localeMenu = new Select(locale_currency_menu);
        localeMenu.selectByValue(currency);
    }

    //Define Login Button Click Method
    public static void SelectCountry(String country) {
        locale_currency_menu.click();
        driver.findElement(By.partialLinkText(country)).click();
    }

    public static void countSearchResults(String searchString) {
        int size = driver.findElements(By.xpath("//*[contains(text()," + searchString + ")]")).size();
        Assert.assertTrue("Search results found", size >= 0);
    }

    public static void isFourGrid() {

        if (driver.findElements(By.cssSelector("div#results#four-grid")).size() != 0) {
            Assert.assertTrue("4 Grid found", false);

        }

    }

}