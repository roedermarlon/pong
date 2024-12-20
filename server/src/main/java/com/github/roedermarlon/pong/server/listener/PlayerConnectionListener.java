package com.github.roedermarlon.pong.server.listener;

import com.github.roedermarlon.pong.packet.c2s.C2SGamePlayerJoinPacket;
import com.github.roedermarlon.pong.server.GameServer;
import com.github.roedermarlon.pong.server.impl.RemoteGamePlayerImpl;

public class PlayerConnectionListener {

    public static void register(GameServer server) {
        System.out.println("Debug: Registering player connection listener");
        var communicationServer = server.getCommunicationServer();

        communicationServer.listen(C2SGamePlayerJoinPacket.class, (transmit, packet) -> {
            System.out.println("Debug: Player " + packet.playerName() + " joined the game");
            if (server.getPlayers().size() >= 2) {
                transmit.channel().close(); // game is full
            } else {
                var player = new RemoteGamePlayerImpl(server.getPlayers().size() + 1, packet.playerName(), 0, 0, transmit);
                server.addPlayer(player); // TODO: fix player not adding
            }
        });
    }
}
