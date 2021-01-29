package MovieRecommApp;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class index {
    public static int MostActiveUser=0;
    static int MostWatchedMovie=0;
    static int WatchCounter;
    public static int MostRatings=0;

    public  static HashMap<Integer,Movie> movieMap =new HashMap<Integer, Movie>();
    //change file location
    public  static String fileloc ="./src/test/";
    public static void getMovie(){
        try (BufferedReader br = new BufferedReader(new FileReader(fileloc+"movie1.data"))) {

            String strCurrentLine;

            while ((strCurrentLine = br.readLine()) != null) {
                String data = strCurrentLine;
                String[] split = data.split("\\|"); //WHY \\| is needed? | is an operator that`s why "\\"
                String gens="";
                for (int i = 0; i < 19 && i+5 <split.length ; i++) {
                    gens+=split[i+5];
                }
                Movie movie=new Movie(Integer.parseInt(split[0]),
                        split[1],split[2],
                        split[3],
                        split[4],
                        gens );
//                System.out.println("Movie Added to Db "+movie.getId()+", Title: "+movie.getName()+", GenreString: "+movie.getGenreStr() +", year: "+ movie.getRdate());
                movieMap.put(movie.getId(),movie);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //rating map :maps ratings count to user;
    public static HashMap<Integer,Integer> ratingMap= new HashMap<Integer, Integer>();
    //maps rating count to movie;

    public static void getRating(){
        try(BufferedReader Br= new BufferedReader(new FileReader(fileloc+"ratings.data"))) {
            String data;
            while ((data =Br.readLine())!=null){
                String[] split =data.split("\\t"); //for space "\\t" or tabs

                Rating rating=new Rating(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[3]));
//                System.out.println(" Ratings Added by: "+ rating.getUid()+" Ratings for: "+rating.getMid()+" Rated "+rating.getRating());

                if(ratingMap.get(rating.getUid())!=null) {
                    int prevcount=ratingMap.get(rating.getUid())+1;
                    if(prevcount>=MostRatings)
                    {
                        MostRatings=prevcount;
                        MostActiveUser= rating.getUid();
                    }
                    ratingMap.put(rating.getUid(), prevcount);
                }
                else
                    ratingMap.put(rating.getUid(),1);

//                movieRating.putIfAbsent(rating.getMid(), new ArrayList<Integer>());
                if(movieMap.get(rating.getMid())!=null)
                {
                    movieMap.get(rating.getMid()).ratings.add(rating.getRating());
                    if(movieMap.get(rating.getMid()).ratings.size()>WatchCounter)
                    {
                        WatchCounter=movieMap.get(rating.getMid()).ratings.size();
                        MostWatchedMovie=rating.getMid();
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static int highestRating=0;
    static int highestRatedMovie=0;

    static void ratingMovies(){
        for (Map.Entry mapElement: movieMap.entrySet()) {
            int key= (int) mapElement.getKey();
            double avgRating=movieMap.get(key).AvgRating();

            if(avgRating> highestRating){
                highestRating= (int) avgRating;
                highestRatedMovie=key;
            }
//            System.out.println(key+" "+avgRating);
        }
    }


    public static void main(String[] args) {

        //Read Files
        getMovie();
        System.out.println("Movie indexed at 89: "+ movieMap.get(89).getName());
        getRating();
        ratingMovies();
        

        //WarmUp Problem : MostActive User
        System.out.println("Most Active User: "+MostActiveUser+" Rated: " +ratingMap.get(MostActiveUser)+ " movies");
        //WarmUp Problem : MostWatched Movie
        System.out.println("Most Watched Movie: "+movieMap.get(MostWatchedMovie).getName()+" watched "+WatchCounter+" times");
        //Highest Rated Movie
        System.out.println("Highest rated movie: "+movieMap.get(highestRatedMovie).getName()+" rated at "+highestRating);

        //Sorting movies by rating

        //Recommend movies
    }
}
