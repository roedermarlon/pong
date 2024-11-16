package de.marlonr.game.client.event.impl;

import de.marlonr.game.client.event.ClientEvent;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;

public class ClientConnectionFailedEvent extends ClientEvent {

    public ClientConnectionFailedEvent(ChannelTransmit channelTransmit) {
        super(channelTransmit);
    }
}
