package com.telRun.tests;


import com.telRun.fw.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            BrowserType.CHROME ));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws InterruptedException {

        app.init();
        app.session().login("lyubov.yapparova@gmail.com", "holopenio21");


    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("start test" + m.getName() + " with paraametrs: " + Arrays.asList(p));
    }
    @AfterMethod
    public void logTestStop(Method m){
        logger.info("stop test");
    }

    @AfterSuite(enabled = true)
    public void tearDown(){
        app.stop();
    }


//    @AfterSuite(enabled = true) public void tearDown(){
//        app.stop();
//
//    }
}
