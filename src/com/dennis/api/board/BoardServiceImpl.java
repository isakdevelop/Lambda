package com.dennis.api.board;

public class BoardServiceImpl implements BoardService{
    private static BoardService instance = new BoardServiceImpl();
    public static BoardService getInstance()    {
        return instance;
    }
}
