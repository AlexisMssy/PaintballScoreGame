package org.diiage.amassey.paintballscoregame.Equipe;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import org.diiage.amassey.paintballscoregame.Manche.Manche;

import java.util.List;

@Dao
public interface EquipeDao {
    @Insert
    void insertAll(List<Equipe> equipes);
}
