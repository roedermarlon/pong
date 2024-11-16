package de.marlonr.game;

import de.marlonr.game.server.GameServer;

public class ModuleShareImpl extends ModuleShare {

    @Override
    public void startServer(String host, int port) {
        GameServer server = new GameServer();
        server.initialize(host, port);
    }
}
