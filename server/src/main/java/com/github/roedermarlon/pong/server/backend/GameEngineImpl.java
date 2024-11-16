package com.github.roedermarlon.pong.server.backend;

import com.github.roedermarlon.pong.shared.GameEngine;
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
