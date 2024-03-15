package com.dennis.api.menu;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
    private static final MenuController instance = new MenuController();
    private final MenuService menuService;
    private MenuController() {
        menuService = MenuServiceImpl.getInstance();
    }
    public static final MenuController getInstance() {
        return instance;
    }

    public Messenger makeTable() throws SQLException {
        return menuService.makeTable();
    }

    public Messenger removeTable() throws SQLException {
        return menuService.removeTable();
    }

    public List<String> getMenuList(String menuName) throws SQLException {
        return menuService.getMenuList(menuName);
    }

    public Messenger truncateTable() throws SQLException {
        return menuService.truncateTable();
    }

    public void insetMenus() throws SQLException {
        menuService.insetMenus();
    }
}
