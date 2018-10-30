package org.diiage.amassey.paintballscoregame.Manche;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import org.diiage.amassey.paintballscoregame.AppDatabase;
import org.diiage.amassey.paintballscoregame.Match.Match;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class MancheRepository {
    AppDatabase db;

    public MancheRepository(AppDatabase db) {
        this.db = db;
    }
    // TODO : add and update methods


    public LiveData<Manche> get(long id) {
        MediatorLiveData<Manche> manche = new MediatorLiveData<>();

        LiveData<Manche> fromDb = db.mancheDao().get(id);
        LiveData<Manche> fromInternet = getOnline(id);

        manche.addSource(fromInternet,laManche->{
            if (laManche != null) {

                manche.setValue(laManche);
            }
            else{
                manche.addSource(fromDb,manche::setValue);
            }
        });

        return null;
    }

    public LiveData<Manche> getOnline(long id) {
        MediatorLiveData<Manche> manche = new MediatorLiveData<>();

        //TODO : call api method

        return null;
    }

    // TODO : ici exemple !
    /*
    public LiveData<List<Manche>> getAll() {
        MediatorLiveData<List<Manche>> manches = new MediatorLiveData<>();

        LiveData<List<Manche>> fromDb = db.mancheDao().getAll();
        LiveData<List<Manche>> fromInternet = getAllOnline();

        manches.addSource(fromInternet,lesManches->{
            if (lesManches != null) {

                manches.setValue(lesManches);
            }
            else{
                manches.addSource(fromDb,manches::setValue);
            }
        });

        return manches;
    }
*/
    public LiveData<List<Manche>> getAllOnline() {
        MediatorLiveData<Manche> manche = new MediatorLiveData<>();

        //TODO : call api method

        return null;
    }

    public LiveData<List<Manche>> getAll(){
        //Appel dao
        //return db.mancheDao().getAll();
        return db.mancheDao().getAll();
    }

    public LiveData<List<Match>> getMatchsOfManche(long mancheId){
        //Appel dao
        //return db.mancheDao().getAll();
        return db.mancheDao().getMatchsOfManche(mancheId);
    }
}
