package me.firdaus1453.finalprojectfirdausedc62.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.firdaus1453.finalprojectfirdausedc62.Injection;
import me.firdaus1453.finalprojectfirdausedc62.adapter.FootballAdapter;
import me.firdaus1453.finalprojectfirdausedc62.main.MainContract;
import me.firdaus1453.finalprojectfirdausedc62.main.MainPresenter;
import me.firdaus1453.finalprojectfirdausedc62.model.TeamsItem;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(me.firdaus1453.finalprojectfirdausedc62.R.id.rv_teams)
    public RecyclerView recyclerView;

    private ProgressDialog progressDialog;
    private FootballAdapter adapter;
    private final List<TeamsItem> teamsArrayList = new ArrayList<>();
    private final MainPresenter mainPresenter = new MainPresenter(Injection.provideRepository(), this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(me.firdaus1453.finalprojectfirdausedc62.R.layout.activity_main);
        ButterKnife.bind(this);
        initAdapter();
        mainPresenter.getDataListTeams(MainActivity.this);
    }

    private void initAdapter() {
        adapter = new FootballAdapter(getApplicationContext(), teamsArrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setTitle("Harap tunggu");
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showDataList(List<TeamsItem> teamsItemList) {
        teamsArrayList.addAll(teamsItemList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
