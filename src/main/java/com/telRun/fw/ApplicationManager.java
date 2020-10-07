package com.telRun.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    SessionHelper session;
    BoardHelper board;
    HeaderHelper header;

    public void init() {
        if ( wd == null ) {
            wd = new ChromeDriver();
        }
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("http://trello.com/");
        session= new SessionHelper(wd);
        board = new BoardHelper(wd);
        header = new HeaderHelper(wd);
    }

    public SessionHelper session() {
        return session;
    }
    public HeaderHelper header() {
        return header;
    }

    public BoardHelper board() {
        return board;
    }

    public void stop() {
        wd.quit();
    }
}
