package org.diiage.amassey.paintballscoregame.Match;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;

import org.diiage.amassey.paintballscoregame.AppDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class MatchRepository {
    AppDatabase db;

    public MatchRepository(AppDatabase db) {
        this.db = db;
    }

    //TODO : add and update methods
    public LiveData<Match> getMatchById(long id){
        MediatorLiveData<Match> match = new MediatorLiveData<>();

        LiveData<Match> fromDb = db.matchDao().getMatchById(id);
        LiveData<Match> fromInternet = getMatchByIdOnline(id);

        match.addSource(fromDb,match::setValue);
        match.addSource(fromInternet,leNomPrenom->{
            if (leNomPrenom != null) {
                //db.userDao().update(leNomPrenom);

                match.setValue(leNomPrenom);
            }
        });

        return match;
    }

    private LiveData<Match> getMatchByIdOnline(long id){
        MutableLiveData<Match> match = new MutableLiveData<>();



        return  match;
    }
}
