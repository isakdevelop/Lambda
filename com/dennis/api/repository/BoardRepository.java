package com.dennis.api.repository;

public class BoardRepository {
    private static BoardRepository instance = new BoardRepository();

    public static BoardRepository getInstance() {
        return instance;
    }


}
