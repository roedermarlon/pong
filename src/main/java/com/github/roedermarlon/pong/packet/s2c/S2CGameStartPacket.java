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
public class S2CGameStartPacket extends Packet {
    private String playerName1, playerName2;

    @Override
    public void read(PacketBuffer packetBuffer) {
        playerName1 = packetBuffer.readString();
        playerName2 = packetBuffer.readString();
    }

    @Override
    public void write(PacketBuffer packetBuffer) {
        packetBuffer.writeString(playerName1);
        packetBuffer.writeString(playerName2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof S2CGameStartPacket packet) {
            return packet.playerName1.equals(playerName1) && packet.playerName2.equals(playerName2);
        }

        return false;
    }
}
