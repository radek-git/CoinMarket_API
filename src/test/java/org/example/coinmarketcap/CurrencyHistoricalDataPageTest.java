package org.example.coinmarketcap;

import org.example.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrencyHistoricalDataPageTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    public void before() {
        driver.get("https://coinmarketcap.com/");
        mainPage = new MainPage(driver);
    }


    @Test
    public void test() {
        mainPage.closeCookies()
                .searchCurrency("BTC")
                .clickHistoricalDataButton()
                .clickDateRangeDropdown()
                .selectMonthAndYearFrom("January 2018", "10")
                .selectMonthAndYearTo("April 2021", "30")
                .clickContinueButton()
                .readTrend();


    }
}
