package com.github.roedermarlon.pong.client.event.impl;

import com.github.roedermarlon.pong.client.event.ClientEvent;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;

public class ClientPostConnectEvent extends ClientEvent {

    public ClientPostConnectEvent(ChannelTransmit channelTransmit) {
        super(channelTransmit);
    }
}
