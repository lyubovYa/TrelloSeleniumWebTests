package com.telRun;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{

    @Test
    public void boardCreationTest() throws InterruptedException {
        int before = app.getBoardsCount();
        app.clickOnPlusButton();
        app.selectCreateBoard();
        app.fiiBoardForm("plans for today", "public");
        app.confirmBoardCreation();
        app.returnOnHomePage();
        int after = app.getBoardsCount();
        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(after, before+1);
        //personal boards count before, after
    }


}

