package org.diiage.amassey.paintballscoregame.TypeMatch;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.diiage.amassey.paintballscoregame.Equipe.Equipe;
import org.diiage.amassey.paintballscoregame.Match.Match;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity(tableName = "TypeMatch")
public class TypeMatch {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nom;
    private long pointGagnant;
    private long nombreJoueurs;
    private long duree;

    public TypeMatch(long id, String nom, long pointGagnant, long nombreJoueurs, long duree) {
        this.id = id;
        this.nom = nom;
        this.pointGagnant = pointGagnant;
        this.nombreJoueurs = nombreJoueurs;
        this.duree = duree;
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

    public static List<TypeMatch> populateData() {
        List<TypeMatch> typematchs = new ArrayList<>();
        typematchs.add(new TypeMatch(1, "D2", 4, 6, 3));
        typematchs.add(new TypeMatch(2, "D3", 1, 8, 5));
        typematchs.add(new TypeMatch(3, "D4", 1, 6, 3));

        return typematchs;
    }
}
