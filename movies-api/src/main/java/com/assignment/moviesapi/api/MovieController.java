package com.assignment.moviesapi.api;

import com.assignment.moviesapi.database.model.MovieDetails;
import com.assignment.moviesapi.database.model.MovieModel;
import com.assignment.moviesapi.service.MovieService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class MovieController implements MovieApi {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @Override
  public ResponseEntity<MovieModel> addMovie(@Valid @NotNull MovieDetails movieDetails) {
    return new ResponseEntity<>(movieService.add(movieDetails), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<List<MovieModel>> getAllMovies() {
    return new ResponseEntity<>(movieService.getAllMovies(false), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<MovieModel> markMovieAsWatched(@Valid @NotNull String id) {
    return new ResponseEntity<>(movieService.updateMovie(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<MovieModel>> getAllWatchedMovies() {
    return new ResponseEntity<>(movieService.getAllMovies(true), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> removeMovie(@Valid @NotNull String id) {
    movieService.removeMovie(id);
    return new ResponseEntity<>("Movie removed successfully", HttpStatus.NO_CONTENT);
  }

}
