package com.example.mvvm.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;

import com.example.mvvm.dao.ActorDao;
import com.example.mvvm.database.ActorDatabase;
import com.example.mvvm.model.Actors;

import java.util.List;

public class ActorRepository {
    private ActorDatabase database;
    private LiveData<List<Actors>> getAllActors;

    //first making the constructor
    public ActorRepository(Application application){
        database=ActorDatabase.getInstance(application);
        getAllActors=database.actorDao().getAllActors();
    }

    public void insert(List<Actors> actorsList){
        new InsertAsyncTask(database).execute(actorsList);
    }


    public LiveData<List<Actors>> getAllActors(){
        return getAllActors;
    }


    //we have to do insertion in the background
    static class InsertAsyncTask extends AsyncTask<List<Actors>,Void,Void>{

        private ActorDao actorDao;

        InsertAsyncTask(ActorDatabase actorDatabase){
            actorDao=actorDatabase.actorDao();
        }

        @Override
        protected Void doInBackground(List<Actors>... lists) {
            actorDao.insert(lists[0]);
            return null;
        }
    }





}
