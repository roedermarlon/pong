package de.marlonr.schule.v2.frontend;

public class Frontend {

    public static void initialize() {
        FrontendCommunicationClient.getInstance().initialize("127.0.0.1", 8080);
    }
}
