package me.firdaus1453.finalprojectfirdausedc62.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.util.List;

import me.firdaus1453.finalprojectfirdausedc62.data.local.FootballDatabase;
import me.firdaus1453.finalprojectfirdausedc62.data.local.FootballLocalDataSource;
import me.firdaus1453.finalprojectfirdausedc62.data.remote.FootballRemoteDataSource;
import me.firdaus1453.finalprojectfirdausedc62.model.TeamsItem;

public class FootballRepository implements FootballDataSource {

    private final FootballRemoteDataSource remoteDataSource;
    private final FootballLocalDataSource localDataSource;
    private FootballDatabase footballDatabase;

    public FootballRepository(FootballRemoteDataSource remoteDataSource, FootballLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }


    @Override
    public void getListTeams(Context context, final GetListTeamsCallBack callBack) {
        NetworkInfo info = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        if (footballDatabase.footballDao().select().size() != 0) {
            Toast.makeText(context, "Use database local", Toast.LENGTH_SHORT).show();
            localDataSource.getListTeams(context, new GetListTeamsCallBack() {
                @Override
                public void onSuccess(List<TeamsItem> data) {
                    callBack.onSuccess(data);
                }

                @Override
                public void onFailed(String errorMessage) {
                    callBack.onFailed(errorMessage);
                }
            });
        }else if(info != null && info.isConnected()) {
            Toast.makeText(context, "Use database cloud", Toast.LENGTH_SHORT).show();
            remoteDataSource.getListTeams(context, new GetListTeamsCallBack() {
                @Override
                public void onSuccess(List<TeamsItem> data) {
                    callBack.onSuccess(data);
                    footballDatabase.footballDao().insert(data);
                }

                @Override
                public void onFailed(String errorMessage) {
                    callBack.onFailed(errorMessage);
                }
            });
        } else {
            callBack.onSuccess(null);
            callBack.onFailed("");
        }
    }
}
