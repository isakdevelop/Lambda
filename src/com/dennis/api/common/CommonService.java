package com.dennis.api.common;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;

public interface CommonService {
    Messenger getMenuList(String menuName) throws SQLException;
}
