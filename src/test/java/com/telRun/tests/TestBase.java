package com.telRun.tests;


import com.telRun.fw.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            BrowserType.CHROME ));


//    @AfterSuite(enabled = true) public void tearDown(){
//        app.stop();
//
//    }

    @BeforeSuite
    public void setUp() throws InterruptedException {
        app.init();
        app.session().login("lyubov.yapparova@gmail.com", "holopenio21");
    }

}
