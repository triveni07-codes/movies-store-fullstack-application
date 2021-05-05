package com.assignment.moviesapi.service;

import com.assignment.moviesapi.database.model.MovieDetails;
import com.assignment.moviesapi.database.model.MovieModel;
import com.assignment.moviesapi.database.repository.MovieRepository;
import com.assignment.moviesapi.exception.MoviesDataException;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieService {

  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public MovieModel add(MovieDetails movie) {
    log.info("Adding movie to collection {}", movie.getTitle());
    MovieModel movieModel = new MovieModel();
    movieModel.setTitle(movie.getTitle());
    movieModel.setComment(movie.getComment());
    movieModel.setImageUrl(movie.getImageUrl());
    return movieRepository.save(movieModel);
  }

  public List<MovieModel> getAllMovies(boolean watched) {
    return watched ? movieRepository.findAllByWatched(true) : movieRepository.findAll();
  }

  public MovieModel updateMovie(String id) {
    log.info("Marking movie as watched for id {}", id);
    MovieModel movieModel = getMovieById(id);
    movieModel.setWatched(true);
    log.info("Marked movie as watched for id {}", id);
    return movieRepository.save(movieModel);
  }

  public MovieModel getMovieById(String id) {
    Optional<MovieModel> movie = movieRepository.findById(Long.parseLong(id));
    if (movie.isEmpty()) {
      throw new MoviesDataException("Movie does not exist in the collection to update", HttpStatus.NOT_FOUND);
    }
    return movie.get();
  }

  public void removeMovie(String id) {
    movieRepository.deleteById(Long.parseLong(id));
  }

}
