package com.telRun.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver wd;
    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void typeByID(String locator, String text) {
        click(By.id(locator));
        wd.findElement(By.id(locator)).clear();
        wd.findElement(By.id(locator)).sendKeys(text);
    }

    public void typeByXPATH(String locator, String text) {
        click(By.xpath(locator));
        wd.findElement(By.xpath(locator)).clear();
        wd.findElement(By.xpath(locator)).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) throws InterruptedException {
        Thread.sleep(6000);
        return wd.findElements(locator).size()>0;
    }

    public void waitForElement(By locator, int timeOut){
        new WebDriverWait(wd, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
