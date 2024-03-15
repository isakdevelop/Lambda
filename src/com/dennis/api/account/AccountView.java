package com.dennis.api.account;

import java.util.Scanner;

public class AccountView {
    public static void main(Scanner sc) {
        AccountController accountController = new AccountController();

        String input;

        while(true) {
            // [Account] 0-Exit 1-Create 2-Deposit 3-Withdraw 4-Balance 5-Cancel Account
            System.out.println("이용하실 서비스를 선택하세요.");
            System.out.println("\n1. 회원 가입");
            System.out.println("2. 입 금");
            System.out.println("3. 출 금");
            System.out.println("4. 잔고 확인");
            System.out.println("5. 거래 내역");
            System.out.println("6. 계좌 해지");
            System.out.println("7. 종 료\n");

            input = sc.next();

            // 요구 사항 : 2개 이상이면 객체에 담아서 보내기.

            switch (input)  {
                case "1":
                    System.out.println("회원 가입");
                    System.out.println("결과 : " + accountController.createAccount(sc));
                    break;
                case "2":
                    System.out.println("입 금");
                    System.out.println("결과 : " + accountController.deposit(sc));
                    break;
                case "3":
                    System.out.println("출 금");
                    System.out.println("결과 : " + accountController.withdraw(sc));
                    break;
                case "4":
                    System.out.println("잔고 확인");
                    System.out.println("결과 : " + accountController.getBalance(sc));
                    break;
                case "5":
                    System.out.println("입출금 거래 내역");
                     //System.out.println("결과 : \n" + accountController.historyOfBalance(sc));
                    break;
                case "6":
                    System.out.println("계좌 해지");
                    System.out.println("결과 : " + accountController.cancelAccount(sc));
                    break;
                case "7":
                    return;
            }
        }

    }
}
