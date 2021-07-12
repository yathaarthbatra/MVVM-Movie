package com.example.mvvm.database;


import android.content.Context;
import android.os.AsyncTask;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mvvm.dao.ActorDao;
import com.example.mvvm.model.Actors;

//inserting the tables into the Database
@Database(entities = {Actors.class},version = 1)
public abstract class ActorDatabase extends RoomDatabase {

    //give the name to the database
    private static final String DATABASE_NAME="ActorDatabase";


    //to call the functions of the ActorDao
    public abstract ActorDao actorDao();

    private static volatile ActorDatabase INSTANCE;
    //volatile is actually used to modify the variable by different threads

    //function to intilalize Instance

    //to create the database
    public static ActorDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ActorDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, ActorDatabase.class, DATABASE_NAME).
                            addCallback(callback).build();
                }
            }
        }

        return INSTANCE;
    }

    static Callback callback=new Callback() {
        @Override
        public void onCreate(SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    static class PopulateAsyncTask extends AsyncTask<Void,Void,Void>{

        private ActorDao actorDao;

        PopulateAsyncTask(ActorDatabase actorDatabase){
            actorDao=actorDatabase.actorDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            actorDao.deleteAll();
            return null;
        }
    }

}
