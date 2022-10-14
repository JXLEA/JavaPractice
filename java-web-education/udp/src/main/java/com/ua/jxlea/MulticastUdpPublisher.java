package com.ua.jxlea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MulticastUdpPublisher {
    public void start() {
        try (var server = new DatagramSocket()) {
            System.out.println("Server started on port: " + server.getLocalPort());
            var address = InetAddress.getByName("233.0.0.1");
            while (true) {
                var inputStream = new InputStreamReader(System.in);
                var buffer = new BufferedReader(inputStream);
                System.out.println("Message send:" + buffer.readLine());
                var message = buffer.readLine().getBytes();
                server.send(new DatagramPacket(message, message.length, address, 1502));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
