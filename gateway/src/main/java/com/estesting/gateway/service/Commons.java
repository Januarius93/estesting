package com.estesting.gateway.service;

import com.estesting.gateway.model.User;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Commons {
    public static User getNonEmptyUser(List<User> emailUserList, List<User> usernameUserList) {
        return Objects.requireNonNull(
                        Stream.of(emailUserList, usernameUserList)
                                .filter(userList -> !userList.isEmpty())
                                .toList()
                                .stream()
                                .findFirst()
                                .orElse(null))
                .stream()
                .findFirst()
                .orElse(null);
    }
}
