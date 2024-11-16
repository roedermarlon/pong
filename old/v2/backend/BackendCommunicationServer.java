package de.marlonr.schule.v2.backend;

import de.marlonr.game.packet.C2SUpdatePacket;
import de.marlonr.game.packet.GamePlayerAddPacket;
import de.marlonr.schule.v2.shared.IGamePlayer;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;
import dev.httpmarco.osgan.networking.client.CommunicationClient;
import dev.httpmarco.osgan.networking.client.CommunicationClientAction;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class BackendCommunicationServer {

    private final HashMap<ChannelTransmit, IGamePlayer> players = new HashMap<>();

    private CommunicationClient communicationClient;

    public static BackendCommunicationServer getInstance() {
        return new BackendCommunicationServer();
    }

    public CommunicationClient initialize() {
        communicationClient = new CommunicationClient("localhost", 8080);

        communicationClient.clientAction(CommunicationClientAction.CONNECTED, (transmit) -> {
            System.out.println("Connected to server!");
        });

        communicationClient.listen(GamePlayerAddPacket.class, (transmit, packet) -> {
        });

        communicationClient.listen(C2SUpdatePacket.class, (transmit, packet) -> {
            final int id = players.get(transmit).getId();

            if (id == 1) {
                BackendGameEngineImpl.getInstance().setPaddle1Y(packet.paddle1Y(), false);
            } else if (id == 2) {
                BackendGameEngineImpl.getInstance().setPaddle2Y(packet.paddle1Y(), false);
            }
        });

        communicationClient.initialize();

        return communicationClient;
    }
}