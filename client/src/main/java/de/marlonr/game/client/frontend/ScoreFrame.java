package de.marlonr.game.client.frontend;

import javax.swing.*;

public class ScoreFrame extends JFrame {

    public ScoreFrame(int player1, int player2, String player1Name, String player2Name) {
        setTitle("Scoreboard");
        setSize(200, 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        var score1Label = new JLabel("Player 1 (%s): %s".formatted(player1Name, player1));
        var score2Label = new JLabel("Player 2 (%s): %s".formatted(player2Name, player2));

        add(score1Label);
        add(score2Label);

        setVisible(true);
    }
}
