package com.olafparfienczyk.xapi.client.model.command.arguments;

public class LoginArguments implements Arguments {

    private String userId;
    private String password;
    private String appName;

    public String getUserId() {
        return userId;
    }

    public LoginArguments setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginArguments setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getAppName() {
        return appName;
    }

    public LoginArguments setAppName(String appName) {
        this.appName = appName;
        return this;
    }
}