package com.assignment.moviesapi.api;

import com.assignment.moviesapi.database.model.MovieDetails;
import com.assignment.moviesapi.database.model.MovieModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "movies", tags = "Movie API")
@RequestMapping(value = "/api")
public interface MovieApi {

  @ApiOperation(value = "Adds movie to the collection", nickname = "addMovie",
      notes = "To add new movie to collection:")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "A movie added to the collection"),
      @ApiResponse(code = 400, message = "Invalid input supplied")})
  @PostMapping(value = "/movies",
      produces = {"application/json"})
  ResponseEntity<MovieModel> addMovie(@ApiParam(value = "Movie details to be added") @Valid @NotNull
  @RequestBody MovieDetails movieDetails);

  @ApiOperation(value = "Returns all movies list", nickname = "getAllMovies",
      notes = "To get all the movies in the collection:")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "List of movies retrieved"),
      @ApiResponse(code = 404, message = "Movies not found")})
  @GetMapping(value = "/movies",
      produces = {"application/json"})
  ResponseEntity<List<MovieModel>> getAllMovies();

  @ApiOperation(value = "Mark movie as watched", nickname = "markMovieAsWatched",
      notes = "To mark movie as watched:")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "A movie has been marked as watched"),
      @ApiResponse(code = 400, message = "Invalid input supplied")})
  @PutMapping(value = "/movies/{id}",
      produces = {"application/json"})
  ResponseEntity<MovieModel> markMovieAsWatched(@ApiParam(value = "Movie id to be marked") @Valid @NotNull
  @PathVariable(name = "id", required = true) String id);

  @ApiOperation(value = "Returns all already watched movies list", nickname = "getAllWatchedMovies",
      notes = "To get all the watched movies from the collection:")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "List of watched movies retrieved"),
      @ApiResponse(code = 404, message = "Movies not found")})
  @GetMapping(value = "/movies/watched",
      produces = {"application/json"})
  ResponseEntity<List<MovieModel>> getAllWatchedMovies();

  @ApiOperation(value = "Remove the movie from collection", nickname = "removeMovie",
      notes = "To remove movie:")
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "A movie has been deleted"),
      @ApiResponse(code = 400, message = "Invalid input supplied")})
  @DeleteMapping(value = "/movies/{id}",
      produces = {"application/json"})
  ResponseEntity<String> removeMovie(@ApiParam(value = "Movie id to be removed") @Valid @NotNull
  @PathVariable(name = "id", required = true) String id);

}
