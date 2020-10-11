package com.telRun.fw;

import com.telRun.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void fiiBoardForm(Board board) throws InterruptedException {
        typeByXPATH("//input[@data-test-id='create-board-title-input']", board.getBoardName());
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        click(By.cssSelector("._1uK2vQ_aMRS2NU"));
        //if(isElementPresent())
        //public or private
        click(By.cssSelector("._1Lkx3EjS3wCrs7"));
        click(By.xpath("//*[@name='" + board.getTeamVisibility() + "']/../.."));
        //confirm public
        if (isElementPresent(By.cssSelector(".X6LMWvod566P68"))) {
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }
    }

    public int getBoardsCount() throws InterruptedException {
        Thread.sleep(2000);
        int res = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
        return res;
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void confirmDeleteBoard() {
        click(By.cssSelector(".js-confirm.full.negate"));
    }

    public void permanentlyDeleteBoar() {
        click(By.cssSelector(".quiet.js-delete"));
    }

    public void confirmCloseButton() {
        click(By.cssSelector(".js-confirm.full.negate"));
    }

    public void clickOnCloseBoard() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));
    }

    public void clickOnMore() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
    }

    public void openBoard() {
        ///???? how to click on one of boards
        click(By.cssSelector(".board-tile-details.is-badged"));

        // .board-header-btn-text
    }

    public void clickOnBackButton() throws InterruptedException {
        Thread.sleep(1000);
        try {
            click(By.cssSelector(".board-menu-header-back-button.icon-lg.icon-back.js-pop-widget-view"));
        } catch (Exception e){
            System.out.println("Back button not found");
        }

    }

    public void clickOnTheFirstBoard() throws InterruptedException {
        Thread.sleep(5000);
        waitForElementAndClick(By.cssSelector("//*[@class='icon-lg icon-member']/../../..//li"),20);


    }

    public void renameBoard(Board board) throws InterruptedException {
        waitForElementAndClick(By.cssSelector(".js-rename-board"), 20);
        //wd.findElement(By.cssSelector(".js-board-name-input")).click();
//        wd.findElement(By.cssSelector(".js-board-name-input")).clear();
        wd.findElement(By.cssSelector(".js-board-name-input"))
                .sendKeys(board.getBoardName() + System.currentTimeMillis() + Keys.ENTER);
    }

    public void selectBoardFromMenu() throws InterruptedException {
//        waitForElementAndClick(By.cssSelector("[data-test-id='home-link']"), 20);
//        System.out.println("I am on the home page :) Pushing Board button");
        Thread.sleep(5000);
        waitForElementAndClick(By.cssSelector("._1hc34_9rc6xcjf.AqhrxyGOPcyvoq"), 20);
        System.out.println("Pushed board button");
    }
}
