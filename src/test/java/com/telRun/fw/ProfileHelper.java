package com.telRun.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileHelper extends HelperBase {

    public ProfileHelper(WebDriver wd) {
        super(wd);
    }

    public void goToAtlassianAccount() {
        click(By.cssSelector("[href$='manage-profile']"));
    }

    public void switchToAtlassianAccWindow() {
            String trello = wd.getWindowHandle();
            System.out.println(trello);
            click(By.cssSelector("a[href$=manage-profile]"));

            List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
            if (!availableWindows.isEmpty()){
                wd.switchTo().window(availableWindows.get(1));
            }

            //now selenium on Atlassian page
            String atlassianAcc = wd.getWindowHandle();
            System.out.println(atlassianAcc);

    }

    public void changeAvatar() {
        new Actions(wd).moveToElement( wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"))).click().perform();
        click(By.xpath("//*[@id='uid18']/span[1]"));
    }
}
