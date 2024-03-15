package com.dennis.api.menu;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    Messenger makeTable() throws SQLException;
    Messenger removeTable() throws SQLException;
    List<String> getMenuList(String menuName) throws SQLException;
    Messenger truncateTable() throws SQLException;
    void insetMenus() throws SQLException;
}
