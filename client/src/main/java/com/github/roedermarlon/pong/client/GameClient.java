package com.github.roedermarlon.pong.client;

import com.github.roedermarlon.pong.client.impl.RemoteGamePlayerImpl;
import com.github.roedermarlon.pong.client.listener.GameStartListener;
import com.github.roedermarlon.pong.client.listener.PlayerConnectionListener;
import com.github.roedermarlon.pong.client.listener.ServerConnectionListener;
import dev.httpmarco.osgan.networking.client.CommunicationClient;
import lombok.Getter;
import lombok.Setter;

@Getter
public class GameClient {

    private final String playerName;
    RemoteGamePlayerImpl gamePlayer;
    private CommunicationClient communicationClient;
    @Getter
    @Setter
    private int playerId;

    public GameClient(String playerName) {
        this.playerName = playerName;
    }

    public void initialize(String address, int port) {
        System.out.println("Client connecting to " + address + ":" + port);

        communicationClient = new CommunicationClient(address, port);
        gamePlayer = new RemoteGamePlayerImpl(playerId, playerName, 0, 0, communicationClient);

        ServerConnectionListener.register(this);
        PlayerConnectionListener.register(this);
        GameStartListener.register(this);

        communicationClient.initialize();
    }
}
