package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MovieController {

    @Autowired
    MovieService movieService ;


    //1
    @PostMapping("POST/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        return movieService.addMovies(movie) ;
    }


    //2
    @PostMapping("POST/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        return movieService.addDirector(director) ;
    }


    //3
    @PutMapping("PUT/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        return movieService.addMovieDirectorPair(movieName,directorName) ;
    }


    //4
    @GetMapping("GET/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        return movieService.getMovieByName(name) ;
    }


    //5
    @GetMapping("GET/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        return movieService.getDirectorByName(name) ;
    }

    //6
    @GetMapping("GET/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        return movieService.getMoviesByDirectorName(director) ;
    }

    //7
    @GetMapping("GET/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return movieService.findAllMovies() ;
    }

    //8
    @DeleteMapping("DELETE/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director") String director){
        return movieService.deleteDirectorByName(director) ;
    }

    //9
    @DeleteMapping("DELEte/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return movieService.deleteAllDirectors() ;
    }







}
