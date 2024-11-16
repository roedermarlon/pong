package de.marlonr.game;

import de.marlonr.game.client.window.MainMenuWindow;

public class GameEntrypoint {

    public static void main(String[] args) {
        new ModuleShareImpl(); // Initialize the module share

        MainMenuWindow window = new MainMenuWindow();
        window.setVisible(true);
    }
}