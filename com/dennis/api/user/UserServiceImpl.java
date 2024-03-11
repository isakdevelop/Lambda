package com.dennis.api.user;

import com.dennis.api.common.AbstractService;
import com.dennis.api.common.UtilService;
import com.dennis.api.common.UtilServiceImpl;
import com.dennis.api.enums.Messenger;
import com.dennis.api.repository.UserRepository;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserServiceImpl extends AbstractService<User> implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();
    UtilService utilService;
    private UserRepository userRepository;
    Map<String, User> users;

    private UserServiceImpl(){
        this.users = new HashMap<>();
        this.utilService = UtilServiceImpl.getInstance();
        this.userRepository = UserRepository.getInstance();
    }
    public static UserServiceImpl getInstance(){return instance;}
    @Override
    public Messenger save(User user) {
        users.put(user.getUserName(), user);
        return Messenger.SUCCESS;
    }

    @Override
    public String login(User user) {
        return users.getOrDefault(user.getUserName(), User.builder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ?
                "로그인 성공" : "로그인 실패";
    }

    @Override
    public String updatePassword(User user) {
        users.get(user.getUserName()).setPassword(user.getPassword());

        return "비번 변경 성공";
    }

    @Override
    public List<?> findUsersByName(String name) {
        return users
                .values()
                .stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return users
                .values()
                .stream()
                .filter(i -> i.getJob().equals(job))
                .collect(Collectors.toList());
    }


    @Override
    public Map<String, ?> findUsersByJobFromMap(String job) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getValue().getJob().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public Map<String, ?> getUserMap() {
        return users;
    }

    @Override
    public List<?> findUsersByUserName(String userName) {
        return users
                .values()
                .stream()
                .filter(i -> i.getUserName().equals(userName))
                .collect(Collectors.toList());
    }

    @Override
    public String test() {
        return userRepository.test();
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return userRepository.findUsers();
    }

    @Override
    public String insertUser(User user) throws SQLException {
        return userRepository.insertUser(user);
    }

    @Override
    public Messenger createUserTable() throws SQLException {
        return userRepository.createUserTable();
    }

    @Override
    public String databaseLogin(String username, String password) throws SQLException {
        return userRepository.databaseLogin(username, password);
    }

    @Override
    public String addUsers() {
        IntStream.range(0, 5)
                .mapToObj(i -> UtilServiceImpl.getInstance().createRandomUserName())
                .forEach(i -> users.put(i, User.builder()
                        .userName(i)
                        .password("1")
                        .name(UtilServiceImpl.getInstance().createRandomName())
                        .job(UtilServiceImpl.getInstance().createRandomJob())
                        .build()));
        return users.size() + "개 더미값 추가";
    }
    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(users
                .values()
                .stream()
                .filter(i -> i.getId().equals(id))
                .collect(Collectors.toList()).get(0));
    }

    @Override
    public Long count() {
        return (long) users.size();
    }

    @Override
    public Optional<User> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public Messenger delete(User user) {
        users.remove(user.getUserName());
        return Messenger.SUCCESS;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return users.containsKey(id);
    }
}
