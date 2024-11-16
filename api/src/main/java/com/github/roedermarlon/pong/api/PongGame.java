package com.github.roedermarlon.pong.api;

import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public abstract class PongGame {

    @Getter
    private static PongGame instance;

    public PongGame() {
        instance = this;
    }
}
