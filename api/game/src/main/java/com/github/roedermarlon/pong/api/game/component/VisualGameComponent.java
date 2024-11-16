package com.github.roedermarlon.pong.api.game.component;

import com.github.roedermarlon.pong.api.util.OnlyClient;

@OnlyClient
public abstract class VisualGameComponent<C> {

    public abstract void get();
    public abstract void update();
    public abstract void destroy();
}
