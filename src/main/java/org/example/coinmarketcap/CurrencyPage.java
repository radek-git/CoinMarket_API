package org.example.coinmarketcap;

import org.example.coingecko.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;
import java.util.List;

public class CurrencyPage extends BasePage {
    public CurrencyPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[contains(@class, 'routeSwitcher')]/span/a[text()='Historical Data']")
    private WebElement historicalDataButton;

    @FindBy(xpath = "//div/table[contains(@class, 'cmc-table')]/tbody/tr")
    private List<WebElement> rows;

    private final String ROW_ON_INDEX = "//div/table[contains(@class, 'cmc-table')]/tbody/tr[%d]";

    private final String OPEN_PRICE_IN_ROW_ON_INDEX = "//div/table[contains(@class, 'cmc-table')]/tbody/tr[%d]/td[2]";

    public CurrencyHistoricalDataPage clickHistoricalDataButton() {
        wait.until(ExpectedConditions.visibilityOf(historicalDataButton));
        wait.until(ExpectedConditions.elementToBeClickable(historicalDataButton)).click();
        return new CurrencyHistoricalDataPage(driver);
    }

    public void readTrend() {
        String trendWzr = "Trend wzrostowy";
        String trendMalejacy = "Trend malejący";
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BigDecimal oldestPrice = new BigDecimal(driver.findElement(By.xpath(String.format(OPEN_PRICE_IN_ROW_ON_INDEX, rows.size()))).getText()
                .replace("$", "").replace(",", ""));
        BigDecimal newestPrice = new BigDecimal(driver.findElement(By.xpath(String.format(OPEN_PRICE_IN_ROW_ON_INDEX, 1))).getText()
                .replace("$", "").replace(",", ""));

        if (newestPrice.compareTo(oldestPrice) > 0) {
            System.out.println(trendWzr);
        } else {
            System.out.println(trendMalejacy);
        }
    }
}
