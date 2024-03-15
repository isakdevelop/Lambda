import com.dennis.api.enums.Messenger;
import com.dennis.api.enums.Navigation;
import com.dennis.api.menu.MenuController;
import com.dennis.api.menu.MenuService;
import com.dennis.api.menu.MenuServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
//        Messenger msg = ...
//        Menu oneMenu = ...
//        List<?> allMenu = ... 밖에 리턴은 없음
        MenuController.getInstance().removeTable();
        MenuController.getInstance().makeTable();
        MenuController.getInstance().insetMenus();

        while(Navigation.navigate(sc));
    }
}
