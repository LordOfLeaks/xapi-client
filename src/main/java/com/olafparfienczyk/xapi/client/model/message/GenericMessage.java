package com.olafparfienczyk.xapi.client.model.message;

public class GenericMessage {

    private String command;

    public String getCommand() {
        return command;
    }

    public GenericMessage setCommand(String command) {
        this.command = command;
        return this;
    }
}