package com.dennis.api.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner sc) throws SQLException {
        boolean running = true;
        while (running)    {
            System.out.print("[메뉴]\n" +
                    "0. EXIT(e)\n" +
                    "1. SIGNUP(signup)\n" +
                    "2. LOGIN(login)\n" +
                    "3. SELECTID(selectId)\n" +
                    "4. PASSWORDCHANGE(passwordChange)\n" +
                    "5. WITHDRAWAL(withdrawal)\n" +
                    "6. FINDUSER(finduser)\n" +
                    "7. FINDUSERBYNAME(finduserbyname)\n" +
                    "8. FINDUSERBYJOB(finduserbyjob)\n" +
                    "9. USERCOUNT(usercount)\n" +
                    "touch - 테이블 생성\n" +
                    "rm - 테이블 삭제\n" +
                    "insert - 튜플 생성\n" +
                    "input command : ");

            UserViewEnum command = UserViewEnum.getByCommand(sc.next());
            running = command.performAction(sc);

        }
    }
}

/*
switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;

                case "1":
                    System.out.println("=== 회원 가입 ===");
                    //System.out.println(controller.join(sc));
                    // System.out.println();
                    System.out.println(controller.insertUser(sc));
                    break;

                case "2":
                    System.out.println("=== 로그인 ===");
//                    System.out.println(controller.login(sc));
                    System.out.println(controller.databaseLogin(sc));
                    break;

                case "3":
                    System.out.println("=== ID 검색 ===");
                    // System.out.println(controller.findUserById(sc));
//                    System.out.println(controller.test());
//                    controller.repositoryUsers();
                    controller.findUserDatabaseById(sc);
                    break;

                case "4":
                    System.out.println("=== 비번 변경 ===");
                    // System.out.println(controller.updatePassword(sc));
                    controller.changeDatabasePassword(sc);
                    break;

                case "5":
                    System.out.println("=== 회원 탈퇴 ===");
                    System.out.println(controller.databaseWithdrawal(sc));
                    break;

                case "6":
                    System.out.println("=== 회원 목록 ===");
//                    List<?> users = controller.findUsers();
//                    users.forEach(i -> System.out.println(i));
                    controller.findUserDatabase();
                    break;

                case "7":
                    System.out.println("=== 이름 검색 ===");
                    // controller.findUserByName(sc).forEach(System.out::println);
                    controller.findUserDatabaseByName(sc);
                    break;

                case "8":
                    System.out.println("=== 직업 검색 ===");
                    // System.out.println(controller.findUserByJob(sc));
                    controller.findUserDatabaseByJob(sc);
                    break;

                case "9":
                    System.out.println("=== 회원 수 ===");
                    // System.out.println(controller.count());
                    controller.userCount();
                    break;
                case "touch":
                    System.out.println("=== 테이블 생성 ===");
                    System.out.println(controller.createUserTable());
                    break;
                case "rm":
                    System.out.println("=== 테이블 삭제 ===");
                    System.out.println("회원 테이블 삭제 성공");
                    break;
//                case "insert":
//                    System.out.println("=== 회원 가입 ===");
//                    System.out.println(controller.insertUser(sc));
//                    break;
            }
 */