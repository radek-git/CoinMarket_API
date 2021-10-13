package org.example;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.example.coingecko.HomePage;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CoinMarketTest extends BaseTest {

    private HomePage homePage;

    private final String URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map";
    private final String HEADER = "X-CMC_PRO_API_KEY";
    private final String API_KEY = "19bf797e-d279-4cef-a481-35f953b3d607";


    @BeforeMethod
    public void before() {
        driver.get("https://www.coingecko.com/pl");
        homePage = new HomePage(driver);
    }


    @Test
    public void MapOfCoinMarket() {
        CryptocurrencyMapResponse response = given().header(HEADER, API_KEY)
                .when()
                .get(URL)
                .then()
                .extract().as(CryptocurrencyMapResponse.class);

        System.out.println(response);

    }

    @Test
    public void shouldVerifyThat5ElementsIsDisplayedOnPage() {
        CryptocurrencyMapResponse response = given().header(HEADER, API_KEY)
                .when()
                .get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/map?start=1&limit=5")
                .then()
                .and()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(CryptocurrencyMapResponse.class);

        assertEquals(response.getDatum().size(), 5);
    }


    @Test
    public void shouldVerifyThatResultsAreSortedByRank() {
        int elementsPerPage = 5;
        CryptocurrencyMapResponse response = given().header(HEADER, API_KEY)
                .when()
                .get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/map?start=1&limit=" + elementsPerPage + "&sort=cmc_rank")
                .then()
                .and()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(CryptocurrencyMapResponse.class);

        long lastRankOnFirstPage = response.getDatum().get(response.getDatum().size() - 1).getRank();

        CryptocurrencyMapResponse response1 = given().header(HEADER, API_KEY)
                .when()
                .get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/map?start=6&limit=5&sort=cmc_rank")
                .then()
                .and()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(CryptocurrencyMapResponse.class);

        long firstRankOnSecondPage = response1.getDatum().get(0).getRank();

        assertEquals(firstRankOnSecondPage, lastRankOnFirstPage + 1);
    }

    @Test
    public void shouldComparePrices() {
        ListingHistoricalResponse response = given().header(HEADER, API_KEY)
                .when()
                .get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract().as(ListingHistoricalResponse.class);

        double price = response.getData().get(0).getQuote().getUsd().getPrice();
        BigDecimal priceOfBitcoin2 = new BigDecimal(price);

        BigDecimal priceOfBitcoin1 = homePage.getPriceOfBitcoin();
        System.out.println(priceOfBitcoin1);
        System.out.println(priceOfBitcoin2);

        Assert.assertEquals(priceOfBitcoin1.floatValue(), priceOfBitcoin2.floatValue(), 100);

        System.out.println(price);
    }
}
