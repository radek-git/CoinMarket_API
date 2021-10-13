package org.example.coinmarketcap;

import org.example.coingecko.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@aria-expanded='false']/div[@class='sc-266vnq-0 fmdlWD']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='tippy-content']")
    private WebElement searchContainer;

    @FindBy(xpath = "//div[@class='tippy-content']/div/div/div/div/input")
    private WebElement searchInput;

    @FindBy(id = "cmc-cookie-policy-banner")
    private WebElement cookiesContainer;

    @FindBy(xpath = "//div[@id='cmc-cookie-policy-banner']/div[@class='cmc-cookie-policy-banner__close']")
    private WebElement closeCookiesButton;

    private final String CURRENCY_BY_NAME_XPATH = "//div[@role='tabpanel']/a/div/div[./p[text()='%s']]";


    public MainPage closeCookies() {
        wait.until(numberOfElementsToBe(By.id("cmc-cookie-policy-banner"), 1));
        wait.until(elementToBeClickable(closeCookiesButton)).click();
        return this;
    }

    public CurrencyPage searchCurrency(String currency) {
        wait.until(elementToBeClickable(searchField)).click();
        wait.until(visibilityOf(searchContainer));
        wait.until(elementToBeClickable(searchInput)).click();
        actions.sendKeys("BTC").build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
        return new CurrencyPage(driver);
    }
}
