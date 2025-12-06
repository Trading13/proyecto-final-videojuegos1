package com.proyecto.videojuegos.model;

import java.time.LocalDate;

public class Game {

    private Long id;
    private String title;
    private String genre;
    private String platform;
    private LocalDate releaseDate;
    private Double price;
    private String developer;

    public Game() {}

    public Game(Long id, String title, String genre, String platform,
                LocalDate releaseDate, Double price, String developer) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.releaseDate = releaseDate;
        this.price = price;
        this.developer = developer;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
