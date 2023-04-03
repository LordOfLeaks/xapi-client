package com.olafparfienczyk.xapi.client.connection;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;

/**
 * Implements SSL socket connection over TCP
 */
public class SSLXApiConnection implements XApiConnection {

    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;

    public SSLXApiConnection(String host, int port) throws IOException {
        this.socket = SSLSocketFactory.getDefault().createSocket(host, port);
        this.writer = new PrintWriter(socket.getOutputStream());
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void send(String toSend) throws IOException {
        writer.println(toSend);
        writer.println();
        writer.flush();
        if (writer.checkError()) {
            close();
            throw new IOException("Send failed");
        }
    }

    @Override
    public String receive() throws IOException {
        try {
            String received = reader.readLine();
            if (received == null) {
                throw new EOFException();
            }
            long skipped = reader.skip(1); //skip additional new line character
            if (skipped != 1) {
                throw new EOFException();
            }
            return received;
        } catch (IOException e) {
            close();
            throw e;
        }
    }

    @Override
    public void close() {
        try {
            socket.close();
        } catch (IOException ignored) {
        }
    }

    @Override
    public boolean isClosed() {
        return socket.isClosed();
    }
}