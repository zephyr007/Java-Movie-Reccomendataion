package test;

public class MovieModel {
    public int id;
    public String Name;
    public String Link;
    public String Genrestring;

    public MovieModel(int id, String name, String link, String genrestring) {
        this.id = id;
        this.Name = name;
        this.Link = link;
        this.Genrestring = genrestring;
    }

    public MovieModel(String line) {
        String[] split = line.split("\\|"); //WHY \\| is needed? | is an operator thats why "\\"
        this.id = Integer.parseInt(split[0]);
        this.Name = split[1];
        this.Link = split[4];
        String gens="";
        for(int i=0;i<19 && split.length>5+i;i++)
        {
            gens+=split[5+i];
        }
        this.Genrestring=gens;
    }

    public String getName(){
        return this.Name;
    }

    public int getId() {
        return id;
    }

    public String getLink() {
        return Link;
    }

    public String getGenrestring() {
        return Genrestring;
    }
}
