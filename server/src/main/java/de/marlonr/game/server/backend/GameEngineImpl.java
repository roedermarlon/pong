package de.marlonr.game.server.backend;

import de.marlonr.game.shared.GameEngine;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class GameEngineImpl extends GameEngine {

    private static GameEngine instance;

    @Override
    public int getWidth() {
        return 800;
    }

    @Override
    public int getHeight() {
        return 600;
    }
}
