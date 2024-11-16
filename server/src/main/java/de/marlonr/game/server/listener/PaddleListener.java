package de.marlonr.game.server.listener;

import de.marlonr.game.packet.PaddleUpdatePacket;
import de.marlonr.game.server.GameServer;

public class PaddleListener {

    public static void register(GameServer server) {
        var communicationServer = server.getCommunicationServer();

        communicationServer.listen(PaddleUpdatePacket.class, (transmit, packet) -> {
            var player = server.getPlayers().stream().filter(remoteGamePlayer -> remoteGamePlayer.id() == packet.playerId()).findFirst();

            System.out.println("Paddle Y: " + packet.y()); // TODO: remove debug

            player.ifPresent(remoteGamePlayer -> {
                remoteGamePlayer.updatePaddleY(packet.y());
            });
        });
    }
}
