package de.marlonr.schule.v2.frontend;

import de.marlonr.game.packet.GameFieldUpdatePacket;
import de.marlonr.game.packet.v2.S2CScoreUpdatePacket;
import dev.httpmarco.osgan.networking.client.CommunicationClient;
import dev.httpmarco.osgan.networking.client.CommunicationClientAction;
import lombok.Getter;

@Getter
public class FrontendCommunicationClient {

    private CommunicationClient communicationClient;

    public static FrontendCommunicationClient getInstance() {
        return new FrontendCommunicationClient();
    }

    public CommunicationClient initialize(String host, int port) {
        communicationClient = new CommunicationClient(host, port);

        communicationClient.clientAction(CommunicationClientAction.CONNECTED, (transmit) -> {
            System.out.println("Connected to server!");
        });

        communicationClient.listen(GameFieldUpdatePacket.class, (transmit, packet) -> {
            int paddle1Y = packet.paddle1Y(), paddle2Y = packet.paddle2Y();
            int ballX = packet.ballX(), ballY = packet.ballY();
            int ballXDir = packet.ballXDir(), ballYDir = packet.ballYDir();

            // Update game field
            var engine = RemoteGameEngineImpl.getInstance();
            engine.setPaddle1Y(paddle1Y, false);
            engine.setPaddle2Y(paddle2Y, false);
            engine.setBallX(ballX, false);
            engine.setBallY(ballY, false);
            engine.setBallXDir(ballXDir, false);
            engine.setBallYDir(ballYDir, false);
        });

        communicationClient.listen(S2CScoreUpdatePacket.class, (transmit, packet) -> {
            int score1 = packet.score1(), score2 = packet.score2();

            // TODO: Update score

        });

        communicationClient.initialize();

        return communicationClient;
    }
}
