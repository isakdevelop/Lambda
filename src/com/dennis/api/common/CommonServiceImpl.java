package com.dennis.api.common;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;

public class CommonServiceImpl implements CommonService{
    private static CommonServiceImpl instance = new CommonServiceImpl();
    public static CommonServiceImpl getInstance() {
        return instance;
    }
    CommonRepository commonRepository;
    public CommonServiceImpl() {
        commonRepository = CommonRepository.getInstance();
    }
    @Override
    public Messenger getMenuList(String menuName) throws SQLException {
        return commonRepository.getMenuList(menuName);
    }
}
