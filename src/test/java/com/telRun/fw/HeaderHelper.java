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

    public void returnOnHomePageFromBoard() {
        waitForElement(By.cssSelector(".mod-list-add-button"), 30);
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void clickLogOut() {
        click(By.xpath("//button[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public void returnOnHomePageFromTeam() {
        waitForElement(By.cssSelector(".tabbed-pane-header-content"), 30);
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void returnOnHomePage() throws InterruptedException {
        waitForElementAndClick(By.cssSelector("[data-test-id='header-home-button']"),20);
        System.out.println("I am on the home page :)");
    }

    public void returnOnHomePageByLink() throws InterruptedException {
        waitForElementAndClick(By.cssSelector("[data-test-id='home-link']"),20);
        System.out.println("I am on the home page from link :)");
    }

    public boolean isAvatarPresent() throws InterruptedException {
        Thread.sleep(6000);
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }

    public void clickOnShowMenu() throws InterruptedException {
        if (!isElementPresent(By.cssSelector(".board-menu-navigation-item-link.js-open-stickers"))) {
            System.out.println("Sticker was not found");
            click(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar"));
            click(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
        } else {
//            System.out.println("Sticker was found");
            click(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
//            System.out.println("Sticker was found11");
        }
//        if (isElementPresent(By.cssSelector(".icon-sm.icon-overflow-menu-horizontal.board-header-btn-icon"))) {
//            click(By.cssSelector(".icon-sm.icon-overflow-menu-horizontal.board-header-btn-icon111"));
////        }
//        }
    }

    public void logout() {
        clickOnAvatar();
        clickLogOut();
    }

    public void openProfile() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }
}
