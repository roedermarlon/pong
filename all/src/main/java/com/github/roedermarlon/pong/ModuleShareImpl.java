package com.github.roedermarlon.pong;

import com.github.roedermarlon.pong.server.GameServer;

public class ModuleShareImpl extends ModuleShare {

    @Override
    public void startServer(String host, int port) {
        GameServer server = new GameServer();
        server.initialize(host, port);
    }
}
