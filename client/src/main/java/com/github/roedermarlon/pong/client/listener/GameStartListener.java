package com.github.roedermarlon.pong.client.listener;

import com.github.roedermarlon.pong.client.GameClient;
import com.github.roedermarlon.pong.client.frontend.GameFrontend;
import com.github.roedermarlon.pong.packet.s2c.S2CGameStartPacket;

public class GameStartListener {

    public static void register(GameClient client) {
        client.getCommunicationClient().listen(S2CGameStartPacket.class, (transmit, packet) -> {
            new GameFrontend(client).start();
        });
    }
}