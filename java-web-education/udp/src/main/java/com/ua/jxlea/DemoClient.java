package com.ua.jxlea;

import java.io.IOException;

public class DemoClient {

    public static void main(String[] args) throws IOException {
        new MulticastUdpSubscriber().subscribe();
    }
}
