package com.example.mvvm.dao;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvvm.model.Actors;

import java.util.List;

//always write @dao anotation to make itDAO

@Dao
public interface ActorDao {

    //Dao refers to data access object
    //Dao is always an interface in which we will declare functions of insert update etc
    //and then we will implement the methods in the Repository Class


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Actors> actorsList);


    //getAllActors to show on the recycler View
    @Query("SELECT * FROM actor")
    LiveData<List<Actors>> getAllActors();
    //to update the data into the Recycler View we will use Recycler View


    @Query("DELETE FROM actor")
    void deleteAll();







}
