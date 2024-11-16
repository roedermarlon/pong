package de.marlonr.game.server.event;

import dev.httpmarco.osgan.networking.channel.ChannelTransmit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.obsilabor.alert.Event;

@AllArgsConstructor
@Getter
public class ServerEvent extends Event {

    ChannelTransmit channelTransmit;
}
