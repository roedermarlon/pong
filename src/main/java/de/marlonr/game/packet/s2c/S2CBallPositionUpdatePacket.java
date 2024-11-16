package de.marlonr.game.packet.s2c;

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
public class S2CBallPositionUpdatePacket extends Packet {

    public int x, y;

    @Override
    public void read(PacketBuffer buffer) {
        x = buffer.readInt();
        y = buffer.readInt();
    }

    @Override
    public void write(PacketBuffer buffer) {
        buffer.writeInt(x);
        buffer.writeInt(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof S2CBallPositionUpdatePacket packet) {
            return packet.x == x && packet.y == y;
        }

        return false;
    }
}
