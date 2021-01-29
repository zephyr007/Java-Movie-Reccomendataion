package MovieRecommApp;

import javafx.util.Pair;

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
//    PriorityQueue<Pair<Integer,Movie>> pq;


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

                //Getting year out of
                String[] split2=split[2].split("-");
                int ryear=0;
                if(split2.length>=2)
                    ryear = Integer.parseInt(split2[2]);
//               System.out.println("year of release of "+split[1]+" "+ryear);
                Movie movie=new Movie(Integer.parseInt(split[0]),
                        split[1],ryear,
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
    static HashMap<Integer,ArrayList<Movie>> movieBYYear= new HashMap<>();

    static void ratingMovies(){
        for (Map.Entry mapElement: movieMap.entrySet()) {
            int key= (int) mapElement.getKey();
            Movie movie= movieMap.get(key);
            int ryear=movie.getRdate();
            double avgRating=movieMap.get(key).AvgRating();
            int ratingtoput= (int) avgRating;

            if(avgRating> highestRating){
                highestRating= (int) avgRating;
                highestRatedMovie=key;
            }
//            System.out.println(key+" "+avgRating);
            if(movieBYYear.get(ryear)==null){
//                    PriorityQueue<Pair<Integer,Movie>> pq=new PriorityQueue<>();
//                Pair<Integer,Movie> moviePair=new Pair<Integer,Movie>(ratingtoput,movie);
//                PriorityQueue<Pair<Integer,Movie>> pq=new PriorityQueue<Pair<Integer,Movie>>(Collections.singleton(moviePair));
                ArrayList<Movie> arrayList=new ArrayList<Movie>(Collections.singleton(movie));
                movieBYYear.put(ryear,arrayList);
            }
            else
            {
                //if element already exists adding a pair;
//                Pair<Integer,Movie> pair=new Pair<Integer,Movie>(ratingtoput,movie);
////                PriorityQueue<Pair<Integer,Movie>> pq= new PriorityQueue<Pair<Integer,Movie>>(Collections.singleton(pair));
//                PriorityQueue<Pair<Integer,Movie>> pq= movieBYYear.get(ryear); //getting element becoz no pointers
                //now to add
//                pq.add(pair);
                ArrayList<Movie> arrayList=movieBYYear.get(ryear);
                arrayList.add(movie);
                movieBYYear.put(ryear,arrayList);
            }
        }
    }


    static void sortMoviesByYear(){
        for (
                Map.Entry mapEl: movieBYYear.entrySet()
        ) {
            int key = (int) mapEl.getKey();
            ArrayList<Movie> arrayList=movieBYYear.get(key);
            //Lamda comparison
            arrayList.sort((Movie a,Movie b)->b.rating-a.rating);
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
        //Highest Rated Movie

        //Sorting movies by rating
//        System.out.println("Size of MovieByYear "+movieBYYear.size());
        sortMoviesByYear();
        for (
                Map.Entry mapEl: movieBYYear.entrySet()
             ) {
            int key = (int) mapEl.getKey();
            Movie top= movieBYYear.get(key).get(movieBYYear.get(key).size()-1);
            System.out.println("Movie of the year "+key+" : "+top.getName());
        }

        //Recommend movies

    }
}
