# Java-Movie-Reccomendataion

#Run src/MovieRecomendAPP/index.java

#Problem Statement :
============ 
#Given a user id, recommend 5 movies for that user. You should recommend a movie which the user has the highest probability of liking. You must not recommend a movie the user has already seen. Current data set is for 100K ratings. Final data set would be for 1M ratings. So make sure your solution can scale.

You are given 4 files - 
1) ratings.data -- The full u data set, 100000 ratings by 943 users on 1682 items.
       Each user has rated at least 20 movies. Users and items are
       numbered consecutively from 1. The data is randomly
       ordered. This is a tab separated list of 
     user id | item id | rating | timestamp. 
       The time stamps are unix seconds since 1/1/1970 UTC  
 
2) movies.data Information about movies; this is a tab separated
       list of
       movie id | movie title | release date | video release date |
       IMDb URL | unknown | Action | Adventure | Animation |
       Children's | Comedy | Crime | Documentary | Drama | Fantasy |
       Film-Noir | Horror | Musical | Mystery | Romance | Sci-Fi |
       Thriller | War | Western |
       The last 19 fields are the genres, a 1 indicates the movie
       is of that genre, a 0 indicates it is not; movies can be in
       several genres at once.
       The movie ids are the ones used in the ratings.data data set.
 
3) genre.data A list of the movie genres
 
 
 
4) user.data Demographic information about the users; this is a tab
       separated list of
       user id | age | gender | occupation | zip code
       The user ids are the ones used in the u.data data set.
 
 
 
Warm Up Problems : 
============
== Top Movie By Genre
== Top Movie By Year
== Top Movie By Year & Genre
== Most watched Movie
== Most watched Genre
== Highest rated Genre
== Most Active User
 
