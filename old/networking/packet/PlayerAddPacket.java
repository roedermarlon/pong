package networking.packet;

import de.marlonr.schule.v2.game.GamePlayer;
import dev.httpmarco.osgan.networking.packet.Packet;
import dev.httpmarco.osgan.networking.packet.PacketBuffer;

public class PlayerAddPacket extends Packet {

    private final String name;

    public PlayerAddPacket(GamePlayer player) {
        this.name = player.getName();
    }

    @Override
    public void read(PacketBuffer packetBuffer) {
        packetBuffer.readString();
    }

    @Override
    public void write(PacketBuffer packetBuffer) {
        packetBuffer.writeString(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PlayerAddPacket packet) {
            return packet.name.equals(name);
        }

        return false;
    }
}
