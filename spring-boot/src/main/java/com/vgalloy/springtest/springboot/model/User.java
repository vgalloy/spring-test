package com.vgalloy.springtest.springboot.model;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 30/01/17.
 */
public final class User {

    private final String login;
    private final String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
