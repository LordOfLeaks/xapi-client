package com.olafparfienczyk.xapi.client;

public class XApiConfig {

    private final String host;
    private final int port;
    private final String streamingHost;
    private final int streamingPort;

    private XApiConfig(Builder builder) {
        host = builder.host;
        port = builder.port;
        streamingHost = builder.streamingHost;
        streamingPort = builder.streamingPort;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getStreamingHost() {
        return streamingHost;
    }

    public int getStreamingPort() {
        return streamingPort;
    }

    public static final class Builder {
        private String host;
        private int port;
        private String streamingHost;
        private int streamingPort;

        private Builder() {
        }

        public Builder host(String val) {
            host = val;
            return this;
        }

        public Builder port(int val) {
            port = val;
            return this;
        }

        public Builder streamingHost(String val) {
            streamingHost = val;
            return this;
        }

        public Builder streamingPort(int val) {
            streamingPort = val;
            return this;
        }

        public XApiConfig build() {
            return new XApiConfig(this);
        }
    }
}
