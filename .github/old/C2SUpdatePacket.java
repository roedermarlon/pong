package de.marlonr.game.packet;

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
public class C2SUpdatePacket extends Packet {
    private int paddle1Y;
    private int paddle2Y;

    @Override
    public void read(PacketBuffer packetBuffer) {
        paddle1Y = packetBuffer.readInt();
    }

    @Override
    public void write(PacketBuffer packetBuffer) {
        packetBuffer.writeInt(paddle1Y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof C2SUpdatePacket packet) {
            return packet.paddle1Y == paddle1Y && packet.paddle2Y == paddle2Y;
        }

        return false;
    }
}
