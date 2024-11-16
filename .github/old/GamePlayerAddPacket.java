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
public class GamePlayerAddPacket extends Packet {

    private String displayName;
    private int id;

    public void read(PacketBuffer buffer) {
        displayName = buffer.readString();
        id = buffer.readInt();
    }

    public void write(PacketBuffer buffer) {
        buffer.writeString(displayName);
        buffer.writeInt(id);
    }

    public boolean equals(Object obj) {
        if (obj instanceof GamePlayerAddPacket packet) {
            return packet.displayName.equals(displayName) && packet.id == id;
        }

        return false;
    }
}
