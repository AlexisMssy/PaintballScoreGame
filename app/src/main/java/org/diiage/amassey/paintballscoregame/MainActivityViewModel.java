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
    MancheRepository mancheRepository;

    public MainActivityViewModel(Application application){
        super(application);

        database = AppDatabase.getInstance(application);

        mancheRepository = new MancheRepository(database);
    }

    //Appel Repository
    public LiveData<List<Manche>> getManches() {
        return mancheRepository.getAll();
    }
}
