package de.marlonr.game.client.impl;

import de.marlonr.game.packet.PaddleUpdatePacket;
import de.marlonr.game.shared.GamePlayer;
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
