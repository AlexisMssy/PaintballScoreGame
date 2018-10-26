package org.diiage.amassey.paintballscoregame;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import org.diiage.amassey.paintballscoregame.Manche.Manche;
import org.diiage.amassey.paintballscoregame.Manche.MancheRepository;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;

public class MainActivityViewModel extends AndroidViewModel {
    private static final String DATABASE_NAME = "PaintballDB";
    AppDatabase database;

    //UserRepository userRepository;
    MancheRepository mancheRepository;

    LiveData<String> hello;
    LiveData<String> nomPrenom;
    LiveData<List<Manche>> manches;

    MutableLiveData<Integer> helloNumber = new MutableLiveData<>();
    MutableLiveData<Long> idUtilisateur = new MutableLiveData<>();
    MutableLiveData<List<Manche>> listeManches = new MutableLiveData<>();



    public MainActivityViewModel(Application application){
        super(application);

        //database = AppDatabase.getInstance(application);
        database = Room.databaseBuilder(application, AppDatabase.class, "database_paintball").build();

        //userRepository = new UserRepository(database);
        mancheRepository = new MancheRepository(database);

        //manches = mancheRepository.getAll();
/*
        manches = Transformations.switchMap(listeManches, manche ->{
            if (manche != null) {
                return mancheRepository.getAll();
            }
            return null;
        });
        */
/*
        hello = Transformations.map(helloNumber, integer->{
            if (integer != null) {
                return "Hello " + integer;
            }
            return "";
        });
        startTimer();
*/
/*
        nomPrenom = Transformations.switchMap(idUtilisateur,id->{
            if (id != null){
                return userRepository.getNomPrenomById(id);
            }
            return null;
        });
*/
    }

    public void setIdUtilisateur(long id){
        idUtilisateur.setValue(id);
    }

    public LiveData<String> getHello() {
        return hello;
    }

    //Appel Repository
    public LiveData<List<Manche>> getManches() {
        return mancheRepository.getAll();
        //return manches;
    }

    public void startTimer(){
        helloNumber.setValue(0);
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (helloNumber.getValue()!=null) {
                    helloNumber.postValue(helloNumber.getValue() + 1);
                }
            }
        },1000,1000);


    }
}
