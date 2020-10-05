package com.telRun;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{

    @BeforeClass
    public void openTrelloLoin() throws InterruptedException {
        setUp();
        login("lyubov.yapparova@gmail.com", "holopenio21");
    }

    @Test
    public void boardCreation() throws InterruptedException {
        clickOnPlusButton();
        selectCreateBoard();
        fiiBoardForm();
        confirmBoardCreation();
        returnOnHomePage();
    }

    private void returnOnHomePage() {
        click(By.xpath("//span[@aria-label='HouseIcon']"));
    }

    private void confirmBoardCreation() {
        click(By.cssSelector("._3UeOvlU6B5KUnS.uj9Ovoj4USRUQz._2MgouXHqRQDP_5"));
    }

    private void fiiBoardForm() {
        typeByXPATH("//*[@aria-label='Add board title']", "Plans for today");
    }

    private void selectCreateBoard() {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
    }

    private void clickOnPlusButton() {
        click(By.xpath("//button[@aria-label='Create Board or Team']"));
    }
}

