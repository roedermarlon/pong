package de.marlonr.schule.v2.shared.impl;

import de.marlonr.schule.v2.shared.IGamePlayer;
import de.marlonr.schule.v2.shared.IGamePlayerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class GamePlayerRepositoryImpl implements IGamePlayerRepository {
    IGamePlayer first = null;
    IGamePlayer second = null;

    @Override
    public @Nullable IGamePlayer getFirstPlayer() {
        return first;
    }

    @Override
    public void setFirstPlayer(@NotNull IGamePlayer player) {
        first = player;
    }

    @Override
    public @Nullable IGamePlayer getSecondPlayer() {
        return second;
    }

    @Override
    public void setSecondPlayer(@NotNull IGamePlayer player) {
        second = player;
    }

    @Override
    public Boolean allPlayersJoined() {
        return first != null && second != null;
    }

    @Override
    public ArrayList<IGamePlayer> getPlayers() {
        ArrayList<IGamePlayer> players = new ArrayList<>();
        if (first != null) {
            players.add(first);
        }
        if (second != null) {
            players.add(second);
        }
        return players;
    }

    @Override
    public Boolean setNext(@NotNull IGamePlayer player) {
        if (first == null) {
            first = player;
        } else if (second == null) {
            second = player;
        }
        return allPlayersJoined();
    }
}
