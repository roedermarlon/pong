package com.github.roedermarlon.pong.server.event.impl;

import com.github.roedermarlon.pong.server.event.ServerEvent;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;

public class ClientDisconnectEvent extends ServerEvent {
    public ClientDisconnectEvent(ChannelTransmit channelTransmit) {
        super(channelTransmit);
    }
}
