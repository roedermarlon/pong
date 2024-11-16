package com.github.roedermarlon.pong.server;

import com.github.roedermarlon.pong.packet.s2c.S2CGamePlayerJoinPacket;
import com.github.roedermarlon.pong.packet.s2c.S2CGameStartPacket;
import com.github.roedermarlon.pong.server.impl.RemoteGamePlayerImpl;
import com.github.roedermarlon.pong.server.listener.ClientConnectionListener;
import com.github.roedermarlon.pong.server.listener.PaddleListener;
import com.github.roedermarlon.pong.server.listener.PlayerConnectionListener;
import com.github.roedermarlon.pong.server.task.BallTask;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;
import dev.httpmarco.osgan.networking.server.CommunicationServer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class GameServer {
    @Getter
    @Setter
    private static GameServer instance = new GameServer();
    private final ArrayList<ChannelTransmit> clients = new ArrayList<>();
    private final ArrayList<RemoteGamePlayerImpl> players = new ArrayList<>();
    private CommunicationServer communicationServer;
    @Getter
    @Setter
    private boolean gameRunning = false;

    public void initialize(String host, int port) {
        System.out.println("Server started on " + host + ":" + port);

        communicationServer = new CommunicationServer(host, port);

        ClientConnectionListener.register(this);
        PlayerConnectionListener.register(this);
        PaddleListener.register(this);

        communicationServer.initialize();
    }

    public void addPlayer(RemoteGamePlayerImpl player) {
        players.add(player);
        player.getChannelTransmit().sendPacket(new S2CGamePlayerJoinPacket(player.id(), player.displayName()));
        System.out.println("Player " + player.displayName() + " joined the game");
        tryStartGame();
    }

    public void tryStartGame() {
        if (players.size() == 2) {
            gameRunning = true;
            System.out.println("Game started");

            System.out.println("Clients: " + clients.size());
            System.out.println("Players: " + players.size());

            clients.forEach(client -> client.sendPacket(new S2CGameStartPacket(
                    players.stream().filter(player -> player.id() == 1).findFirst().get().displayName(),
                    players.stream().filter(player -> player.id() == 2).findFirst().get().displayName()
            )));

            new BallTask(7, players).start();
        }
    }

    public void playerRemoved() {
        if (gameRunning) {
            communicationServer.close();
            System.out.println("Game ended because a player left");
            instance = new GameServer();
        }
    }
}
