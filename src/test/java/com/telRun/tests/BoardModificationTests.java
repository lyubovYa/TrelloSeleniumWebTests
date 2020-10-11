package com.telRun.tests;

import com.telRun.model.Board;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {

    @Test
    public void modifyBoardTest() throws InterruptedException {
        //enter to the first
        //app.header().returnOnHomePage();
        app.board().selectBoardFromMenu();
        app.board().clickOnTheFirstBoard();
        app.board().renameBoard(new Board().withBoardName("renamedBoard"));
        app.header().returnOnHomePage();
    }

}

