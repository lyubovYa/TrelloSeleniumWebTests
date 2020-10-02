package com.telRun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTrelloTest {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
     wd = new ChromeDriver();
     wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     wd.manage().window().maximize();
     wd.navigate().to("http://trello.com/");

    }
    @Test
    public void testLoginPositive() throws InterruptedException {
        wd.findElement(By.cssSelector("[href='/login']")).click();
        wd.findElement(By.className("user")).click();
        wd.findElement(By.className("user")).clear();
        wd.findElement(By.className("user")).sendKeys("lyubov.yapparova@gmail.com");
        Thread.sleep(10000);
        wd.findElement(By.id("login")).click();
        Thread.sleep(10000);
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("holopenio21");

        wd.findElement(By.id("login-submit")).click();





    }
    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();

    }
}
