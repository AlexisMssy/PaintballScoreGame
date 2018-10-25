package org.diiage.amassey.paintballscoregame.Equipe;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Equipe")
public class Equipe {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nom;

    public Equipe() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
