package com.example.mvvm.model;

//creating this model class into table




import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "actor")  //Entity is just an annotation which is actually replacing the SQL code
public class Actors {

    //creating a primary key
    @PrimaryKey(autoGenerate = true) //it auto increments
    private int actorId;


    //the members name should be same as the Json keys response
    //but if you want different name to be in the model class
    //and those values store the data then we can use @SerializableName("key_name")




    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("age")
    private int age;

    public Actors(int id, String name, String imageUrl, int age) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImage(String image) {
        this.imageUrl = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    //getters and setters for the primary key

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }


    @Override
    public String toString() {
        return "Actors{" +
                "actorId=" + actorId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", age=" + age +
                '}';
    }
}
