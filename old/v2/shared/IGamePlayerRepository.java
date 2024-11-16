package de.marlonr.schule.v2.shared;

import de.marlonr.schule.v2.shared.impl.GamePlayerRepositoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public interface IGamePlayerRepository {

    static IGamePlayerRepository getInstance() {
        return new GamePlayerRepositoryImpl();
    }

    @Nullable IGamePlayer getFirstPlayer();

    void setFirstPlayer(@NotNull IGamePlayer player);

    @Nullable IGamePlayer getSecondPlayer();

    void setSecondPlayer(@NotNull IGamePlayer player);

    Boolean allPlayersJoined();

    Boolean setNext(@NotNull IGamePlayer player);

    ArrayList<IGamePlayer> getPlayers();
}
