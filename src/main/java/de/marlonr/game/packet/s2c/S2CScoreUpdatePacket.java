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
public class S2CScoreUpdatePacket extends Packet {
    int score1, score2;

    @Override
    public void read(PacketBuffer buffer) {
        score1 = buffer.readInt();
        score2 = buffer.readInt();
    }

    @Override
    public void write(PacketBuffer buffer) {
        buffer.writeInt(score1);
        buffer.writeInt(score2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof S2CScoreUpdatePacket packet) {
            return packet.score1 == score1 && packet.score2 == score2;
        }

        return false;
    }
}
