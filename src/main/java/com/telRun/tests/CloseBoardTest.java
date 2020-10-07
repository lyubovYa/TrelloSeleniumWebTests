package com.telRun.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloseBoardTest extends TestBase {

    @BeforeClass
    public void openTrelloLoin() throws InterruptedException {
        //app.openTrelloLoin();
        app.init();
        app.session().login("lyubov.yapparova@gmail.com", "holopenio21");
    }

    @Test
    public void CloseBoardTest() throws InterruptedException {
        int before = getBoardsCount();
        app.board().openBoard();
        Thread.sleep(2000);
        app.header().clickOnShowMenu();
        app.board().clickOnBackButton();
        app.board().clickOnMore();
        app.board().clickOnCloseBoard();
        app.board().confirmCloseButton();
        app.board().permanentlyDeleteBoar();
        app.board().confirmDeleteBoard();
        app.header().returnOnHomePage1();
        int after = getBoardsCount();
        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(before-1, after);
    }
    public int getBoardsCount() {
        int res = app.board().getBoardsCount();
        return res;
    }
    }

