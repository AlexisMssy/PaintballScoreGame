package org.diiage.amassey.paintballscoregame.Equipe;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.telephony.euicc.EuiccInfo;

import org.diiage.amassey.paintballscoregame.Manche.Manche;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "Equipe")
public class Equipe {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nom;

    public Equipe(long id, String nom) {
        this.id = id;
        this.nom = nom;
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

    public static List<Equipe> populateData() {

        List<Equipe> equipes = new ArrayList<>();
        equipes.add(new Equipe(4, "Low Coast"));
        equipes.add(new Equipe(2, "Electron"));
        equipes.add(new Equipe(1, "Jack's Team"));
        equipes.add(new Equipe(3, "Paint Factory"));

        return equipes;
    }
}
