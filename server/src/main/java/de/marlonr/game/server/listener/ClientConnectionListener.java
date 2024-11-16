package de.marlonr.game.server.listener;

import de.marlonr.game.server.GameServer;
import de.marlonr.game.server.event.impl.ClientConnectEvent;
import de.marlonr.game.server.event.impl.ClientDisconnectEvent;
import dev.httpmarco.osgan.networking.server.CommunicationServerAction;
import me.obsilabor.alert.EventManager;

public class ClientConnectionListener {

    public static void register(GameServer server) {
        var communicationServer = server.getCommunicationServer();

        communicationServer.clientAction(CommunicationServerAction.CLIENT_CONNECT, (client) -> {
            System.out.println("Client connected: " + client.channel().remoteAddress());
            EventManager.callEvent(new ClientConnectEvent(client));
            server.getClients().add(client);
        });

        communicationServer.clientAction(CommunicationServerAction.CLIENT_DISCONNECT, (client) -> {
            System.out.println("Client disconnected: " + client.channel().remoteAddress());
            EventManager.callEvent(new ClientDisconnectEvent(client));
            server.playerRemoved();
        });
    }
}
