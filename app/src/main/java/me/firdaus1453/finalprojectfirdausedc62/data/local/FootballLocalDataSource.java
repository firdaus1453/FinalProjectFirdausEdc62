package me.firdaus1453.finalprojectfirdausedc62.data.local;

import android.content.Context;

import me.firdaus1453.finalprojectfirdausedc62.data.FootballDataSource;

public class FootballLocalDataSource implements FootballDataSource {
    @Override
    public void getListTeams(Context context, GetListTeamsCallBack callBack) {
        FootballDatabase footballDatabase = FootballDatabase.getFootballDatabase(context);
        if (footballDatabase.footballDao().select() != null){
            callBack.onSuccess(footballDatabase.footballDao().select());
        }else {
            callBack.onFailed("No database on local");
        }
    }
}
