package de.marlonr.game.client.event;

import dev.httpmarco.osgan.networking.channel.ChannelTransmit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.obsilabor.alert.Event;

@AllArgsConstructor
@Getter
public class ClientEvent extends Event {
    ChannelTransmit channelTransmit;
}