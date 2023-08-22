package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MovieController {

    @Autowired
    MovieService movieService ;


    //1
    @PostMapping("POST/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String str = movieService.addMovies(movie) ;
        if(str == null){
            return new ResponseEntity("Movie not added", HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(str,HttpStatus.FOUND) ;
    }


    //2
    @PostMapping("POST/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        String str = movieService.addDirector(director) ;
        if (str == null){
            return new ResponseEntity("Director noy added",HttpStatus.NOT_FOUND) ;
        }
        return  new ResponseEntity(str,HttpStatus.FOUND) ;
    }


    //3
    @PutMapping("PUT/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        String str = movieService.addMovieDirectorPair(movieName,directorName) ;
        if(str == null){
            return new ResponseEntity("Direcotr and movei pair not added",HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(str,HttpStatus.FOUND) ;
    }


    //4
    @GetMapping("GET/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie movie = movieService.getMovieByName(name) ;
        if(movie == null){
            return new ResponseEntity("Movie not found",HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity<>(movie,HttpStatus.FOUND) ;
    }


    //5
    @GetMapping("GET/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        Director director = movieService.getDirectorByName(name) ;
        if (director == null){
            return new ResponseEntity("Director not found",HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(director,HttpStatus.FOUND) ;
    }

    //6
    @GetMapping("GET/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        List<String> list = movieService.getMoviesByDirectorName(director) ;
        if(list == null){
            return new ResponseEntity("list not found",HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(list,HttpStatus.FOUND) ;
    }

    //7
    @GetMapping("GET/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> list = movieService.findAllMovies() ;
        if (list == null){
            return new ResponseEntity("movies not found",HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(list,HttpStatus.FOUND) ;
    }

    //8
    @DeleteMapping("DELETE/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("director") String director){
        String str = movieService.deleteDirectorByName(director) ;
        if (str == null){
            return new ResponseEntity("Director not deleted",HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(str,HttpStatus.FOUND) ;
    }

    //9
    @DeleteMapping("DELEte/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        String str = movieService.deleteAllDirectors() ;
        if (str == null){
            return new ResponseEntity("all directors not deleted",HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(str,HttpStatus.FOUND) ;
    }







}
