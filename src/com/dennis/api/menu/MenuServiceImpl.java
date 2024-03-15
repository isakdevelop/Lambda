package com.dennis.api.menu;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public class MenuServiceImpl implements MenuService {
    private static final MenuServiceImpl instance = new MenuServiceImpl();
    public static final MenuServiceImpl getInstance() {
        return instance;
    }
    MenuRepository menuRepository;
    public MenuServiceImpl() {
        menuRepository = MenuRepository.getInstance();
    }

    @Override
    public Messenger makeTable() throws SQLException {
        return menuRepository.makeTable();
    }

    @Override
    public Messenger removeTable() throws SQLException {
        return menuRepository.removeTable();
    }

    @Override
    public List<String> getMenuList(String menuName) throws SQLException {
        return menuRepository.getMenuList(menuName);
    }

    @Override
    public Messenger truncateTable() throws SQLException {
        return menuRepository.truncateTable();
    }

    public void insetMenus() throws SQLException {
        String[] categories = {"navigate", "user", "soccer", "articles", "account", "board"};
        String[][] menus = {
                {"[ MENU ]", "0. EXIT", "1. User", "2. Article", "3. Board", "4. Crawler", "5. Account", "input command : "},
                {"[ MENU ]", "0. EXIT", "1. Mkdir", "2. Sign_up", "3. Login", "4. Select_Id", "5. Password_Change", "6. Withdrawal", "7. Find_user", "8. Find_User_By_Name", "9. Find_User_By_Job", "10. User_Count", "11. Create_table", "12. Delete_table", "input command : "},
                {"[ MENU ]", "0. EXIT", "1. Mkdir"},
                {"[ MENU ]", "0. EXIT", "1. Mkdir", "2. Write_Article", "3. Modify_Article", "4. Delete_Article", "5. Select_Article_By_Title", "6. Select_Article_By_Content", "7. Select_Article_By_Writer", "8. Select_All", "input command : "},
                {"[ MENU ]", "0. Exit", "1. Mkdir", "2. Create", "3. Login", "4. Deposit", "5. Withdraw", "6. Balance", "7. Remove", "8. Account List", "input command : "},
                {"[ MENU ]", "0. Exit", "1. Mkdir", "3. Select_Board_By_Name", "4. Select_Board_By_Type", "input command : "}
        };

        for(int i = 0; i < menus.length; i++)
            for(int j = 0; j < menus[i].length; j++)
                menuRepository.insertMenu(Menu.builder().category(categories[i]).item(menus[i][j]).build());
    }
}
