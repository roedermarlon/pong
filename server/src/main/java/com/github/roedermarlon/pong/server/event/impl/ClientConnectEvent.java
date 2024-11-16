package com.github.roedermarlon.pong.server.event.impl;

import com.github.roedermarlon.pong.server.event.ServerEvent;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;

public class ClientConnectEvent extends ServerEvent {

    public ClientConnectEvent(ChannelTransmit channelTransmit) {
        super(channelTransmit);
    }
}
