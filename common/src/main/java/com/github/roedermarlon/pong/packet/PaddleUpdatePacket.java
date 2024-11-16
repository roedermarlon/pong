package com.github.roedermarlon.pong.packet;

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
public class PaddleUpdatePacket extends Packet {

    public int playerId;
    public int y;

    @Override
    public void read(PacketBuffer buffer) {
        playerId = buffer.readInt();
        y = buffer.readInt();
    }

    @Override
    public void write(PacketBuffer buffer) {
        buffer.writeInt(playerId);
        buffer.writeInt(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PaddleUpdatePacket packet) {
            return packet.playerId == playerId && packet.y == y;
        }

        return false;
    }
}
