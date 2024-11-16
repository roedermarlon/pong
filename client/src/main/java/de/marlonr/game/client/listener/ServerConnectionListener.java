package de.marlonr.game.client.listener;

import de.marlonr.game.client.GameClient;
import de.marlonr.game.client.event.impl.ClientConnectionFailedEvent;
import de.marlonr.game.client.event.impl.ClientDisconnectedEvent;
import de.marlonr.game.client.event.impl.ClientPostConnectEvent;
import de.marlonr.game.packet.c2s.C2SGamePlayerJoinPacket;
import dev.httpmarco.osgan.networking.client.CommunicationClientAction;
import me.obsilabor.alert.EventManager;

public class ServerConnectionListener {

    public static void register(GameClient client) {
        var communicationClient = client.getCommunicationClient();

        communicationClient.clientAction(CommunicationClientAction.CONNECTED, (transmit) -> {
            System.out.println("sending join packet to " + transmit.channel().remoteAddress());
            EventManager.callEvent(new ClientPostConnectEvent(transmit));
            transmit.sendPacket(new C2SGamePlayerJoinPacket(client.getPlayerName()));
        });

        communicationClient.clientAction(CommunicationClientAction.DISCONNECTED, (transmit) -> {
            EventManager.callEvent(new ClientDisconnectedEvent(transmit));
            System.out.println("Disconnected from server!");
        });

        communicationClient.clientAction(CommunicationClientAction.FAILED, (transmit) -> {
            EventManager.callEvent(new ClientConnectionFailedEvent(transmit));
            System.out.println("Connection to server failed!");

        });
    }
}
