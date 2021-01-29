package MovieRecommApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class index {
//    public HashMap<Integer,Movie> movieMap =new HashMap<Integer, Movie>();
    public static void getMovie(){
        try {
            File myObj = new File("./src/test/movie1.data");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()){
                String data =myReader.nextLine();

                String[] split = data.split("\\|"); //WHY \\| is needed? | is an operator thats why "\\"
                String gens="";
                for (int i = 0; i < 19 && i+5 <split.length ; i++) {
                    gens+=split[i+5];
                }
                Movie movie=new Movie(Integer.parseInt(split[0]),
                        split[1],
                        1,
                        2,
                        split[4],
                        gens );
                System.out.println("Movie Added to Db "+movie.getId()+", Title: "+movie.getName()+", GenreString: "+movie.getGenreStr());
//                System.out.println(data);
            }

        }catch (FileNotFoundException e){
            System.out.println("File not Found");
            e.printStackTrace();
        }
    }

    public void getRating(){

    }



    public static void main(String[] args) {
        //Read Files
        getMovie();

        //Sorting movies by rating

        //Recommend movies
    }
}
