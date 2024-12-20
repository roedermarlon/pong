package com.github.roedermarlon.pong.server.impl;

import com.github.roedermarlon.pong.packet.PaddleUpdatePacket;
import com.github.roedermarlon.pong.packet.s2c.S2CScoreUpdatePacket;
import com.github.roedermarlon.pong.server.GameServer;
import com.github.roedermarlon.pong.shared.GamePlayer;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;
import lombok.Getter;

@Getter
public class RemoteGamePlayerImpl extends GamePlayer {

    private final ChannelTransmit channelTransmit;

    public RemoteGamePlayerImpl(int id, String displayName, int paddleY, int score, ChannelTransmit channelTransmit) {
        super(id, displayName, paddleY, score);
        this.channelTransmit = channelTransmit;
    }

    public void updatePaddleY(int paddleY) {
        System.out.println("Debug: RemoteGamePlayerImpl - Paddle Y: " + paddleY); // TODO: remove debug
        this.paddleY = paddleY;

        GameServer.getInstance().getClients().forEach(client -> {
            client.sendPacket(new PaddleUpdatePacket(id(), paddleY));
        });
    }

    public void updateScore(int score) {
        this.score = score;

        GameServer.getInstance().getPlayers().forEach(player ->
                player.getChannelTransmit().sendPacket(new S2CScoreUpdatePacket(
                        GameServer.getInstance().getPlayers().stream().filter(it ->
                                it.id() == 1).findFirst().orElseThrow().score,
                        GameServer.getInstance().getPlayers().stream().filter(it
                                -> it.id() == 2).findFirst().orElseThrow().score)
                )
        );
    }
}
