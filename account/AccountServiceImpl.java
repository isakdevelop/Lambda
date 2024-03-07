package account;


import common.AbstractService;
import enums.Messenger;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountServiceImpl  extends AbstractService<Account> implements AccountService {
    private static AccountServiceImpl instance = new AccountServiceImpl();
    private AccountServiceImpl(){
        this.accounts = new ArrayList<>();
    }
    public static AccountServiceImpl getInstance(){return instance;}

    List<Account> accounts;
    Map<String, User> users;

    @Override
    public String deposit(Account account) {
        return null;
    }

    @Override
    public String withdraw(Account account) {
        return null;
    }

    @Override
    public String getBalance(String accountNumber) {
        return null;
    }
    @Override
    public Messenger save(Account account) {
       // accounts.put(account.getBalance())
        return Messenger.SUCCESS;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Optional<Account> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public Messenger delete(Account account) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}