package networking;

import dev.httpmarco.osgan.networking.client.CommunicationClient;

public class NetworkingClient {

    public static void startNetworkingClient(String address, int port) {
        System.out.println("Starting client...");

        var client = new CommunicationClient(address, port);

        client.initialize();

        // client.sendPacket(new PlayerAddPacket(new GamePlayer("Marlon")));
    }
}
