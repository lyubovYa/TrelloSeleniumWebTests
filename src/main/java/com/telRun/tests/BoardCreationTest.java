package com.telRun.tests;

import com.telRun.model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{

    @Test
    public void boardCreationTest() throws InterruptedException {
        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        app.board().fiiBoardForm(new Board().withBoardName("plans for today").withTeamVisibility("public"));
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(after, before+1);
        //personal boards count before, after
    }


}

