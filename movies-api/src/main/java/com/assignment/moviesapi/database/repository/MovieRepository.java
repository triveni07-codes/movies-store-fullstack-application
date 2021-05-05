package com.assignment.moviesapi.database.repository;

import com.assignment.moviesapi.database.model.MovieModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {

  List<MovieModel> findAllByWatched(Boolean watched);

}

