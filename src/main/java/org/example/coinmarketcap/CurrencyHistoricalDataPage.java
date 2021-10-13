package org.example.coinmarketcap;

import org.example.coingecko.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CurrencyHistoricalDataPage extends BasePage {
    public CurrencyHistoricalDataPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class, 'eXPsOy') and contains(text(), 'Date')]")
    private WebElement dateRangeDropdownButton;




    public Datepicker clickDateRangeDropdown() {
        wait.until(visibilityOf(dateRangeDropdownButton));
        wait.until(elementToBeClickable(dateRangeDropdownButton)).click();
        return new Datepicker(driver);
    }


}
