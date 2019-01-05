package me.firdaus1453.finalprojectfirdausedc62.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import me.firdaus1453.finalprojectfirdausedc62.model.TeamsItem;

@Dao
public interface FootballDao {

    @Insert
    void insert(List<TeamsItem> teamsItemList);

    @Query("SELECT * FROM teams ORDER BY strTeam ASC")
    List<TeamsItem> select();

    @Delete
    void delete(TeamsItem teamsItem);

    @Update
    void update(TeamsItem teamsItem);

}
