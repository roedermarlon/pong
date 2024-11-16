package com.github.roedermarlon.pong.client.event.impl;

import com.github.roedermarlon.pong.client.event.ClientEvent;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;

public class ClientConnectionFailedEvent extends ClientEvent {

    public ClientConnectionFailedEvent(ChannelTransmit channelTransmit) {
        super(channelTransmit);
    }
}
