package com.telRun.tests;

import org.testng.annotations.Test;

public class TeamDeleteTest extends TestBase {

    @Test
    public void deleteTeamTest() throws InterruptedException {
        app.header().returnOnHomePage();
        Thread.sleep(3000);
        app.team().clickOnTeamButton();
        Thread.sleep(2000);
        app.team().clickOnSettings();
        Thread.sleep(2000);
        app.team().clickOnDeleteButton();
        app.team().confirmDeleteTeam();


    }


}
