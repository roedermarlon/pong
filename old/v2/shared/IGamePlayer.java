package de.marlonr.schule.v2.shared;

import dev.httpmarco.osgan.networking.channel.ChannelTransmit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IGamePlayer {

    @NotNull
    String getDisplayName();

    @NotNull
    Integer getId();

    @Nullable
    ChannelTransmit getChannelTransmit();

    int getScore();

    void updateScore(int score);

    void updateField();
}
