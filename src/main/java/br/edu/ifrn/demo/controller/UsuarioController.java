package br.edu.ifrn.demo.controller;

import br.edu.ifrn.demo.dto.UsuarioResponseDTO;
import br.edu.ifrn.demo.model.Usuario;
import br.edu.ifrn.demo.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody UsuarioRequestDTO corpo) {
        UsuarioResponseDTO criada=service.criar(corpo);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        System.out.println("[CONTROLLER] Requisição recebida: GET /usarios/" + id);
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
