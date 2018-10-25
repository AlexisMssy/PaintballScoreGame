package org.diiage.amassey.paintballscoregame.Match;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import org.diiage.amassey.paintballscoregame.Equipe.Equipe;
import org.diiage.amassey.paintballscoregame.Manche.Manche;
import org.diiage.amassey.paintballscoregame.TypeMatch.TypeMatch;

import java.util.Date;

@Entity(tableName = "Match",
    foreignKeys = {
        @ForeignKey(entity = TypeMatch.class,
            parentColumns = "id",
            childColumns = "typeMatchId"),
        @ForeignKey(entity = Equipe.class,
            parentColumns = "id",
            childColumns = "equipe1Id"),
        @ForeignKey(entity = Equipe.class,
            parentColumns = "id",
            childColumns = "equipe2Id"),
        @ForeignKey(entity = Manche.class,
            parentColumns = "id",
            childColumns = "mancheId")},
    indices = {
        @Index(value = {"typeMatchId"}),
        @Index(value = {"equipe1Id"}),
        @Index(value = {"equipe2Id"}),
        @Index(value = {"mancheId"})
    })
public class Match {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long numero;
    private Date heure;
    private long typeMatchId;
    private long equipe1Id;
    private long equipe2Id;
    private long scoreEquipe1;
    private long scoreEquipe2;
    private long dureeTotale;
    private long pause;
    private long mancheId;

    public Match() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public long getTypeMatchId() {
        return typeMatchId;
    }

    public void setTypeMatchId(long typeMatchId) {
        this.typeMatchId = typeMatchId;
    }

    public long getEquipe1Id() {
        return equipe1Id;
    }

    public void setEquipe1Id(long equipe1Id) {
        this.equipe1Id = equipe1Id;
    }

    public long getEquipe2Id() {
        return equipe2Id;
    }

    public void setEquipe2Id(long equipe2Id) {
        this.equipe2Id = equipe2Id;
    }

    public long getScoreEquipe1() {
        return scoreEquipe1;
    }

    public void setScoreEquipe1(long scoreEquipe1) {
        this.scoreEquipe1 = scoreEquipe1;
    }

    public long getScoreEquipe2() {
        return scoreEquipe2;
    }

    public void setScoreEquipe2(long scoreEquipe2) {
        this.scoreEquipe2 = scoreEquipe2;
    }

    public long getDureeTotale() {
        return dureeTotale;
    }

    public void setDureeTotale(long dureeTotale) {
        this.dureeTotale = dureeTotale;
    }

    public long getPause() {
        return pause;
    }

    public void setPause(long pause) {
        this.pause = pause;
    }

    public long getMancheId() {
        return mancheId;
    }

    public void setMancheId(long mancheId) {
        this.mancheId = mancheId;
    }
}
