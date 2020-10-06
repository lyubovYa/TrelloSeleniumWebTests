package com.telRun;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;

public class CloseBoardTest extends TestBase {
    @BeforeClass
    public void openTrelloLoin() throws InterruptedException {
        app.openTrelloLoin();
    }

    @Test
    public void CloseBoardTest() throws InterruptedException {
        int before = getBoardsCount();
        openBoard();
        Thread.sleep(2000);
        //clickOnShowMenu();
        //clickOnBackButton();
        clickOnMore();
        clickOnCloseBoard();
        confirmCloseButton();
        permanentlyDeleteBoar();
        confirmDeleteBoard();
        returnOnHomePage();
        int after = getBoardsCount();
        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(before-1, after);
    }
    public int getBoardsCount() {
        int res = app.getBoardsCount();
        return res;
    }

    public void returnOnHomePage() {
        app.click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void confirmDeleteBoard() {
        app.click(By.cssSelector(".js-confirm.full.negate"));
    }

    public void permanentlyDeleteBoar() {
        app.click(By.cssSelector(".quiet.js-delete"));
    }

    public void confirmCloseButton() {
        app.click(By.cssSelector(".js-confirm.full.negate"));
    }

    public void clickOnCloseBoard() {
        app.click(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));
    }

    public void clickOnMore() {
        app.click(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
    }

    public void clickOnBackButton() throws InterruptedException {
        if (isElementPresentCustom(By.cssSelector(".board-menu-header-back-button.icon-lg.icon-back.js-pop-widget-view"))){
            app.click(By.cssSelector(".board-menu-header-back-button.icon-lg.icon-back.js-pop-widget-view"));
        }


    }

    public void clickOnShowMenu() throws InterruptedException {
//        if (isElementPresentCustom(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar"))) {
//            click(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar"));
//        }
//        if (isElementPresentCustom(By.cssSelector(".icon-sm.icon-overflow-menu-horizontal.board-header-btn-icon"))) {
            app.click(By.cssSelector(".icon-sm.icon-overflow-menu-horizontal.board-header-btn-icon111"));
//        }
    }
    public void  openBoard() {
        ///???? how to click on one of boards
        app.click(By.cssSelector(".board-tile-details.is-badged"));

        // .board-header-btn-text
    }

    private boolean isElementPresentCustom(By by){
        try{
            app.wd.findElement(by);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }



}
