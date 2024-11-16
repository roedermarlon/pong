import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener {
    private final int PADDLE_WIDTH = 10, PADDLE_HEIGHT = 100;
    private final int BALL_SIZE = 20;
    private int paddle1Y = 250, paddle2Y = 250;
    private int ballX = 390, ballY = 290;
    private int ballXDir = -1, ballYDir = -1;
    private Timer timer;

    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_W && paddle1Y > 0) {
                    paddle1Y -= 20;
                }
                if (key == KeyEvent.VK_S && paddle1Y < getHeight() - PADDLE_HEIGHT) {
                    paddle1Y += 20;
                }
                if (key == KeyEvent.VK_UP && paddle2Y > 0) {
                    paddle2Y -= 20;
                }
                if (key == KeyEvent.VK_DOWN && paddle2Y < getHeight() - PADDLE_HEIGHT) {
                    paddle2Y += 20;
                }
            }
        });
        timer = new Timer(5, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(30, paddle1Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillRect(getWidth() - 40, paddle2Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ballX += ballXDir;
        ballY += ballYDir;

        if (ballY <= 0 || ballY >= getHeight() - BALL_SIZE) {
            ballYDir = -ballYDir;
        }

        if (ballX <= 40 && ballY >= paddle1Y && ballY <= paddle1Y + PADDLE_HEIGHT) {
            ballXDir = -ballXDir;
        }

        if (ballX >= getWidth() - 60 && ballY >= paddle2Y && ballY <= paddle2Y + PADDLE_HEIGHT) {
            ballXDir = -ballXDir;
        }

        if (ballX < 0 || ballX > getWidth()) {
            ballX = 390;
            ballY = 290;
            ballXDir = -1;
            ballYDir = -1;
        }

        repaint();
    }
}