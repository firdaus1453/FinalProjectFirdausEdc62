package me.firdaus1453.finalprojectfirdausedc62.data.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import me.firdaus1453.finalprojectfirdausedc62.adapter.Contract;
import me.firdaus1453.finalprojectfirdausedc62.data.FootballDataSource;
import me.firdaus1453.finalprojectfirdausedc62.model.ResponseTeams;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FootballRemoteDataSource implements FootballDataSource {

    private final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListTeams(Context context, final GetListTeamsCallBack callBack) {
        Call<ResponseTeams> call = apiInterface.getAllTeams(Contract.S,Contract.C);
        call.enqueue(new Callback<ResponseTeams>() {
            @Override
            public void onResponse(@NonNull Call<ResponseTeams> call,@NonNull Response<ResponseTeams> response) {
                if (response.body() != null){
                    callBack.onSuccess(response.body().getTeams());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseTeams> call,@NonNull Throwable throwable) {
                callBack.onFailed(throwable.toString());
            }
        });
    }
}
