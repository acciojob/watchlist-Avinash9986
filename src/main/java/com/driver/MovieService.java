package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MovieService {

    @Autowired
    MovieRepository movieRepository ;
    public ResponseEntity<String> addMovies(Movie movie) {
        return movieRepository.addMovie(movie) ;
    }

    public ResponseEntity<String> addDirector(Director director) {
        return movieRepository.addDirector(director) ;
    }

    public ResponseEntity<Movie> getMovieByName(String name) {
        return  movieRepository.getMovieByName(name) ;
    }

    public ResponseEntity<Director> getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name) ;
    }

    public ResponseEntity<String> addMovieDirectorPair(String movieName, String directorName) {
        return movieRepository.addMovieDirectorPair(movieName,directorName) ;
    }

    public ResponseEntity<List<String>> getMoviesByDirectorName(String director) {
        return movieRepository.getMoviesByDirectorName(director) ;
    }

    public ResponseEntity<List<String>> findAllMovies() {
        return movieRepository.findAllMovies() ;
    }

    public ResponseEntity<String> deleteDirectorByName(String director) {
        return movieRepository.deleteDirectorByName(director) ;
    }

    public ResponseEntity<String> deleteAllDirectors() {
        return movieRepository.deleteAllDirectors() ;
    }
}
