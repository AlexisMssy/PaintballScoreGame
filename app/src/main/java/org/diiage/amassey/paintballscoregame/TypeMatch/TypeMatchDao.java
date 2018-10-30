package org.diiage.amassey.paintballscoregame.TypeMatch;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import org.diiage.amassey.paintballscoregame.Equipe.Equipe;

import java.util.List;

@Dao
public interface TypeMatchDao {
    @Insert
    void insertAll(List<TypeMatch> typeMatchs);
}
