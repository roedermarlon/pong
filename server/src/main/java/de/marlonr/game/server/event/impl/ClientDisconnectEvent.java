package de.marlonr.game.server.event.impl;

import de.marlonr.game.server.event.ServerEvent;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;

public class ClientDisconnectEvent extends ServerEvent {
    public ClientDisconnectEvent(ChannelTransmit channelTransmit) {
        super(channelTransmit);
    }
}
