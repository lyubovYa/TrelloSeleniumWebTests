package com.telRun.tests;

import org.testng.annotations.Test;

public class UsersProfileModificationTests extends TestBase {

    @Test
    public void changeAvatarForUser(){
        app.header().clickOnAvatar();
        app.header().openProfile();
        app.profile().goToAtlassianAccount();
        app.profile().switchToAtlassianAccWindow();
        app.profile().changeAvatar();
    }
}
