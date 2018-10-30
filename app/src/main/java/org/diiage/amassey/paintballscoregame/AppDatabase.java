package org.diiage.amassey.paintballscoregame;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import org.diiage.amassey.paintballscoregame.Equipe.Equipe;
import org.diiage.amassey.paintballscoregame.Equipe.EquipeDao;
import org.diiage.amassey.paintballscoregame.Manche.Manche;
import org.diiage.amassey.paintballscoregame.Manche.MancheDao;
import org.diiage.amassey.paintballscoregame.Match.Match;
import org.diiage.amassey.paintballscoregame.Match.MatchDao;
import org.diiage.amassey.paintballscoregame.TypeMatch.TypeMatch;
import org.diiage.amassey.paintballscoregame.TypeMatch.TypeMatchDao;

import java.util.concurrent.Executors;

//@Database(version = 1, entities = {Match.class})
@Database(version = 1, entities = {Match.class, Manche.class, Equipe.class, TypeMatch.class})
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "PaintballDB";
    private static AppDatabase INSTANCE;

    abstract public MatchDao matchDao();
    abstract public MancheDao mancheDao();
    abstract public EquipeDao equipeDao();
    abstract public TypeMatchDao typeMatchDao();

    public synchronized static AppDatabase getInstance(Application application) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(application);
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(final Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, DATABASE_NAME)
            .addCallback(new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                        @Override
                        public void run() {
                            getInstance(application).typeMatchDao().insertAll(TypeMatch.populateData());
                            getInstance(application).equipeDao().insertAll(Equipe.populateData());
                            getInstance(application).mancheDao().insertAll(Manche.populateData());
                            getInstance(application).matchDao().insertAll(Match.populateData());
                        }
                    });
                }
            })
            .build();
    }
}
