package user;

import lombok.*;

@NoArgsConstructor
@Getter
@ToString(exclude = {"height", "weight"})

public class User {
    private Long id;
    private Double height;
    private Double weight;
    private String userName;
    private String password;
    private String confirmPassword;
    private String name;
    private String socialSecurityNumber;
    private String phone;
    private String address;
    private String job;

    @Builder(builderMethodName = "builder")
    public User(double height, double weight, String userName, String password, String confirmPassword, String name, String socialSecurityNumber, String phone, String address, String job) {
        this.height = height;
        this.weight = weight;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.phone = phone;
        this.address = address;
        this.job = job;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
