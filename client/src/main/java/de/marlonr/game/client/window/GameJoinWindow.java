package de.marlonr.game.client.window;

import de.marlonr.game.client.GameClient;
import de.marlonr.game.client.event.impl.ClientConnectionFailedEvent;
import de.marlonr.game.client.event.impl.ClientPostConnectEvent;
import me.obsilabor.alert.EventManager;
import me.obsilabor.alert.Subscribe;

import javax.swing.*;
import java.awt.*;

public class GameJoinWindow extends JFrame {
    private final JTextField ipField;
    private final JTextField portField;
    private final JTextField playerNameField;

    public GameJoinWindow() {
        EventManager.registerListener(new Listener());

        setTitle("Join Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("IP Address:"));
        ipField = new JTextField();
        add(ipField);

        add(new JLabel("Port:"));
        portField = new JTextField();
        portField.setText("8080");
        add(portField);

        add(new JLabel("Player Name:"));
        playerNameField = new JTextField();
        playerNameField.setText(System.getProperty("user.name"));
        add(playerNameField);

        JButton joinButton = new JButton("Join");
        add(joinButton);

        joinButton.addActionListener(e -> {
            String ip = ipField.getText();
            int port = Integer.parseInt(portField.getText());
            String playerName = playerNameField.getText();
            joinGame(ip, port, playerName);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameJoinWindow::new);
    }

    private void joinGame(String ip, int port, String playerName) {
        GameClient client = new GameClient(playerName);
        client.initialize(ip, port);
    }

    public class Listener {

        @Subscribe
        public void handle(ClientConnectionFailedEvent event) {
            if (isActive())
                JOptionPane.showMessageDialog(GameJoinWindow.this, "Connection to server failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        @Subscribe
        public void handle(ClientPostConnectEvent event) {

            if (isActive()) {
                dispose();
                class DaemonThread extends Thread {
                    public DaemonThread() {
                        setDaemon(true);
                    }

                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(null, "Connected to server! Waiting for game...", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                DaemonThread daemonThread = new DaemonThread();
                daemonThread.start();
                // TODO: invoke ingame screen when game is started
            }
        }
    }
}