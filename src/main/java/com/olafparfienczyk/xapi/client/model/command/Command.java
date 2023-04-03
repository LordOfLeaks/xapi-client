package com.olafparfienczyk.xapi.client.model.command;

import com.olafparfienczyk.xapi.client.model.command.arguments.Arguments;

public class Command {

    private String command;
    private Arguments arguments;
    private String customTag;
    private String streamSessionId;

    public String getCommand() {
        return command;
    }

    public Command setCommand(String command) {
        this.command = command;
        return this;
    }

    public Arguments getArguments() {
        return arguments;
    }

    public Command setArguments(Arguments arguments) {
        this.arguments = arguments;
        return this;
    }

    public String getCustomTag() {
        return customTag;
    }

    public Command setCustomTag(String customTag) {
        this.customTag = customTag;
        return this;
    }

    public String getStreamSessionId() {
        return streamSessionId;
    }

    public Command setStreamSessionId(String streamSessionId) {
        this.streamSessionId = streamSessionId;
        return this;
    }
}