package org.diiage.amassey.paintballscoregame.TypeMatch;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "TypeMatch")
public class TypeMatch {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nom;
    private long pointGagnant;
    private long nombreJoueurs;
    private long duree;

    public TypeMatch() {
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

    public long getPointGagnant() {
        return pointGagnant;
    }

    public void setPointGagnant(long pointGagnant) {
        this.pointGagnant = pointGagnant;
    }

    public long getNombreJoueurs() {
        return nombreJoueurs;
    }

    public void setNombreJoueurs(long nombreJoueurs) {
        this.nombreJoueurs = nombreJoueurs;
    }

    public long getDuree() {
        return duree;
    }

    public void setDuree(long duree) {
        this.duree = duree;
    }

}
