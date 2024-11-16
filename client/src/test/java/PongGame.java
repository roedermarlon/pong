import javax.swing.*;

public class PongGame extends JFrame {
    public PongGame() {
        setTitle("Pong Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(new GamePanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PongGame::new);
    }
}