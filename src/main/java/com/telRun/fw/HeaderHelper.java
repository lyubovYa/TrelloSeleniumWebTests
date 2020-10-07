package com.telRun.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase {
    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void selectCreateBoard() {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
    }

    public void returnOnHomePage() {
        waitForElement(By.cssSelector(".mod-list-add-button"), 30);
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void clickLogOut() {
        click(By.xpath("//button[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public void returnOnHomePage1() {
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }


    public boolean isAvatarPresent() throws InterruptedException {
        Thread.sleep(6000);
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }

    public void clickOnShowMenu() throws InterruptedException {
//        if (isElementPresent(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar"))) {
//            click(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar"));
//        }
//        if (isElementPresentBy.cssSelector(".icon-sm.icon-overflow-menu-horizontal.board-header-btn-icon"))) {
        click(By.cssSelector(".icon-sm.icon-overflow-menu-horizontal.board-header-btn-icon111"));
//        }
    }

    public void logout() {
        clickOnAvatar();
        clickLogOut();
    }
}
