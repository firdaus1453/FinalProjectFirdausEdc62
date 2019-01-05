package me.firdaus1453.finalprojectfirdausedc62.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTeams {

    @SerializedName("teams")
    private List<TeamsItem> teams;

    public List<TeamsItem> getTeams() {
        return teams;
    }
}
