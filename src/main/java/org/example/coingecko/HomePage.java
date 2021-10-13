package org.example.coingecko;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table/tbody/tr[./td[@data-sort='Bitcoin']/div/div[@class='center']/a[normalize-space(text())='Bitcoin']]/td[contains(@class, 'td-price')]/span")
    private WebElement bitcoinPriceSpan;


    public BigDecimal getPriceOfBitcoin() {
        wait.until(ExpectedConditions.visibilityOf(bitcoinPriceSpan));
        return new BigDecimal(bitcoinPriceSpan.getText().replace(" ", "")
                .replace("USD", ""). replace(",", "."));
    }
}
