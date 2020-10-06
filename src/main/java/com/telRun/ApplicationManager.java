package com.telRun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    SessionHelper session;
    BoardHelper board;


    public void stop() {
        wd.quit();
    }

    public void init() {
        if ( wd == null ) {
            wd = new ChromeDriver();
        }
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("http://trello.com/");
        session= new SessionHelper(wd);
        board = new BoardHelper(wd);
    }

    public SessionHelper getSession() {
        return session;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public void logout() {
        clickOnAvatar();
        clickLogOut();
    }

    public void clickLogOut() {
        click(By.xpath("//button[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    @Test
    protected boolean isLoginErrorPresent() throws InterruptedException {
        Thread.sleep(6000);
        return isElementPresent(By.cssSelector("#login-error"));
    }

    public void login(String email, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        Thread.sleep(6000);
        typeByID("user", email);
        click(By.id("login"));
        Thread.sleep(6000);
        typeByID("password", password);
        click(By.id("login-submit"));
    }

    public void typeByID(String locator, String text) {
        click(By.id(locator));
        wd.findElement(By.id(locator)).clear();
        wd.findElement(By.id(locator)).sendKeys(text);
    }

    public void typeByXPATH(String locator, String text) {
        click(By.xpath(locator));
        wd.findElement(By.xpath(locator)).clear();
        wd.findElement(By.xpath(locator)).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isAvatarPresent() throws InterruptedException {
        Thread.sleep(6000);
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator) throws InterruptedException {
        Thread.sleep(6000);
        return wd.findElements(locator).size()>0;
    }

//    @BeforeClass
//    public void openTrelloLoin() throws InterruptedException {
//        setUp();
//        login("lyubov.yapparova@gmail.com", "holopenio21");
//    }

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
