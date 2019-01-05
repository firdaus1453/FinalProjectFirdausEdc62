package me.firdaus1453.finalprojectfirdausedc62.data;

import android.content.Context;

import java.util.List;

import me.firdaus1453.finalprojectfirdausedc62.model.TeamsItem;

public interface FootballDataSource {

    void getListTeams(Context context, GetListTeamsCallBack callBack);

    interface GetListTeamsCallBack{
        void onSuccess(List<TeamsItem> data);
        void onFailed(String errorMessage);
    }
}
