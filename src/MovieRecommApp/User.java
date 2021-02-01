package MovieRecommApp;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.PriorityQueue;

public class User {
    public int Id;
    public int age;
    public String gender;
    public String occ;
    public String zip;
    public PriorityQueue<Pair<Integer,Integer>> movieRatingPQ;
    public HashMap<Integer,Integer> watchedMovies;

    public User(int id, int age, String gender, String occ, String zip) {
        Id = id;
        this.age = age;
        this.gender = gender;
        this.occ = occ;
        this.zip = zip;

        movieRatingPQ= new PriorityQueue<>();
        watchedMovies= new HashMap<Integer, Integer>();
    }

    public int getId() {
        return Id;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getOcc() {
        return occ;
    }

    public String getZip() {
        return zip;
    }
}
