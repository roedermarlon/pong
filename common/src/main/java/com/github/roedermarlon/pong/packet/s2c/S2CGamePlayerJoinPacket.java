package com.github.roedermarlon.pong.packet.s2c;

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
public class S2CGamePlayerJoinPacket extends Packet {

    int id;
    String playerName;

    @Override
    public void read(PacketBuffer packetBuffer) {
        id = packetBuffer.readInt();
        playerName = packetBuffer.readString();
    }

    @Override
    public void write(PacketBuffer packetBuffer) {
        packetBuffer.writeInt(id);
        packetBuffer.writeString(playerName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof S2CGamePlayerJoinPacket packet) {
            return packet.id == id && packet.playerName.equals(playerName);
        }

        return false;
    }
}
