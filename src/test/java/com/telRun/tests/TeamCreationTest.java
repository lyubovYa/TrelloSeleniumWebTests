package com.telRun.tests;
import com.telRun.model.Team;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {

    @Test
    public void teamCeationTest() throws InterruptedException {
       //app.header().returnOnHomePageByLink();
       int before = app.team().getTeamCount();
       System.out.println("teams before number is " + before);
       app.header().clickOnPlusButton();
       app.team().selectCreateTeam();
       Thread.sleep(2000);
       app.team().fillTeamCreationForm(new Team()
                .setTeamName("Team of crazy squirels")
                .setType("human resources"));
        Thread.sleep(2000);
        app.team().submitTeamCreation();
        app.team().selectIwillDoThisLaterButton();
        int after = app.team().getTeamCount();
        System.out.println("after is" + after);
        Assert.assertEquals(after-1,before);
    }
    @AfterClass
    public void postActions(){
        app.leftNav().returnToBoardsPage();

    }

}


