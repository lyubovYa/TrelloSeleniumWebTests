package com.telRun.tests;

import com.telRun.model.Board;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTest extends TestBase{

    @Test(dataProvider =  "validBoards", dataProviderClass = DataProviders.class)
    public void boardCreationTestFromDataProvider(String boardName, String boardVisibility) throws InterruptedException {
//        app.header().returnOnHomePageByLink();
//        app.board().selectBoardFromMenu();
        Thread.sleep(10000);
        app.leftNav().returnToBoardsPage();
        int before = app.board().getBoardsCount();
        System.out.println("before is : " + before);
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        Board board = new Board()
                .withBoardName(boardName)
                .withBoardVisibility(boardVisibility);
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
        app.board().fiiBoardForm(board);
        app.header().returnOnHomePageFromBoard();
//        app.header().returnOnHomePage();
//        app.board().selectBoardFromMenu();
        app.leftNav().returnToBoardsPage();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(after, before+1);
        //personal boards count before, after
    }

    @Test(dataProvider =  "validBoardsFromCSV", dataProviderClass = DataProviders.class)
    public void boardCreationTestFromCSV(Board board) throws InterruptedException {
//        app.header().returnOnHomePageByLink();
//        app.board().selectBoardFromMenu();
        Thread.sleep(10000);
        app.leftNav().returnToBoardsPage();
        int before = app.board().getBoardsCount();
        System.out.println("before is : " + before);
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
//        Board board = new Board()
//                .withBoardName(boardName)
//                .withBoardVisibility(boardVisibility);
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
        app.board().fiiBoardForm(board);
        app.header().returnOnHomePageFromBoard();
//        app.header().returnOnHomePage();
//        app.board().selectBoardFromMenu();
        app.leftNav().returnToBoardsPage();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(after, before+1);
        //personal boards count before, after
    }

    @Test
    public void boardCreationTest() throws InterruptedException {
//        app.header().returnOnHomePageByLink();
//        app.board().selectBoardFromMenu();
        Thread.sleep(10000);
        app.leftNav().returnToBoardsPage();
        int before = app.board().getBoardsCount();
        System.out.println("before is : " + before);
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        app.board().fiiBoardForm(new Board().withBoardName("plans for today").withBoardVisibility("public"));
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

