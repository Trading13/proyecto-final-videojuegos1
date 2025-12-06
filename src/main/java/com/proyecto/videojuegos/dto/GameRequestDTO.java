package com.proyecto.videojuegos.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class GameRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotBlank(message = "Platform is required")
    private String platform;

    @NotNull(message = "Release date is required")
    private LocalDate releaseDate;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @NotBlank(message = "Developer is required")
    private String developer;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDeveloper() { return developer; }
    public void setDeveloper(String developer) { this.developer = developer; }
}