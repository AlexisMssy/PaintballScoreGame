package org.diiage.amassey.paintballscoregame.Match;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import org.diiage.amassey.paintballscoregame.Equipe.Equipe;
import org.diiage.amassey.paintballscoregame.Manche.Manche;
import org.diiage.amassey.paintballscoregame.TypeMatch.TypeMatch;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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


    public Match(long id, long numero, Date heure, long typeMatchId, long equipe1Id, long equipe2Id, long scoreEquipe1, long scoreEquipe2, long dureeTotale, long pause, long mancheId) {
        this.id = id;
        this.numero = numero;
        this.heure = heure;
        this.typeMatchId = typeMatchId;
        this.equipe1Id = equipe1Id;
        this.equipe2Id = equipe2Id;
        this.scoreEquipe1 = scoreEquipe1;
        this.scoreEquipe2 = scoreEquipe2;
        this.dureeTotale = dureeTotale;
        this.pause = pause;
        this.mancheId = mancheId;
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

    public static List<Match> populateData() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 10, 25, 9, 0);
        Date date1 = calendar.getTime();
        calendar.set(2018, 10, 25, 9, 30);
        Date date2 = calendar.getTime();
        calendar.set(2018, 10, 25, 9, 45);
        Date date3 = calendar.getTime();
        calendar.set(2018, 10, 25, 10, 15);
        Date date4 = calendar.getTime();
        calendar.set(2018, 10, 25, 10, 30);
        Date date5 = calendar.getTime();
        calendar.set(2018, 10, 25, 11, 0);
        Date date6 = calendar.getTime();
        calendar.set(2018, 10, 25, 11, 15);
        Date date7 = calendar.getTime();
        calendar.set(2018, 10, 25, 11, 30);
        Date date8 = calendar.getTime();
        calendar.set(2018, 10, 25, 11, 45);
        Date date9 = calendar.getTime();
        calendar.set(2018, 10, 25, 12, 0);
        Date date10 = calendar.getTime();
        calendar.set(2018, 10, 25, 12, 15);
        Date date11 = calendar.getTime();
        calendar.set(2018, 10, 25, 12, 30);
        Date date12 = calendar.getTime();

        List<Match> matchs = new ArrayList<>();
        matchs.add(new Match(1, 1, date1, 1, 3, 1, 0, 0, 0, 0, 1));
        matchs.add(new Match(2, 2, date2, 2, 3, 1, 0, 0, 0, 0, 1));
        matchs.add(new Match(3, 3, date3, 1, 2, 1, 0, 0, 0, 0, 1));
        matchs.add(new Match(4, 4, date4, 2, 2, 1, 0, 0, 0, 0, 1));
        matchs.add(new Match(5, 5, date5, 1, 2, 3, 0, 0, 0, 0, 1));
        matchs.add(new Match(6, 6, date6, 2, 2, 3, 0, 0, 0, 0, 1));
        matchs.add(new Match(7, 7, date7, 3, 4, 3, 0, 0, 0, 0, 1));
        matchs.add(new Match(8, 8, date8, 3, 2, 1, 0, 0, 0, 0, 1));
        matchs.add(new Match(9, 9, date9, 3, 4, 1, 0, 0, 0, 0, 1));
        matchs.add(new Match(10, 10, date10, 3, 3, 1, 0, 0, 0, 0, 1));
        matchs.add(new Match(11, 11, date11, 3, 3, 2, 0, 0, 0, 0, 1));
        matchs.add(new Match(12, 12, date12, 3, 4, 2, 0, 0, 0, 0, 1));

        return matchs;
    }
}