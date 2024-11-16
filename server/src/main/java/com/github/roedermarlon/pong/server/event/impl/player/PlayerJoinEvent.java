package com.github.roedermarlon.pong.server.event.impl.player;

import com.github.roedermarlon.pong.server.event.PlayerEvent;
import com.github.roedermarlon.pong.shared.GamePlayer;

public class PlayerJoinEvent extends PlayerEvent {

    public PlayerJoinEvent(GamePlayer gamePlayer) {
        super(gamePlayer);
    }
}
