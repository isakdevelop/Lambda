package com.dennis.api.user;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class UserController {
    UserServiceImpl userService;
    private static UserController instance = new UserController();

    public static UserController getInstance() {
        return instance;
    }


    public UserController() {
        userService = UserServiceImpl.getInstance();
    }
    public Messenger insertUser(Scanner sc) throws SQLException {
        System.out.print("사용자 아이디, " +
                "사용자 비밀번호, " +
                "사용자 이름 , " +
                "사용자 전화 번호, " +
                "사용자 직업, " +
                "사용자 키, " +
                "사용자 몸무게를 순차적으로 입력해주세요.\n" +
                "입력 : ");
        return userService.insertUser(User.builder()
                .userName(sc.next())
                .password(sc.next())
                .name(sc.next())
                .phone(sc.next())
                .job(sc.next())
                .height(sc.nextDouble())
                .weight(sc.nextDouble())
                .build());
    }

    public Messenger createUserTable() throws SQLException {
        return userService.createUserTable();
    }

    public Messenger databaseLogin(Scanner sc) throws SQLException {
        System.out.print("아이디 : ");
        String username = sc.next();

        System.out.print("비밀번호 : ");
        String password = sc.next();
        return userService.databaseLogin(username, password);
    }

    public Messenger findUserDatabaseById(Scanner sc) throws SQLException {
        System.out.print("검색할 아이디 : ");
        return userService.findUserDatabaseById(sc.next());
    }

    public Messenger changeDatabasePassword(Scanner sc) throws SQLException {
        System.out.print("검색 할 아이디와 비밀번호 입력 : ");
        return userService.changeDatabasePassword(sc.next(), sc.next());
    }

    public Messenger databaseWithdrawal(Scanner sc) throws SQLException {
        System.out.print("탈퇴 할 아이디 입력 : ");
        return userService.databaseWithdrawal(sc.next());
    }

    public Messenger findUserDatabaseByName(Scanner sc) throws SQLException {
        System.out.print("검색 할 이름 입력 : ");
        return userService.findUserDatabaseByName(sc.next());
    }

    public Messenger findUserDatabase() throws SQLException {
        return userService.findUserDatabase();
    }

    public Messenger findUserDatabaseByJob(Scanner sc) throws SQLException {
        System.out.print("검색할 직업 입력 : ");
        return userService.findUserDatabaseByJob(sc.next());
    }

    public Messenger userCount() throws SQLException {
        return userService.userCount();
    }

//    public String addUsers() {
//        return userService.addUsers();
//    }
//
//    public Messenger join(Scanner sc)    {
//        System.out.println("id, 비밀번호, 비밀번호 확인, 이름, 주민 번호," +
//                " 전화 번호, 주소, 직업을 나누어 입력해주세요.");
//        return userService.save(
//                User.builder()
//                        .userName(sc.next())
//                        .password(sc.next())
//                        .confirmPassword(sc.next())
//                        .name(sc.next())
//                        .phone(sc.next())
//                        .job(sc.next())
//                        .build());
//    }
//
//    public String test()    {
//        return userService.test();
//    }
//
//    public List<?> findUsers() throws SQLException {
//        return userService.findUsers();
//    }
//
//    public String login(Scanner sc) {
//        System.out.println("로그인 할 ID 입력 : ");
//        String userName = sc.next();
//        System.out.println("로그인 할 비밀번호 입력 : ");
//        String password = sc.next();
//        return userService.login(
//                User.builder()
//                        .userName(userName)
//                        .password(password)
//                        .build());
//    }
//
//    public List<?> findUserById(Scanner sc)  {
//        System.out.print("검색할 ID 입력 : ");
//
//        return userService.findUsersByUserName(sc.next());
//    }
//
//    public String updatePassword(Scanner sc)    {
//        System.out.print("사용자의 아이디를 입력해주세요.\n" +
//                "입력 : ");
//        String userName = sc.next();
//        System.out.print("바꿀 비밀 번호를 입력해주세요.\n" +
//                "입력 : ");
//        String updatePassword = sc.next();
//        return userService.updatePassword(
//                User.builder()
//                        .userName(userName)
//                        .password(updatePassword)
//                        .build());
//    }
//
//    public Messenger deleteUser(Scanner sc)    {
//        System.out.print("삭제하실 아이디를 입력해주세요.\n" +
//                "입력 : ");
//        return userService.delete(
//                User.builder()
//                        .userName(sc.next())
//                        .build());
//    }
//
//    public String getUserList()    {
//        return userService.findAll().toString();
//    }
//
//    public List<?> findUserByName(Scanner sc)  {
//        System.out.print("사용자 이름을 입력하세요.\n" +
//                "입력 : ");
//        return userService.findUsersByName(sc.next());
//    }
//
//    public List<?>findUserByJob(Scanner sc) {
//        System.out.print("직업을 입력하세요.\n" +
//                "입력 : ");
//        return userService.findUsersByJob(sc.next());
//    }
//
//    public String count()   {
//        return "회원 수 : " + userService.count() + "명";
//    }
}