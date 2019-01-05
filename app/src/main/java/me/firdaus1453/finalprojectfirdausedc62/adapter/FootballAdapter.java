package me.firdaus1453.finalprojectfirdausedc62.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import me.firdaus1453.finalprojectfirdausedc62.model.TeamsItem;
import me.firdaus1453.finalprojectfirdausedc62.view.DetailActivity;

public class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.ViewHolder> {

    private final Context context;
    private final List<TeamsItem> listTeams;

    public FootballAdapter(Context context, List<TeamsItem> listTeams) {
        this.context = context;
        this.listTeams = listTeams;
    }


    @NonNull
    @Override
    public FootballAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(me.firdaus1453.finalprojectfirdausedc62.R.layout.item_team_football,parent,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballAdapter.ViewHolder holder, int position) {
        final TeamsItem teamsItem = listTeams.get(position);

        RequestOptions options = new RequestOptions().error(me.firdaus1453.finalprojectfirdausedc62.R.drawable.ic_broken_image);

        Glide.with(context).load(teamsItem.getStrTeamBadge()).apply(options).into(holder.imgLogoTeam);
        holder.txtNameTeam.setText(teamsItem.getStrTeam());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra(DetailActivity.KEY_DATA,teamsItem);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTeams.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgLogoTeam;
        private final TextView txtNameTeam;
        private final CardView cv;

        ViewHolder(View itemView) {
            super(itemView);
            imgLogoTeam = itemView.findViewById(me.firdaus1453.finalprojectfirdausedc62.R.id.img_logo_team);
            txtNameTeam = itemView.findViewById(me.firdaus1453.finalprojectfirdausedc62.R.id.txt_name_team);
            cv = itemView.findViewById(me.firdaus1453.finalprojectfirdausedc62.R.id.card_view);
        }
    }
}
