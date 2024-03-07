package user;

import java.util.Scanner;

public class UserView {
    public static void main(Scanner sc)    {
        UserController controller = new UserController();
        controller.addUsers();

        while (true)    {
            System.out.print("[메뉴]\n" +
                    "0. 종료\n" +
                    "1. 회원 가입\n" +
                    "2. 로그인\n" +
                    "3. ID 검색\n" +
                    "4. 비번 변경\n" +
                    "5. 회원 탈퇴\n" +
                    "6. 회원 목록\n" +
                    "7. 이름 검색\n" +
                    "8. 직업 검색\n" +
                    "9. 회원 수\n" +
                    "입력 : ");
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;

                case "1":
                    System.out.println("=== 회원 가입 ===");
                    System.out.println(controller.join(sc));
                    System.out.println();
                    break;

                case "2":
                    System.out.println("=== 로그인 ===");
                    System.out.println(controller.login(sc));
                    break;

                case "3":
                    System.out.println("=== ID 검색 ===");
                    System.out.println(controller.findUserById(sc));
                    break;

                case "4":
                    System.out.println("=== 비번 변경 ===");
                    System.out.println(controller.updatePassword(sc));
                    break;

                case "5":
                    System.out.println("=== 회원 탈퇴 ===");
                    System.out.println(controller.deleteUser(sc));
                    break;

                case "6":
                    System.out.println("=== 회원 목록 ===");
                    System.out.println(controller.getUserList());
                    break;

                case "7":
                    System.out.println("=== 이름 검색 ===");
                    controller.findUserByName(sc).forEach(System.out::println);
                    break;

                case "8":
                    System.out.println("=== 직업 검색 ===");
                    System.out.println(controller.findUserByJob(sc));
                    break;

                case "9":
                    System.out.println("=== 회원 수 ===");
                    System.out.println(controller.count());
                    break;
            }
        }
    }
}
