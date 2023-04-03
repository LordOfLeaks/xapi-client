package com.olafparfienczyk.xapi.client;

public class XApiCredentials {

    private final String userId;
    private final String password;
    private final String appName;

    private XApiCredentials(Builder builder) {
        userId = builder.userId;
        password = builder.password;
        appName = builder.appName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getAppName() {
        return appName;
    }

    public static final class Builder {
        private String userId;
        private String password;
        private String appName;

        private Builder() {
        }

        public Builder userId(String val) {
            userId = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder appName(String val) {
            appName = val;
            return this;
        }

        public XApiCredentials build() {
            return new XApiCredentials(this);
        }
    }
}