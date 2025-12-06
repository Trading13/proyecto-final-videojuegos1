package com.proyecto.videojuegos.service.impl;

import com.proyecto.videojuegos.dto.GameRequestDTO;
import com.proyecto.videojuegos.dto.GameResponseDTO;
import com.proyecto.videojuegos.exception.GameNotFoundException;
import com.proyecto.videojuegos.model.Game;
import com.proyecto.videojuegos.service.GameService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final Map<Long, Game> games = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public GameResponseDTO createGame(GameRequestDTO dto) {
        Long id = idCounter.getAndIncrement();

        Game game = new Game(
                id,
                dto.getTitle(),
                dto.getGenre(),
                dto.getPlatform(),
                dto.getReleaseDate(),
                dto.getPrice(),
                dto.getDeveloper()
        );

        games.put(id, game);
        return convertToDTO(game);
    }

    @Override
    public List<GameResponseDTO> getAllGames() {
        return games.values()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GameResponseDTO getGameById(Long id) {
        Game game = games.get(id);

        if (game == null) {
            throw new GameNotFoundException("Game with ID " + id + " not found");
        }

        return convertToDTO(game);
    }

    @Override
    public GameResponseDTO updateGame(Long id, GameRequestDTO dto) {
        Game game = games.get(id);

        if (game == null) {
            throw new GameNotFoundException("Game with ID " + id + " not found");
        }

        game.setTitle(dto.getTitle());
        game.setGenre(dto.getGenre());
        game.setPlatform(dto.getPlatform());
        game.setReleaseDate(dto.getReleaseDate());
        game.setPrice(dto.getPrice());
        game.setDeveloper(dto.getDeveloper());

        return convertToDTO(game);
    }

    @Override
    public void deleteGame(Long id) {
        if (!games.containsKey(id)) {
            throw new GameNotFoundException("Game with ID " + id + " not found");
        }
        games.remove(id);
    }

    private GameResponseDTO convertToDTO(Game game) {
        GameResponseDTO dto = new GameResponseDTO();
        dto.setId(game.getId());
        dto.setTitle(game.getTitle());
        dto.setGenre(game.getGenre());
        dto.setPlatform(game.getPlatform());
        dto.setReleaseDate(game.getReleaseDate());
        dto.setPrice(game.getPrice());
        dto.setDeveloper(game.getDeveloper());
        return dto;
    }
}
