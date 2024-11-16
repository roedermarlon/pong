package de.marlonr.schule.v2.backend;

import de.marlonr.schule.v2.shared.IGamePlayer;
import dev.httpmarco.osgan.networking.channel.ChannelTransmit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@AllArgsConstructor
public abstract class GamePlayerImpl implements IGamePlayer {

    @NotNull String displayName;
    @NotNull Integer id;
    @Nullable ChannelTransmit channelTransmit;

    @Override
    public @NotNull String getDisplayName() {
        return displayName;
    }

    @Override
    public @NotNull Integer getId() {
        return id;
    }

    @Override
    public @Nullable ChannelTransmit getChannelTransmit() {
        return channelTransmit;
    }
}
