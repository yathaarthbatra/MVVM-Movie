package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm.adapters.ActorAdapter;
import com.example.mvvm.model.Actors;
import com.example.mvvm.network.Api;
import com.example.mvvm.repository.ActorRepository;
import com.example.mvvm.viewModel.ActorViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private ActorViewModel actorViewModel;
    private static final String URL="http://www.codingwithjks.tech/data.php";
    private RecyclerView recyclerView;
    private ActorAdapter actorAdapter;
    private List<Actors> actorsList;
    private ActorRepository actorRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        actorAdapter=new ActorAdapter(this,actorsList);
        actorsList=new ArrayList<>();

        actorRepository=new ActorRepository(getApplication());
        actorViewModel=new ViewModelProvider(this).get(ActorViewModel.class);
        actorViewModel.getAllActors().observe(this, new Observer<List<Actors>>() {
            @Override
            public void onChanged(List<Actors> actorsList) {
                actorAdapter.setActorsList(actorsList);
                recyclerView.setAdapter(actorAdapter);
            }
        });

        //performing network Request
        networkRequest();
    }

    private void networkRequest(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api =retrofit.create(Api.class);

        //making request
        Call<List<Actors>> call=api.getAllActors();

        call.enqueue(new Callback<List<Actors>>() {
            @Override
            public void onResponse(Call<List<Actors>> call, Response<List<Actors>> response) {
                //if response is successful
                if(response.isSuccessful()){
                    actorRepository.insert(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<Actors>> call, Throwable t) {
                //if response is unsuccessful

            }
        });
    }
}