package networking;

import networking.packet.PlayerAddPacket;
import dev.httpmarco.osgan.networking.server.CommunicationServer;
import dev.httpmarco.osgan.networking.server.CommunicationServerAction;

public class NetworkingServer {

    public static void startNetworkingServer() {
        System.out.println("Starting server...");

        var server = new CommunicationServer("127.0.0.1", 8080);

        server.listen(PlayerAddPacket.class, (client, packet) -> {
            System.out.println("Player " + packet.getName() + " joined the game!");
        });

        server.clientAction(CommunicationServerAction.CLIENT_CONNECT, transmit -> {
            System.out.println("connected" + transmit.channel().remoteAddress());
        });

        // server.responder("connect", communicationProperty ->
        // new PlayerAddPacket(new GamePlayer("communicationProperty."))
        // );

        server.initialize();
    }
}
