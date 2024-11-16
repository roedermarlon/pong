package com.github.roedermarlon.pong.client.listener;

import com.github.roedermarlon.pong.client.frontend.GameFrame;
import com.github.roedermarlon.pong.client.frontend.ScoreFrame;
import com.github.roedermarlon.pong.shared.GamePlayer;
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
