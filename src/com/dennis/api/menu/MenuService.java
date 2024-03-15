package com.dennis.api.menu;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    List<String> getMenuList(String menuName) throws SQLException;
}
