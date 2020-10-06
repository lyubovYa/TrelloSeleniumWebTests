package com.telRun;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @AfterClass(enabled = true) public void tearDown(){
        app.stop();

    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        app.init();
        app.login("lyubov.yapparova@gmail.com", "holopenio11");

    }

}
