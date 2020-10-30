package movieRating;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Mreview  implements Comparable<Mreview>{

    private  String movieTitle;
    private ArrayList<Integer> movieRatings;
    public static DecimalFormat df = new DecimalFormat("0.00");

    Mreview(){
        this.movieTitle ="";
        this.movieRatings=new ArrayList<>();
    }

    Mreview(String ttl){
        this.movieTitle=ttl;
        this.movieRatings=new ArrayList<>();
    }

    Mreview(String ttl, int firstRating){
        this.movieTitle =ttl;
        this.movieRatings=new ArrayList<>(1);
        movieRatings.add(firstRating);
    }

    public void addRating(int r){
       movieRatings.add(r);
    }

    public double aveRatings(){
        int sum=0;
        for(int i=0;i<movieRatings.size();i++){
            sum=sum+movieRatings.get(i);
        }

        double averagRating=(double)sum/movieRatings.size();

        return  averagRating;
    }


    public  String getMovieTitle() {
        return movieTitle;
    }

    public int numRatings(){

        return movieRatings.size();
    }
    public boolean equals(Object obj){
        if(movieTitle.equals(obj)){

            return true;
        }

        return false;
    }

    @Override
    public int compareTo(Mreview o) {
        return this.movieTitle.compareTo(o.movieTitle);
    }


    @Override
    public String toString() {

        if(this.movieTitle==""){
            return movieTitle+"Average "+df.format(aveRatings())+" out of "+numRatings()+" ratings\n";
        }

        return  movieTitle+", average "+df.format(aveRatings())+" out of "+numRatings()+" ratings\n";
    }


    public static void main(String args[]){

        Mreview movie1=new Mreview();
        movie1.addRating(1);
        movie1.addRating(4);
        movie1.addRating(5);
        System.out.print(movie1.toString());

        Mreview movie2=new Mreview("Bluff");
        movie2.addRating(2);
        movie2.addRating(2);
        movie2.addRating(3);
        System.out.print(movie2.toString());

        Mreview movie3=new Mreview("Social Dilemma", 2);
        movie3.addRating(2);
        movie3.addRating(2);
        movie3.addRating(2);
        System.out.print(movie3.toString());

    }
}
