package me.firdaus1453.finalprojectfirdausedc62.view;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.firdaus1453.finalprojectfirdausedc62.model.TeamsItem;

public class DetailActivity extends AppCompatActivity {

    @BindView(me.firdaus1453.finalprojectfirdausedc62.R.id.img_stadium)
    public ImageView imgStadium;
    @BindView(me.firdaus1453.finalprojectfirdausedc62.R.id.img_logo_detail)
    public ImageView imgLogo;
    @BindView(me.firdaus1453.finalprojectfirdausedc62.R.id.txt_name_stadium)
    public TextView tvStadium;
    @BindView(me.firdaus1453.finalprojectfirdausedc62.R.id.txt_desc)
    public TextView tvDesc;
    @BindView(me.firdaus1453.finalprojectfirdausedc62.R.id.txt_name_team_detail)
    public TextView tvName;
    @BindView(me.firdaus1453.finalprojectfirdausedc62.R.id.cordinatorLayout)
    public CoordinatorLayout coordinatorLayout;
    @BindView(me.firdaus1453.finalprojectfirdausedc62.R.id.toolbar)
    public Toolbar toolbar;

    public static final String KEY_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(me.firdaus1453.finalprojectfirdausedc62.R.layout.activity_detail);
        ButterKnife.bind(this);

        setFootball();

        toolbar.setTitle("Detail Team");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFootball() {
        Bundle bundle = getIntent().getExtras();

        TeamsItem teamsItem = (TeamsItem) bundle.getSerializable(KEY_DATA);

        RequestOptions options = new RequestOptions().error(me.firdaus1453.finalprojectfirdausedc62.R.drawable.ic_broken_image);

        Glide.with(getApplicationContext()).load(teamsItem.getStrStadiumThumb()).apply(options).into(imgStadium);
        Glide.with(getApplicationContext()).load(teamsItem.getStrTeamBadge()).apply(options).into(imgLogo);
        tvStadium.setText(teamsItem.getStrStadium());
        tvName.setText(teamsItem.getStrTeam());
        tvDesc.setText(teamsItem.getStrDescriptionEN());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
