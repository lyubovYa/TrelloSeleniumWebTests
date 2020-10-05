package com.telRun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();

    }

    @BeforeClass
    public void setUp(){
     wd = new ChromeDriver();
     wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     wd.manage().window().maximize();
     wd.navigate().to("http://trello.com/");
    }

    public void logout() {
        clickOnAvatar();
        clickLogOut();
    }

    public void clickLogOut() {
        click(By.xpath("//button[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    @Test
    protected boolean isLoginErrorPresent() throws InterruptedException {
        Thread.sleep(6000);
        return isElementPresent(By.cssSelector("#error"));
    }

    public void login(String email, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        Thread.sleep(6000);
        type("user", email);
        click(By.id("login"));
        Thread.sleep(6000);
        type("password", password);
        click(By.id("login-submit"));
    }

    public void type(String locator, String text) {
        click(By.id(locator));
        wd.findElement(By.id(locator)).clear();
        wd.findElement(By.id(locator)).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isAvatarPresent() throws InterruptedException {
        Thread.sleep(6000);
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator) throws InterruptedException {
        Thread.sleep(6000);
        return wd.findElements(locator).size()>0;
    }
}
