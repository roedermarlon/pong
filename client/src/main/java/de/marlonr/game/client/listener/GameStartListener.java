package de.marlonr.game.client.listener;

import de.marlonr.game.client.GameClient;
import de.marlonr.game.client.frontend.GameFrontend;
import de.marlonr.game.packet.s2c.S2CGameStartPacket;

public class GameStartListener {

    public static void register(GameClient client) {
        client.getCommunicationClient().listen(S2CGameStartPacket.class, (transmit, packet) -> {
            new GameFrontend(client).start();
        });
    }
}