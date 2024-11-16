package de.marlonr.game.client.event.impl;

import de.marlonr.game.client.event.ClientEvent;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;

public class ClientDisconnectedEvent extends ClientEvent {

    public ClientDisconnectedEvent(ChannelTransmit channelTransmit) {
        super(channelTransmit);
    }
}
