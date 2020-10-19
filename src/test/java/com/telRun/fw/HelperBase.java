package com.telRun.fw;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

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

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void uploadFile(By locator, File file) {
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
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

    public void waitForElementAndClick(By locator, int timeOut){
        new WebDriverWait(wd, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void waitForElementAndType(By locator, int timeOut, String text){
        if(text != null) {
            new WebDriverWait(wd, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }

    }

    public void takeScreenshot() {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screen = new File("screenshot-" + System.currentTimeMillis()+ ".png");

        try {
            Files.copy(tmp, screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
