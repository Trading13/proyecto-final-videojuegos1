package com.proyecto.videojuegos.controller;

import com.proyecto.videojuegos.dto.GameRequestDTO;
import com.proyecto.videojuegos.dto.GameResponseDTO;
import com.proyecto.videojuegos.service.GameService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //recibe peticiones HTTP y devuelve respuestas JSON
@RequestMapping("/api/games") //ruta base API
@CrossOrigin("") //permite que un fronted llame a endpoints
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping //crear videojuego
    public ResponseEntity<GameResponseDTO> createGame(@Valid @RequestBody GameRequestDTO dto) {
        return ResponseEntity.ok(gameService.createGame(dto));
    }

    @GetMapping //listar todos
    public ResponseEntity<List<GameResponseDTO>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping("/{id}") //buscar por ID
    public ResponseEntity<GameResponseDTO> getGameById(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.getGameById(id));
    }

    @PutMapping("/{id}") //actualizar
    public ResponseEntity<GameResponseDTO> updateGame(
            @PathVariable Long id,
            @Valid @RequestBody GameRequestDTO dto
    ) {
        return ResponseEntity.ok(gameService.updateGame(id, dto));
    }

    @DeleteMapping("/{id}") //eliminar
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}