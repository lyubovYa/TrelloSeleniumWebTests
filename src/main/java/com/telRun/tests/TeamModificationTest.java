package com.telRun.tests;

import com.telRun.fw.HelperBase;
import com.telRun.model.Team;
import org.testng.annotations.Test;

public class TeamModificationTest extends TestBase {

    @Test
    public void teamModifyTest(){

        app.team().clickOnTeamButton();
        app.team().renameTeam(new Team().setTeamName("Team of crazy squirels"));



    }
}
