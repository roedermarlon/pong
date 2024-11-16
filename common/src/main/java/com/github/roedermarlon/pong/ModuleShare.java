package com.github.roedermarlon.pong;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Used to abstractly call code between the client and server.
 */
public abstract class ModuleShare {

    @Getter
    /**
     * The instance of the module.
     */
    @Nullable
    private static ModuleShare instance;

    /**
     * sets the instance
     */
    public ModuleShare() {
        instance = this;
    }

    public static Optional<ModuleShare> getInstanceOptional() {
        return Optional.ofNullable(instance);
    }

    /**
     * Starts the client.
     *
     * @param host The host to connect to.
     * @param port The port to connect to.
     */
    public abstract void startServer(String host, int port);
}
