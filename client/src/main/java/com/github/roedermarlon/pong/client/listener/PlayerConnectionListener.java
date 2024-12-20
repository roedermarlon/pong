package com.github.roedermarlon.pong.client.listener;

import com.github.roedermarlon.pong.client.GameClient;
import com.github.roedermarlon.pong.packet.s2c.S2CGamePlayerJoinPacket;

public class PlayerConnectionListener {

    public static void register(GameClient client) {
        var communicationClient = client.getCommunicationClient();

        communicationClient.listen(S2CGamePlayerJoinPacket.class, (transmit, packet) -> {
            System.out.println("Player " + packet.playerName() + " joined the game (ID: " + packet.id() + ")");
            client.setPlayerId(packet.id());
        });
    }
}
