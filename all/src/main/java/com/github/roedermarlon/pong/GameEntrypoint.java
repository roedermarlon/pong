package com.github.roedermarlon.pong;

import com.github.roedermarlon.pong.client.window.MainMenuWindow;

public class GameEntrypoint {

    public static void main(String[] args) {
        new ModuleShareImpl(); // Initialize the module share

        MainMenuWindow window = new MainMenuWindow();
        window.setVisible(true);
    }
}