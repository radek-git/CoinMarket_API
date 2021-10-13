package org.example.coinmarketcap;

import org.example.coingecko.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Datepicker extends BasePage {
    public Datepicker(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='tippy-box']")
    private WebElement datepickerContainer;

    @FindBy(xpath = "//div[@class='tippy-box']/div[@class='tippy-content']/div/div/div/div/div/div/div[@class='react-datepicker__month-container']/div/div/span[2]")
    private WebElement currentMonthAndYear;

    @FindBy(xpath = "//div[@class='react-datepicker__month']/div[@class='react-datepicker__week']/div[contains(@class, 'react-datepicker__day--today')]")
    private WebElement currentDayOnDatepicker;

    @FindBy(xpath = "//div[@class='react-datepicker__header react-datepicker__header--custom']/div/span[@class='icon-Chevron-left ']")
    private WebElement previousButton;

    @FindBy(xpath = "//div[@class='react-datepicker__header react-datepicker__header--custom']/div/span[@class='icon-Chevron-right ']")
    private WebElement nextButton;

    private final String DAY_OF_MONTH_ON_DATEPICKER = "//div[@class='react-datepicker__month']/div/div[contains(@class, 'react-datepicker__day') and text()='%s' and not(contains(@class, 'react-datepicker__day--outside-month'))]";

    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueButton;

    public String readCurrentMonthAndYear() {
        wait.until(visibilityOf(currentMonthAndYear));
        return currentMonthAndYear.getText();
    }


    public Datepicker selectMonthAndYearFrom(String date, String day) {
        while (!readCurrentMonthAndYear().equals(date)) {
            previousButton.click();
        }
        driver.findElement(By.xpath(String.format(DAY_OF_MONTH_ON_DATEPICKER, day))).click();
        return this;
    }

    public Datepicker selectMonthAndYearTo(String date, String day) {
        while (!readCurrentMonthAndYear().equals(date)) {
            nextButton.click();
        }
        driver.findElement(By.xpath(String.format(DAY_OF_MONTH_ON_DATEPICKER, day))).click();
        return this;
    }

    public CurrencyPage clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        return new CurrencyPage(driver);
    }




}
