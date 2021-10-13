package org.example.coingecko;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public void clickButton(WebElement button) {
        button.click();
    }

    public void inputTextInField(String text, WebElement element) {
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(String xpath) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForClickable(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
    }

    public void waitForVisibleOrClickable(WebElement element) {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.elementToBeClickable(element)));
    }

    public void waitForVisibleOrClickable(String xpath) {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))),
                ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath)))));
    }

    public void clickElementWithGivenName(String xpath, String name) {

    }

    public void waitForMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
