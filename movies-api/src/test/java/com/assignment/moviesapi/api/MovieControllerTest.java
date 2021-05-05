package com.assignment.moviesapi.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.assignment.moviesapi.database.model.MovieDetails;
import com.assignment.moviesapi.database.model.MovieModel;
import com.assignment.moviesapi.service.MovieService;
import com.assignment.moviesapi.util.FileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MovieController.class)
@Import({FileReader.class, ObjectMapper.class})
public class MovieControllerTest {

  @Autowired
  FileReader fileReader;
  @Autowired
  ObjectMapper objectMapper;
  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private MovieService movieService;

  @Autowired
  private MovieController movieController;

  private HttpHeaders httpHeaders;

  @BeforeEach
  public void setConfig() {
    httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
  }

  @Test
  public void testGetAllMovies_returnsListOfAllMovies() throws Exception {
    var moviesCollection = fileReader.loadInputData("json/movies-details.json", ArrayList.class);
    when(movieService.getAllMovies(anyBoolean())).thenReturn(moviesCollection);

    MvcResult mvcResult = mockMvc.perform(get("/api/movies")
        .headers(httpHeaders)).andExpect(status().isOk()).andReturn();

    String expectedMoviesCollection = mvcResult.getResponse().getContentAsString();
    Assertions.assertEquals(expectedMoviesCollection, objectMapper.writeValueAsString(moviesCollection));
    verify(movieService, times(1)).getAllMovies(anyBoolean());
  }

  @Test
  public void testAddMovie_givenMovieDetails_addsMovieToList() throws Exception {
    MovieDetails movieDetails = new MovieDetails();
    movieDetails.setTitle("someMovie");
    MovieModel movieModel = new MovieModel();
    movieModel.setId(1001L);
    when(movieService.add(any())).thenReturn(movieModel);

    mockMvc.perform(MockMvcRequestBuilders
        .post("/api/movies")
        .content(new ObjectMapper().writeValueAsString(movieDetails))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());

    verify(movieService, times(1)).add(any());
  }

}
