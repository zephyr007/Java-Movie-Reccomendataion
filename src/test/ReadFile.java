package test;

import MovieRecommApp.Movie;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {

    public static ArrayList<MovieModel> movies= new ArrayList<>();
    public static void readmovies() {
        try {
            File myObj = new File("./src/test/movie1.data");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                //pushing it into objects
                MovieModel dataToAdd= new MovieModel(data);

                //pushing object into DB
                movies.add(dataToAdd);
//                System.out.println("Id: "+dataToAdd.getId() +" Name: "+ dataToAdd.getName() +" Link :"+ dataToAdd.getLink()+" GenreString: "+ dataToAdd.getGenrestring());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readUser(){
        try {
            File myObj = new File("./src/test/user.data");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()){
                String data =myReader.nextLine();
                System.out.println(data);
            }

        }catch (FileNotFoundException e){
            System.out.println("File not Found");
            e.printStackTrace();
        }
    }

    public void getRatings(){
        try {
            File myObj = new File("./src/test/ratings.data");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()){
                String data =myReader.nextLine();

                System.out.println(data);
            }

        }catch (FileNotFoundException e){
            System.out.println("File not Found");
            e.printStackTrace();
        }
    }
}