package com.telRun.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isLoginErrorPresent() throws InterruptedException {
        Thread.sleep(6000);
        return isElementPresent(By.cssSelector("#login-error"));
    }

    public void login(String email, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        Thread.sleep(6000);
        typeByID("user", email);
        click(By.id("login"));
        Thread.sleep(6000);
        typeByID("password", password);
        click(By.id("login-submit"));


    }
}
