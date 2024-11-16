package com.github.roedermarlon.pong.client.impl;

import com.github.roedermarlon.pong.packet.PaddleUpdatePacket;
import com.github.roedermarlon.pong.shared.GamePlayer;
import dev.httpmarco.osgan.networking.client.CommunicationClient;
import lombok.Getter;

@Getter
public class RemoteGamePlayerImpl extends GamePlayer {

    private final CommunicationClient communicationClient;

    public RemoteGamePlayerImpl(int id, String displayName, int paddleY, int score, CommunicationClient communicationClient) {
        super(id, displayName, paddleY, score);

        this.communicationClient = communicationClient;
    }

    public void updatePaddleY(int paddleY) {
        this.paddleY = paddleY;
        communicationClient.sendPacket(new PaddleUpdatePacket(id(), paddleY));
    }
}
