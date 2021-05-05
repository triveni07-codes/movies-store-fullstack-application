package com.assignment.moviesapi.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieDetails {

  @JsonProperty("title")
  private String title;
  @JsonProperty("comment")
  private String comment;
  @JsonProperty("imageUrl")
  private String imageUrl;
}
