package de.marlonr.schule.v2.backend.impl;

import de.marlonr.schule.v2.backend.GamePlayerImpl;

public class LocalGamePlayerImpl extends GamePlayerImpl {

    public LocalGamePlayerImpl(String displayName, int id) {
        super(displayName, id, null);
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void updateScore(int score) {

    }

    @Override
    public void updateField() {
        assert getChannelTransmit() != null;
        // getChannelTransmit().sendPacket(new GameFieldUpdatePacket());
    }
}
