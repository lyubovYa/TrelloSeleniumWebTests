package com.telRun;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        Thread.sleep(6000);
        if(app.isAvatarPresent()){
            app.logout();
        }

    }

    @Test
    public void testLoginPositive() throws InterruptedException {
        app.login("lyubov.yapparova@gmail.com", "holopenio21");

        Assert.assertTrue(app.isAvatarPresent());
        //is user correct
    }
    @Test
    public void negativeTestLogin() throws InterruptedException {
        Thread.sleep(10000);
        app.login("lyubov.yapparova@gmail.com", "holopenio11");
        Thread.sleep(10000);
//        Assert.assertFalse(isAvatarPresent());
//        Thread.sleep(10000);
        Assert.assertTrue(app.isLoginErrorPresent());
        Thread.sleep(10000);

        //is user correct
    }


}
