package com.telRun;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{


    @Test
    public void boardCreation(){
        clickOnPlusButton();
        //selectCreateBoard();
        //fiiBoardForm();
        //confirmBoardCreation
        //returnOnHomePage
    }

    private void clickOnPlusButton() {
       click(By.cssSelector(".board-tile.mod-add"));
    }
}

