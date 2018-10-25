package org.diiage.amassey.paintballscoregame.Match;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface MatchDao {

    @Update
    void update(Match match);

    @Query("SELECT * FROM `match` WHERE id = :id")
    LiveData<Match> getMatchById(long id);
}
