package com.github.roedermarlon.pong.server.event;

import com.github.roedermarlon.pong.shared.GamePlayer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.obsilabor.alert.Event;

@AllArgsConstructor
@Getter
public class PlayerEvent extends Event {
    GamePlayer gamePlayer;
}
