package com.github.roedermarlon.pong.client.frontend;

import com.github.roedermarlon.pong.client.GameClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public class GameFrontend {

    private GameClient gameClient;

    public void start() {
        GameFrame gamePanel = new GameFrame(gameClient);

        gamePanel.setVisible(true);
    }
}
