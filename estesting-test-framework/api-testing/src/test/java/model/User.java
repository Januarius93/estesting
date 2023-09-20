package model;

import lombok.Getter;
import lombok.Setter;


public class User {


    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private Password password;

    @Getter
    @Setter
    private Integer age;


    public User(String login, String password) {
        this.username = login;
        this.password = new Password(password);
    }
}

