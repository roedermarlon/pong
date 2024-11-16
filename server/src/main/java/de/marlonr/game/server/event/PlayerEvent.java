package de.marlonr.game.server.event;

import de.marlonr.game.shared.GamePlayer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.obsilabor.alert.Event;

@AllArgsConstructor
@Getter
public class PlayerEvent extends Event {
    GamePlayer gamePlayer;
}
