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
public class GameFieldUpdatePacket extends Packet {

    private int paddle1Y, paddle2Y;
    private int ballX, ballY;
    private int ballXDir, ballYDir;

    @Override
    public void read(PacketBuffer buffer) {
        paddle1Y = buffer.readInt();
        paddle2Y = buffer.readInt();
        ballX = buffer.readInt();
        ballY = buffer.readInt();
        ballXDir = buffer.readInt();
        ballYDir = buffer.readInt();
    }

    @Override
    public void write(PacketBuffer buffer) {
        buffer.writeInt(paddle1Y);
        buffer.writeInt(paddle2Y);
        buffer.writeInt(ballX);
        buffer.writeInt(ballY);
        buffer.writeInt(ballXDir);
        buffer.writeInt(ballYDir);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GameFieldUpdatePacket packet) {
            return packet.paddle1Y == paddle1Y
                    && packet.paddle2Y == paddle2Y
                    && packet.ballX == ballX
                    && packet.ballY == ballY
                    && packet.ballXDir == ballXDir
                    && packet.ballYDir == ballYDir;
        }

        return false;
    }
}
