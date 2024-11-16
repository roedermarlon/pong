package de.marlonr.schule.v2.backend.impl;

import de.marlonr.schule.v2.backend.GamePlayerImpl;

public class RemoteGamePlayerImpl extends GamePlayerImpl {

    public RemoteGamePlayerImpl(String displayName, int id) {
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
        // TODO: send packet
    }
}
