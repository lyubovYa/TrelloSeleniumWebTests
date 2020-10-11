package com.telRun.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    SessionHelper session;
    BoardHelper board;
    HeaderHelper header;
    HelperBase helper;
    TeamHelper team;
    LeftNavigationMenuPage leftNav;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equals(BrowserType.CHROME) ){
            wd = new ChromeDriver();
        } else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }
//        if (wd == null) {
//            wd = new ChromeDriver();
//        }
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("http://trello.com/");
    }

    public TeamHelper team() {
        return new TeamHelper(wd);
    }

    public SessionHelper session() {
        return new SessionHelper(wd);
    }

    public HeaderHelper header() {
        return new HeaderHelper(wd);
    }

    public HelperBase helper() {
        return new HelperBase(wd);
    }

    public BoardHelper board() {
        return new BoardHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public LeftNavigationMenuPage leftNav() {
        return new LeftNavigationMenuPage(wd);
    }
}
