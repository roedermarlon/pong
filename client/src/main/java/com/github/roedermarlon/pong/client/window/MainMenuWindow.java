package com.github.roedermarlon.pong.client.window;

import com.github.roedermarlon.pong.client.frontend.StartGameFrame;

import javax.swing.*;
import java.awt.*;

public class MainMenuWindow extends JFrame {

    public MainMenuWindow() {
        setTitle("Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(e -> startGame());
        add(startGameButton);

        JButton joinGameButton = new JButton("Join Game");
        joinGameButton.addActionListener(e -> joinGame());
        add(joinGameButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);

        setVisible(true);
    }

    private void startGame() {
        new StartGameFrame();
        System.out.println("Starting game...");
    }

    private void joinGame() {
        new GameJoinWindow();
        dispose();
    }
}