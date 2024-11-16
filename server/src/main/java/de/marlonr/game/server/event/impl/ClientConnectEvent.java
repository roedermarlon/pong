package de.marlonr.game.server.event.impl;

import de.marlonr.game.server.event.ServerEvent;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;

public class ClientConnectEvent extends ServerEvent {

    public ClientConnectEvent(ChannelTransmit channelTransmit) {
        super(channelTransmit);
    }
}
