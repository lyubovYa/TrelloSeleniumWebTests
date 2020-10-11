package com.telRun.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginTrelloTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        Thread.sleep(6000);
        if(app.header().isAvatarPresent()){
            app.header().logout();
        }

    }

    @Test
    public void negativeTestLogin() throws InterruptedException {
        Thread.sleep(10000);
        app.session().login("lyubov.yapparova@gmail.com", "holopenio11");
        Thread.sleep(10000);
//        Assert.assertFalse(isAvatarPresent());
//        Thread.sleep(10000);
        Assert.assertTrue(app.session().isLoginErrorPresent());
        Thread.sleep(10000);

        //is user correct
    }


}
