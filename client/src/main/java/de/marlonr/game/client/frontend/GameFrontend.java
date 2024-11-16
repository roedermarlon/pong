package de.marlonr.game.client.frontend;

import de.marlonr.game.client.GameClient;
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
