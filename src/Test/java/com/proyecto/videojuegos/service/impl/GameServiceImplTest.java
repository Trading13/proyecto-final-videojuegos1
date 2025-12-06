package com.proyecto.videojuegos.service.impl;

import com.proyecto.videojuegos.dto.GameRequestDTO;
import com.proyecto.videojuegos.dto.GameResponseDTO;
import com.proyecto.videojuegos.exception.GameNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceImplTest {

    private GameServiceImpl gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameServiceImpl();
    }

    private GameRequestDTO buildRequest() {
        GameRequestDTO dto = new GameRequestDTO();
        dto.setTitle("Minecraft");
        dto.setGenre("Sandbox");
        dto.setPlatform("PC");
        dto.setReleaseDate(LocalDate.of(2011, 11, 18)); // CORRECTO
        dto.setPrice(29.99);
        dto.setDeveloper("Mojang");
        return dto;
    }

    @Test
    void shouldCreateGame() {
        GameResponseDTO response = gameService.createGame(buildRequest());
        assertNotNull(response.getId());
        assertEquals("Minecraft", response.getTitle());
        assertEquals(29.99, response.getPrice());
    }

    @Test
    void shouldGetGameById() {
        GameResponseDTO created = gameService.createGame(buildRequest());
        GameResponseDTO found = gameService.getGameById(created.getId());

        assertEquals(created.getId(), found.getId());
        assertEquals("Sandbox", found.getGenre());
    }

    @Test
    void shouldThrowExceptionWhenGameNotFound() {
        assertThrows(GameNotFoundException.class, () -> gameService.getGameById(999L));
    }
}