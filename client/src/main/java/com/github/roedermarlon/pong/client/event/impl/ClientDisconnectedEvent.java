package com.github.roedermarlon.pong.client.event.impl;

import com.github.roedermarlon.pong.client.event.ClientEvent;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;

public class ClientDisconnectedEvent extends ClientEvent {

    public ClientDisconnectedEvent(ChannelTransmit channelTransmit) {
        super(channelTransmit);
    }
}
