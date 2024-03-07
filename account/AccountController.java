package account;

import enums.Messenger;

import java.time.LocalDate;
import java.util.Scanner;

public class AccountController {
    AccountServiceImpl accountService;
    LocalDate localDate;

    public AccountController()  {
        accountService = AccountServiceImpl.getInstance();
        localDate = LocalDate.now();
    }
    public Messenger createAccount(Scanner sc) {
        System.out.println("사용자의 계좌번호, 성명을 입력하여 주세요.");

        return accountService.save(
                Account.builder()
                        .id(sc.nextLong())
                        .accountNumber(sc.next())
                        .accountHolder(sc.next())
                        .balance(0)
                        .transactionDate(localDate)
                        .returnType(null)
                        .build());
    }

    public String deposit(Scanner sc) {
        System.out.println("입금을 실행합니다.\n입금 하실 계좌 번호와 " +
                "금액을 입력해주세요.");
        return accountService.deposit(
                Account.builder()
                        .id(sc.nextLong())
                        .accountNumber(sc.next())
                        .accountHolder(sc.next())
                        .balance(0)
                        .transactionDate(localDate)
                        .returnType(null)
                        .build());
        // return accountService.deposit(sc.next(), sc.nextDouble());
    }
    public String withdraw(Scanner sc) {
        System.out.println("출금을 실행합니다.\n입금 하실 계좌 번호와 " +
                "금액을 입력해주세요.");
        return accountService.withdraw(
                Account.builder()
                        .id(sc.nextLong())
                        .accountNumber(sc.next())
                        .accountHolder(sc.next())
                        .balance(0)
                        .transactionDate(localDate)
                        .returnType(null)
                        .build());
        //return accountService.withdraw(sc.next(), sc.nextDouble());
    }
    public Messenger cancelAccount(Scanner sc) {
        System.out.println("계좌 번호를 입력해주세요.");
        return accountService.delete(
                Account.builder()
                        .accountNumber(sc.next())
                        .build()
        );
    }

    public String getBalance(Scanner sc)    {
        System.out.println("계좌 번호를 입력해주세요.");
        return accountService.getBalance(sc.next());
    }
}
