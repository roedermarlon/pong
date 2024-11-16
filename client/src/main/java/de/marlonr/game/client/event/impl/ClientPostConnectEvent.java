package de.marlonr.game.client.event.impl;

import de.marlonr.game.client.event.ClientEvent;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;

public class ClientPostConnectEvent extends ClientEvent {

    public ClientPostConnectEvent(ChannelTransmit channelTransmit) {
        super(channelTransmit);
    }
}
