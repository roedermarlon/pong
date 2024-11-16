package com.github.roedermarlon.pong.client.frontend;

import com.github.roedermarlon.pong.ModuleShare;
import com.github.roedermarlon.pong.client.GameClient;

import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class StartGameFrame extends JFrame {

    public StartGameFrame() {
        setTitle("Pong Game");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        var startButton = new JButton("Start Game");
        startButton.addActionListener(e -> ModuleShare.getInstanceOptional().ifPresentOrElse(moduleShare -> {
            moduleShare.startServer("0.0.0.0", 8080);
            new GameClient(System.getProperty("user.name")).initialize("0.0.0.0", 8080);
            try {
                JOptionPane.showMessageDialog(this, "Game started! Waiting for more players. (IP: %s, Port: %s)".formatted(InetAddress.getLocalHost().getHostAddress(), 8080), "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (UnknownHostException ex) {
                throw new RuntimeException(ex);
            }
            setVisible(false);
        }, () -> JOptionPane.showMessageDialog(this, "Server could not be started! This client doesn't contain the server internals.", "Error", JOptionPane.ERROR_MESSAGE)));

        add(startButton);

        setVisible(true);
    }
}
