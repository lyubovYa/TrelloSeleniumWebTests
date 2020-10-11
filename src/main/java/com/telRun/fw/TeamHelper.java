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

    public void clickOnTeamButton() throws InterruptedException {
        Thread.sleep(1000);
        try {
            waitForElementAndClick(By.cssSelector("[data-test-id='home-team-tab-name']"), 20);
        } catch (org.openqa.selenium.StaleElementReferenceException ex)  {
            waitForElementAndClick(By.cssSelector("[data-test-id='home-team-tab-name']"), 20);
        }
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

    public int getTeamCount() throws InterruptedException {
//        click(By.cssSelector("[data-test-id='header-home-button']"));
        Thread.sleep(2000);
        click(By.cssSelector("[data-test-id='header-home-button']"));
        return wd.findElements(By.cssSelector("[data-test-id='home-team-tab-name']")).size();
    }

    public void renameTeam(Team team) throws InterruptedException {
        Thread.sleep(2000);
        clickOnSettings();
        click(By.cssSelector(".css-t5emrf"));
        click(By.cssSelector("#displayName"));
        wd.findElement(By.cssSelector("#displayName")).clear();
        wd.findElement(By.cssSelector("#displayName")).sendKeys(team.getTeamName() + Keys.ENTER);


    }
}
