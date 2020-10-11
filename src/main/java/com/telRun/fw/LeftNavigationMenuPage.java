package com.telRun.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftNavigationMenuPage extends HelperBase {
    public LeftNavigationMenuPage(WebDriver wd) {
        super(wd);
    }

    public void returnToBoardsPage(){
        waitForElementAndClick(By.cssSelector(".home-left-sidebar-container .icon-board"), 30);
    }
}
