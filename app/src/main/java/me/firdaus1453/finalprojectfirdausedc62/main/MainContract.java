package me.firdaus1453.finalprojectfirdausedc62.main;

import android.content.Context;

import java.util.List;

import me.firdaus1453.finalprojectfirdausedc62.model.TeamsItem;

public interface MainContract {

    interface View{
        void showProgress();
        void hideProgress();
        void showDataList(List<TeamsItem> teamsItemList);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataListTeams(Context context);
    }

}
