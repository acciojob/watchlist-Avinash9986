package com.driver;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepository {

    Map<String,Movie> MovieMap = new HashMap<>() ;

    Map<String,Director> DirectorMap = new HashMap<>() ;


    Map<String,String> DMPair = new HashMap<>() ;
    public ResponseEntity<String> addMovie(Movie movie) {
        MovieMap.put(movie.name,movie) ;

        return ResponseEntity.ok("success") ;
    }

    public ResponseEntity<String> addDirector(Director director) {
        DirectorMap.put(director.name,director) ;
        return ResponseEntity.ok("success") ;
    }


    public ResponseEntity<Movie> getMovieByName(String name) {
        return ResponseEntity.ok(MovieMap.get(name)) ;
    }

    public ResponseEntity<Director> getDirectorByName(String name) {
        return ResponseEntity.ok(DirectorMap.get(name)) ;
    }

    public ResponseEntity<String> addMovieDirectorPair(String movieName, String directorName) {
        if(MovieMap.containsKey(movieName) && DirectorMap.containsKey(directorName)){
            DMPair.put(directorName,movieName) ;
        }
        return ResponseEntity.ok("success") ;
    }

    public ResponseEntity<List<String>> getMoviesByDirectorName(String director) {
        List<String> ans = new ArrayList<>() ;
        for(String dir: DMPair.keySet()){
            if(dir == director){
                ans.add(DMPair.get(dir)) ;
            }
        }
        return ResponseEntity.ok(ans) ;
    }

    public ResponseEntity<List<String>> findAllMovies() {
        List<String> ans = new ArrayList<>() ;
        for(String mov : MovieMap.keySet()){
            ans.add(mov) ;
        }
        return ResponseEntity.ok(ans) ;
    }

    public ResponseEntity<String> deleteDirectorByName(String director) {
        for (String dir : DirectorMap.keySet()){
            if(dir == director){
                DirectorMap.remove(dir) ;
            }
        }
        for (String dir : DMPair.keySet()){
            if(dir == director){
                DMPair.remove(dir) ;
            }
        }
        return ResponseEntity.ok("success") ;
    }

    public ResponseEntity<String> deleteAllDirectors() {
        for (String dir : DirectorMap.keySet()){
            if(DMPair.containsKey(dir)){
                DMPair.remove(dir) ;
            }
            DirectorMap.remove(dir) ;
        }
        for (String dir : DMPair.keySet()){
            if(DirectorMap.containsKey(dir)){
                DirectorMap.remove(dir) ;
            }
            DMPair.remove(dir) ;

        }
        return ResponseEntity.ok("success") ;
    }
}
