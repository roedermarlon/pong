package com.github.roedermarlon.pong.api;

import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
public class Scoreboard {

    int player1;
    int player2;
}
