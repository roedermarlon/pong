package de.marlonr.game.server.event.impl.player;

import de.marlonr.game.server.event.PlayerEvent;
import de.marlonr.game.shared.GamePlayer;

public class PlayerJoinEvent extends PlayerEvent {

    public PlayerJoinEvent(GamePlayer gamePlayer) {
        super(gamePlayer);
    }
}
