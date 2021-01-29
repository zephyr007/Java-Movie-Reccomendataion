package MovieRecommApp;

import java.util.ArrayList;

public class Movie {
    public int Id;
    public String Name;
    public int Rdate;
    public int Vdate;
    public String Link;
    public String GenreStr;

    public Movie(int id,String name, int rdate, int vdate, String link, String genreStr) {
        Id=id;
        Name = name;
        Rdate = rdate;
        Vdate = vdate;
        Link = link;
        GenreStr = genreStr;
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

    public int getVdate() {
        return Vdate;
    }

    public String getLink() {
        return Link;
    }

    public String getGenreStr() {
        return GenreStr;
    }
}
