package com.ua.jxlea;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class MulticastUdpSubscriber {

    public void subscribe() throws IOException {
        try (var socket = new MulticastSocket(1502)) {
            var multicastServerAddress = new InetSocketAddress("233.0.0.1", 1502);
            NetworkInterface netIf = NetworkInterface.getByName("bge0");
            socket.joinGroup(multicastServerAddress, netIf);
            var buffer = new byte[256];
            while (true) {
                var datagramPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(datagramPacket);
                var incomingMessage = new String(datagramPacket.getData()).trim();
                System.out.println("Server: " + incomingMessage);
            }
        }
    }
}
