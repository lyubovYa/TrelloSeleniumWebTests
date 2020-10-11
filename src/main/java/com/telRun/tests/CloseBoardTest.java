package com.telRun.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CloseBoardTest extends TestBase {

    @Test
    public void CloseBoardTest() throws InterruptedException {
        Thread.sleep(20000);
        int before = getBoardsCount();
        app.header().waitForElement(By.cssSelector(".board-tile-details.is-badged"), 20);
        app.board().openBoard();
        Thread.sleep(2000);
        app.board().clickOnBackButton();
        Thread.sleep(2000);
        app.header().clickOnShowMenu();
//        app.board().clickOnMore();
        app.board().clickOnCloseBoard();
        app.board().confirmCloseButton();
        app.board().permanentlyDeleteBoar();
        app.board().confirmDeleteBoard();
        app.header().returnOnHomePage();
        //app.leftNav().returnToBoardsPage();
        int after = getBoardsCount();
        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(before-1, after);
    }
    public int getBoardsCount() throws InterruptedException {
        int res = app.board().getBoardsCount();
        return res;
    }
    }

