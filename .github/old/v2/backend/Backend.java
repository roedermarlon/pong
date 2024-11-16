package de.marlonr.schule.v2.backend;

public class Backend {

    public static void initialize() {
        BackendCommunicationServer.getInstance().initialize();
    }
}
