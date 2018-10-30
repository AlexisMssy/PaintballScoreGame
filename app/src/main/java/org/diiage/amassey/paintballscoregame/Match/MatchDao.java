package org.diiage.amassey.paintballscoregame.Match;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.diiage.amassey.paintballscoregame.Equipe.Equipe;

import java.util.List;

@Dao
public interface MatchDao {

    @Update
    void update(Match match);

    @Query("SELECT * FROM `match` WHERE id = :id")
    LiveData<Match> getMatchById(long id);

    @Insert
    void insertAll(List<Match> matchs);
}
