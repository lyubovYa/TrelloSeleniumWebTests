package com.telRun.model;

public class Board {
    private String boardName;
    private String boardVisibility;

    public Board withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public Board withBoardVisibility(String boardVisibility) {
        this.boardVisibility = boardVisibility;
        return this;
    }
    public String getBoardName() {
        return boardName;
    }

    public String getBoardVisibility() {
        return boardVisibility;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardName='" + boardName + '\'' +
                ", boardVisibility='" + boardVisibility + '\'' +
                '}';
    }
}
