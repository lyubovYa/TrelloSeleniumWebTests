package com.telRun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        int before = getBoardsCount();
        clickOnPlusButton();
        selectCreateBoard();
        fiiBoardForm("plans for today", "public");
        confirmBoardCreation();
        returnOnHomePage();
        int after = getBoardsCount();
        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(after, before+1);
        //personal boards count before, after
    }

    public int getBoardsCount() {
        int res = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
        return res;
    }

    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }
    public void selectCreateBoard() {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
    }
    public void fiiBoardForm(String boardName, String teamViseble) throws InterruptedException {
        typeByXPATH("//input[@data-test-id='create-board-title-input']", boardName);
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        click(By.cssSelector("._1uK2vQ_aMRS2NU"));
        //if(isElementPresent())
        //public or private
        click(By.cssSelector("._1Lkx3EjS3wCrs7"));
        click(By.xpath("//*[@name='"+ teamViseble +"']/../.."));
        //confirm public
        if(isElementPresent(By.cssSelector(".X6LMWvod566P68"))){
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }

    }
    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }
    public void returnOnHomePage() {
        new WebDriverWait(wd, 30)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".mod-list-add-button")));
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }


}

