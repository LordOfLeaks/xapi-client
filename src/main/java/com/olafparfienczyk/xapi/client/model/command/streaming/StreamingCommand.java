package com.olafparfienczyk.xapi.client.model.command.streaming;

public class StreamingCommand {

    private String command;
    private String streamSessionId;

    public String getCommand() {
        return command;
    }

    public StreamingCommand setCommand(String command) {
        this.command = command;
        return this;
    }

    public String getStreamSessionId() {
        return streamSessionId;
    }

    public StreamingCommand setStreamSessionId(String streamSessionId) {
        this.streamSessionId = streamSessionId;
        return this;
    }
}
