package org.diiage.amassey.paintballscoregame.Manche;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Entity(tableName = "Manche")
public class Manche {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long numero;
    private Date date;

    public Manche(long id, long numero, Date date) {
        this.id = id;
        this.numero = numero;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static List<Manche> populateData() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 10, 25);
        Date date1 = calendar.getTime();
        calendar.set(2018, 10, 26);
        Date date2 = calendar.getTime();
        calendar.set(2018, 10, 27);
        Date date3 = calendar.getTime();

        List<Manche> manches = new ArrayList<>();
        manches.add(new Manche(1, 1, date1));
        manches.add(new Manche(2, 2, date2));
        manches.add(new Manche(3, 3, date3));

        return manches;
    }
}
