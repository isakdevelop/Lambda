package com.dennis.api.common;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;

public class CommonController {
    private static CommonController instance = new CommonController();
    private CommonService commonService;
    private CommonController() {
        commonService = CommonServiceImpl.getInstance();
    }
    public static CommonController getInstance() {
        return instance;
    }
    public Messenger getMenuList(String menuName) throws SQLException {
        return commonService.getMenuList(menuName);
    }
}
