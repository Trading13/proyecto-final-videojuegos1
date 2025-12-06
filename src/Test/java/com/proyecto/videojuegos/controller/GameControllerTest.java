package com.proyecto.videojuegos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.videojuegos.dto.GameRequestDTO;
import com.proyecto.videojuegos.dto.GameResponseDTO;
import com.proyecto.videojuegos.exception.GameNotFoundException;
import com.proyecto.videojuegos.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GameController.class)
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnEmptyList() throws Exception {
        when(gameService.getAllGames()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/games"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void shouldReturnGameById() throws Exception {
        GameResponseDTO dto = new GameResponseDTO();
        dto.setId(1L);
        dto.setTitle("FIFA 23");
        dto.setGenre("Sports");
        dto.setPrice(59.99);

        when(gameService.getGameById(1L)).thenReturn(dto);

        mockMvc.perform(get("/api/games/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("FIFA 23"));
    }

    @Test
    void shouldReturn404WhenGameNotFound() throws Exception {
        when(gameService.getGameById(99L)).thenThrow(new GameNotFoundException("Not found"));

        mockMvc.perform(get("/api/games/99"))
                .andExpect(status().isNotFound());
    }
}