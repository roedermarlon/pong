package rendering;

import rendering.components.StringComponent;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {

    private final JFrame parent;

    public StartWindow(JFrame parent) {
        this.parent = parent;

        add(new StringComponent("Klick hier um zu spielen", 100, 100));
        add(buildStartButton());

        super.setSize(1280, 720);
    }

    @Override
    public Container getParent() {
        if (parent != null)
            return parent;
        return super.getParent();
    }

    private JButton buildStartButton() {
        JButton button = new JButton("Start");

        button.addActionListener(e -> System.out.println("clicked"));

        return button;
    }
}
