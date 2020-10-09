package com.telRun.fw;

import com.telRun.model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class TeamHelper extends HelperBase {
    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmDeleteTeam() {
        click(By.cssSelector(".js-confirm.full.negate"));
    }

    public void clickOnDeleteButton() {
        click(By.cssSelector(".quiet-button"));
    }

    public void clickOnSettings() {
        click(By.cssSelector("[data-test-id='home-team-settings-tab']"));
    }

    public void clickOnTeamButton() {
        click(By.cssSelector("[data-test-id='home-team-tab-name']"));
    }

    public void selectIwillDoThisLaterButton() {
       click(By.cssSelector("[data-test-id='show-later-button']"));
    }


    public void submitTeamCreation() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }


    public void fillTeamCreationForm(Team team) {
        typeByXPATH("//input[@data-test-id='header-create-team-name-input']", team.getTeamName());
        click(By.cssSelector("[data-test-id='header-create-team-type-input']"));
        click(By.cssSelector("[data-test-id='header-create-team-type-input-" + team.getType() + "']"));
    }


    public void selectCreateTeam() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public int getTeamCount() {

        return wd.findElements(By.cssSelector("[data-test-id='home-team-tab-name']")).size();
    }

    public void renameTeam(Team team) {
        clickOnSettings();
        click(By.cssSelector(".css-t5emrf"));
        click(By.cssSelector("#displayName"));
        wd.findElement(By.cssSelector("#displayName")).clear();
        wd.findElement(By.cssSelector("#displayName")).sendKeys(team.getTeamName() + Keys.ENTER);


    }
}
