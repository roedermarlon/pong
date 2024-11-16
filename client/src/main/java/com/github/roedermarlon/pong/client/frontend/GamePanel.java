package com.github.roedermarlon.pong.client.frontend;

import com.github.roedermarlon.pong.client.GameClient;
import com.github.roedermarlon.pong.packet.PaddleUpdatePacket;
import com.github.roedermarlon.pong.packet.s2c.S2CBallPositionUpdatePacket;
import com.github.roedermarlon.pong.packet.s2c.S2CScoreUpdatePacket;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
public class GamePanel extends JPanel {
    private final GameClient gameClient;
    private final int PADDLE_WIDTH = 10, PADDLE_HEIGHT = 100;
    private final int BALL_SIZE = 20;
    private int paddle1Y = 250;
    private int paddle2Y = 250;
    private int ballX = 390;
    private int ballY = 290;

    public GamePanel(GameClient gameClient, GameFrame gameFrame) {
        System.out.println("invoke");

        gameClient.getCommunicationClient().listen(PaddleUpdatePacket.class, packet -> {
            System.out.println("got packet " + packet);
            updatePaddleY(packet.playerId(), packet.y());
        });

        gameClient.getCommunicationClient().listen(S2CBallPositionUpdatePacket.class, packet -> {
            System.out.println("got packet " + packet);
            ballX = packet.x();
            ballY = packet.y();
            repaint();
        });

        gameClient.getCommunicationClient().listen(S2CScoreUpdatePacket.class, packet -> { // TODO: swap to GameClient
            gameFrame.setTitle("Pong Game | " + gameClient.getPlayerName() + " | Score: " + packet.score1() + " - " + packet.score2());
        });

        setBackground(Color.BLACK);
        setFocusable(true);
        this.gameClient = gameClient;

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                System.out.println(key);

                if (gameClient.getPlayerId() == 1) {
                    if (key == KeyEvent.VK_W && paddle1Y > 0) {
                        paddle1Y -= 20;
                    }
                    if (key == KeyEvent.VK_S && paddle1Y < getHeight() - PADDLE_HEIGHT) {
                        paddle1Y += 20;
                    }

                    if (key == KeyEvent.VK_UP && paddle1Y > 0) {
                        paddle1Y -= 20;
                    }
                    if (key == KeyEvent.VK_DOWN && paddle1Y < getHeight() - PADDLE_HEIGHT) {
                        paddle1Y += 20;
                    }
                } else {
                    if (key == KeyEvent.VK_W && paddle2Y > 0) {
                        paddle2Y -= 20;
                    }
                    if (key == KeyEvent.VK_S && paddle2Y < getHeight() - PADDLE_HEIGHT) {
                        paddle2Y += 20;
                    }

                    if (key == KeyEvent.VK_UP && paddle2Y > 0) {
                        paddle2Y -= 20;
                    }
                    if (key == KeyEvent.VK_DOWN && paddle2Y < getHeight() - PADDLE_HEIGHT) {
                        paddle2Y += 20;
                    }
                }

                gameClient.getCommunicationClient().sendPacket(new PaddleUpdatePacket(gameClient.getPlayerId(), (gameClient.getPlayerId() == 1) ? paddle1Y : paddle2Y));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(30, paddle1Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillRect(getWidth() - 40, paddle2Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }

    public void updateGameState(int paddle1Y, int paddle2Y, int ballX, int ballY) {
        this.paddle1Y = paddle1Y;
        this.paddle2Y = paddle2Y;
        this.ballX = ballX;
        this.ballY = ballY;
        repaint();
    }

    public void updatePaddleY(int paddleId, int paddleY) {
        if (paddleId == 1) {
            paddle1Y = paddleY;
        } else {
            paddle2Y = paddleY;
        }
        repaint();
    }
}