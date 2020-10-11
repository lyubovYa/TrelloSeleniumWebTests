package com.telRun.tests;

import com.telRun.model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{

    @Test
    public void boardCreationTest() throws InterruptedException {
//        app.header().returnOnHomePageByLink();
//        app.board().selectBoardFromMenu();
        app.leftNav().returnToBoardsPage();
        int before = app.board().getBoardsCount();
        System.out.println("before is : " + before);
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        app.board().fiiBoardForm(new Board().withBoardName("plans for today").withTeamVisibility("public"));
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
//        app.header().returnOnHomePage();
//        app.board().selectBoardFromMenu();
        app.leftNav().returnToBoardsPage();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(after, before+1);
        //personal boards count before, after
    }


}

