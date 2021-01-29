package MovieRecommApp;

import java.util.ArrayList;

public class Movie {
    public int Id;
    public String Name;
    public int Rdate;
    public String Vdate;
    public String Link;
    public String GenreStr;
    public ArrayList<Integer> ratings;
    public int rating=0;

    public Movie(int id, String name, int rdate, String vdate, String link, String genreStr) {
        Id=id;
        Name = name;
        Rdate = rdate;
        Vdate = vdate;
        Link = link;
        GenreStr = genreStr;
        ratings=new ArrayList<Integer>();
    }

    public double AvgRating(){
        double avg = 0;
        for (int i = 0; i < ratings.size(); i++) {
            avg+=ratings.get(i);
        }
        rating= (int) (avg/ratings.size());
        return rating;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getRdate() {
        return Rdate;
    }

    public String getVdate() {
        return Vdate;
    }

    public String getLink() {
        return Link;
    }

    public String getGenreStr() {
        return GenreStr;
    }
}
