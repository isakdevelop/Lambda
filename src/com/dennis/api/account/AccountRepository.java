package com.dennis.api.account;

public class AccountRepository {
    private static AccountRepository instance = new AccountRepository();
    public AccountRepository getInstance() {
        return instance;
    }


}
