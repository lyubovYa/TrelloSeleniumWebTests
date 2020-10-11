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
    @DataProvider
    public Iterator<Object[]>validBoards(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"1DataProboard}", "public"});
        list.add(new Object[]{"3DataProboard}", "public"});
        list.add(new Object[]{"1Data8796546}", "public"});
        list.add(new Object[]{"5DataProboard}", "public"});

        return list.iterator();

    }

   @DataProvider
   public Iterator<Object[]>validBoardsFromCSV() throws IOException {
       List<Object[]> list = new ArrayList<>();
       BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/boards1/csv")));
       String line = reader.readLine();
       while(line != null){
           String [] split = line.split(",");
           list.add(new Object[]{new Board().withBoardName(split[0]).withBoardVisibility(split[1])});
           line = reader.readLine();
       }
    return list.iterator();
   }


    @Test(dataProvider =  "validBoards")
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

    @Test(dataProvider =  "validBoardsFromCSV")
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

