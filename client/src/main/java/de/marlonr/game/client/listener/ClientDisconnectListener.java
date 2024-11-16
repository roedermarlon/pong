package de.marlonr.game.client.listener;

import de.marlonr.game.client.frontend.GameFrame;
import de.marlonr.game.client.frontend.ScoreFrame;
import de.marlonr.game.shared.GamePlayer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;
import me.obsilabor.alert.Subscribe;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class ClientDisconnectListener {

    GameFrame gameFrame;
    GamePlayer gamePlayer1, gamePlayer2;

    @Subscribe
    public void handle(ClientDisconnectListener event) {
        gameFrame.setVisible(false);
        gameFrame.dispose();

        new ScoreFrame(gamePlayer1.score(), gamePlayer2.score(), gamePlayer1.displayName(), gamePlayer2.displayName());
    }
}
