package org.diiage.amassey.paintballscoregame.Manche;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.diiage.amassey.paintballscoregame.Match.Match;

import java.util.List;

@Dao
public interface MancheDao {

    @Query("SELECT * FROM `manche`")
    LiveData<List<Manche>> getAll();

    @Query("SELECT * FROM `manche` WHERE id = :id")
    LiveData<Manche> get(long id);

    @Query("SELECT * FROM `match` WHERE mancheId = :id")
    LiveData<Match> getMatchsOfManche(long id);

    @Insert
    void insertAll(List<Manche> manches);
}
