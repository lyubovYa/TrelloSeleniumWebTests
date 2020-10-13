package com.telRun.tests;

import org.testng.annotations.Test;

public class ListsAndCardsTests extends TestBase {

    @Test
    public void createListsAndCard() throws InterruptedException {
        app.board().clickOnTheFirstBoard();
        app.board().addList("//input[@class='list-name-input']", "my favorite nuts");
        app.board().addAnotherList("//input[@class='list-name-input']", "my favorite nuts-2");
        app.board().addCard("//textarea[@class='list-card-composer-textarea js-card-title']", "pine nut");


    }

}
