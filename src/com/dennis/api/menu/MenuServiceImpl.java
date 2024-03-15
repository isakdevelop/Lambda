package com.dennis.api.menu;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public class MenuServiceImpl implements MenuService {
    private static MenuServiceImpl instance = new MenuServiceImpl();
    public static MenuServiceImpl getInstance() {
        return instance;
    }
    MenuRepository menuRepository;
    public MenuServiceImpl() {
        menuRepository = MenuRepository.getInstance();
    }
    @Override
    public List<String> getMenuList(String menuName) throws SQLException {
        return menuRepository.getMenuList(menuName);
    }
}
