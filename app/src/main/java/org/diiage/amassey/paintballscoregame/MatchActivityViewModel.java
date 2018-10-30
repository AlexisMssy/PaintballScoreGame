package org.diiage.amassey.paintballscoregame;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import org.diiage.amassey.paintballscoregame.Manche.MancheRepository;
import org.diiage.amassey.paintballscoregame.Match.Match;
import org.diiage.amassey.paintballscoregame.Match.MatchRepository;

import java.util.List;

public class MatchActivityViewModel extends AndroidViewModel {
    private static final String DATABASE_NAME = "PaintballDB";
    AppDatabase database;
    MancheRepository mancheRepository;

    public MatchActivityViewModel(Application application){
        super(application);
        database = AppDatabase.getInstance(application);
        mancheRepository = new MancheRepository(database);
    }

    //Appel Repository
    public LiveData<List<Match>> getMatchs(long mancheId) {
        return mancheRepository.getMatchsOfManche(mancheId);
    }
}
