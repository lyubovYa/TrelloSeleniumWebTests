package com.telRun.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTest extends TestBase{

//    @BeforeMethod
//    public void ensurePreconditions() throws InterruptedException {
//        Thread.sleep(6000);
//        if(app.header().isAvatarPresent()){
//            app.header().logout();
//        }
//
//    }

    @Test
    public void testLoginPositive() throws InterruptedException {
//        if(app.header().isAvatarPresent()){
//            app.header().logout();
//        }
        app.session().login("lyubov.yapparova@gmail.com", "holopenio21");

        Assert.assertTrue(app.header().isAvatarPresent());
        //is user correct
    }

}
