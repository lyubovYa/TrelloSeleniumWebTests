package com.telRun.tests;
import com.telRun.model.Team;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {

    @Test
    public void teamCeationTest() throws InterruptedException {
        int before = app.team().getTeamCount();
        Thread.sleep(2000);
       app.header().clickOnPlusButton();
       app.team().selectCreateTeam();
       Thread.sleep(6000);
        app.team().fillTeamCreationForm(new Team()
                .setTeamName("Team of crazy squirels")
                .setType("human resources"));
        Thread.sleep(2000);
        app.team().submitTeamCreation();
        app.team().selectIwillDoThisLaterButton();
        app.header().returnOnHomePageFromTeam();
        int after = app.team().getTeamCount();
        Assert.assertEquals(after-1,before);



    }
}


