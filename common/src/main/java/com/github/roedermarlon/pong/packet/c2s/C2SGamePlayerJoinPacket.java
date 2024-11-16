package com.github.roedermarlon.pong.packet.c2s;

import dev.httpmarco.osgan.networking.packet.Packet;
import dev.httpmarco.osgan.networking.packet.PacketBuffer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@ToString
@Accessors(fluent = true)
@AllArgsConstructor
public class C2SGamePlayerJoinPacket extends Packet {
    private String playerName;

    @Override
    public void read(PacketBuffer packetBuffer) {
        playerName = packetBuffer.readString();
    }

    @Override
    public void write(PacketBuffer packetBuffer) {
        packetBuffer.writeString(playerName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof C2SGamePlayerJoinPacket packet) {
            return packet.playerName.equals(playerName);
        }

        return false;
    }
}
