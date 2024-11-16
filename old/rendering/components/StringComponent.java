package rendering.components;

import java.awt.*;

public class StringComponent extends Component {

    private final String text;
    private final int x;
    private final int y;

    public StringComponent(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(text, x, y);
    }

    public String getText() {
        return text;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
