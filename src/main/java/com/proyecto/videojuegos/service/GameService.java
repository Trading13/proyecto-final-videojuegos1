package com.proyecto.videojuegos.service;

import com.proyecto.videojuegos.dto.GameRequestDTO;
import com.proyecto.videojuegos.dto.GameResponseDTO;

import java.util.List;

public interface GameService {

    GameResponseDTO createGame(GameRequestDTO dto);

    List<GameResponseDTO> getAllGames();

    GameResponseDTO getGameById(Long id);

    GameResponseDTO updateGame(Long id, GameRequestDTO dto);

    void deleteGame(Long id);
}
