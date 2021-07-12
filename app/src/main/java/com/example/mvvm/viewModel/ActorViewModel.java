package com.example.mvvm.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvm.model.Actors;
import com.example.mvvm.repository.ActorRepository;

import java.util.List;

public class ActorViewModel extends AndroidViewModel {

    private ActorRepository actorRepository;
    private LiveData<List<Actors>> getAllactors;



    public ActorViewModel(Application application) {
        super(application);
        actorRepository=new ActorRepository(application);
        getAllactors=actorRepository.getAllActors();
    }


    public void insert(List<Actors> list){
        actorRepository.insert(list);
    }

    public LiveData<List<Actors>> getAllActors(){
        return getAllactors;
    }
}
