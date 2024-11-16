package de.marlonr.game.client.frontend;

import de.marlonr.game.client.GameClient;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class GameFrame extends JFrame {

    private final GamePanel gamePanel;
    private final GameClient gameClient;

    public GameFrame(GameClient gameClient) {
        this.gameClient = gameClient;

        setTitle("Pong Game | " + gameClient.getPlayerName());
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gamePanel = new GamePanel(gameClient, this);
        add(gamePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}