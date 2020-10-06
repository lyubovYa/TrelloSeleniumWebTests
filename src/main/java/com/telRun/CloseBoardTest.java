package com.telRun;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;

public class CloseBoardTest extends TestBase {
    @BeforeClass
    public void openTrelloLoin() throws InterruptedException {
        setUp();
        login("lyubov.yapparova@gmail.com", "holopenio21");
    }

    @Test
    public void CloseBoardTest() throws InterruptedException {
        int before = getBoardsCount();
        openBoard();
        Thread.sleep(2000);
//        clickOnShowMenu();
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
        int res = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
        return res;
    }

    private void returnOnHomePage() {
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void confirmDeleteBoard() {
        click(By.cssSelector(".js-confirm.full.negate"));
    }

    public void permanentlyDeleteBoar() {
        click(By.cssSelector(".quiet.js-delete"));
    }

    public void confirmCloseButton() {
        click(By.cssSelector(".js-confirm.full.negate"));
    }

    public void clickOnCloseBoard() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));
    }

    public void clickOnMore() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
    }

    public void clickOnBackButton() throws InterruptedException {
        if (isElementPresentCustom(By.cssSelector(".board-menu-header-back-button.icon-lg.icon-back.js-pop-widget-view"))){
            click(By.cssSelector(".board-menu-header-back-button.icon-lg.icon-back.js-pop-widget-view"));
        }


    }

    public void clickOnShowMenu() throws InterruptedException {
//        if (isElementPresentCustom(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar"))) {
//            click(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar"));
//        }
//        if (isElementPresentCustom(By.cssSelector(".icon-sm.icon-overflow-menu-horizontal.board-header-btn-icon"))) {
            click(By.cssSelector(".icon-sm.icon-overflow-menu-horizontal.board-header-btn-icon111"));
//        }
    }
    public void  openBoard() {
        ///???? how to click on one of boards
        click(By.cssSelector(".board-tile-details.is-badged"));

        // .board-header-btn-text
    }

    private boolean isElementPresentCustom(By by){
        try{
            wd.findElement(by);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }



}
