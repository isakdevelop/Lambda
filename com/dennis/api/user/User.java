package com.dennis.api.user;

import lombok.*;

@NoArgsConstructor
@Getter
@ToString(exclude = {"height", "weight", "addressID"})

public class User {
    private Long id;
    private Double height;
    private Double weight;
    private String userName;
    private String password;
    private String confirmPassword;
    private String name;
    private String phone;
    private Long addressID;
    private String job;

    @Builder(builderMethodName = "builder")
    public User(double height, double weight, String userName, String password, String confirmPassword, String name, String phone, String job) {
        this.height = height;
        this.weight = weight;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
        this.phone = phone;
        this.job = job;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
