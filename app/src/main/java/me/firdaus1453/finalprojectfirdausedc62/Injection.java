package me.firdaus1453.finalprojectfirdausedc62;

import me.firdaus1453.finalprojectfirdausedc62.data.FootballRepository;
import me.firdaus1453.finalprojectfirdausedc62.data.local.FootballLocalDataSource;
import me.firdaus1453.finalprojectfirdausedc62.data.remote.FootballRemoteDataSource;

public class Injection {
    public static FootballRepository provideRepository(){
        return new FootballRepository(new FootballRemoteDataSource(), new FootballLocalDataSource());
    }
}
