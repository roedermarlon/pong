package com.github.roedermarlon.pong.api.player;

import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@Accessors(fluent = true)
public interface IGamePlayer {

    @NotNull
    String displayName();

    int id();

    void score(int score);
}
