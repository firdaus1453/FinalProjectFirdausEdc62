package me.firdaus1453.finalprojectfirdausedc62.data.remote;

import me.firdaus1453.finalprojectfirdausedc62.model.ResponseTeams;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("search_all_teams.php")
    Call<ResponseTeams> getAllTeams(
            @Query("s") String s,
            @Query("c") String c
    );
}
