package de.marlonr.game.server.listener;

import de.marlonr.game.packet.c2s.C2SGamePlayerJoinPacket;
import de.marlonr.game.server.GameServer;
import de.marlonr.game.server.impl.RemoteGamePlayerImpl;

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
