package me.firdaus1453.finalprojectfirdausedc62.main;

import android.content.Context;

import java.util.List;

import me.firdaus1453.finalprojectfirdausedc62.data.FootballDataSource;
import me.firdaus1453.finalprojectfirdausedc62.data.FootballRepository;
import me.firdaus1453.finalprojectfirdausedc62.model.TeamsItem;

public class MainPresenter implements MainContract.Presenter {

    private final FootballRepository repository;
    private final MainContract.View view;

    public MainPresenter(FootballRepository repository, MainContract.View view) {
        this.repository = repository;
        this.view = view;
    }


    @Override
    public void getDataListTeams(Context context) {
        view.showProgress();
        repository.getListTeams(context, new FootballDataSource.GetListTeamsCallBack() {
            @Override
            public void onSuccess(List<TeamsItem> data) {
                view.hideProgress();
                view.showDataList(data);
            }

            @Override
            public void onFailed(String errorMessage) {
                view.hideProgress();
                view.showFailureMessage(errorMessage);
            }
        });
    }
}
