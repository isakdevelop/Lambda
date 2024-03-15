package com.dennis.api.menu;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
    private static MenuController instance = new MenuController();
    private MenuService menuService;
    private MenuController() {
        menuService = MenuServiceImpl.getInstance();
    }
    public static MenuController getInstance() {
        return instance;
    }
    public List<String> getMenuList(String menuName) throws SQLException {
        return menuService.getMenuList(menuName);
    }
}
