package br.edu.ifrn.demo.controller;
import br.edu.ifrn.demo.controller.dto.TarefaRequestDTO;
import br.edu.ifrn.demo.model.Tarefa;
import br.edu.ifrn.demo.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService service;
    public TarefaController(TarefaService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Map<String, String>
                                                corpo) {
        System.out.println("[CONTROLLER] Requisição recebida: POST/tarefas");
        TarefaRequestDTO tarefaDTO = new TarefaRequestDTO((corpo.get("titulo")))
        TarefaResponseDTO  tarefaResponseDTO = service.criar(tarefaDTO));
        Tarefa tarefa=new Tarefa(tarefaResponseDTO.id(), tarefaResponseDTO.titulo(), tarefaResponseDTO.concluido());
        return ResponseEntity.ok(tarefa);
    }
    @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {
        System.out.println("[CONTROLLER] Requisição recebida: GET/tarefas");
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping("/concluidos")
    public ResponseEntity <List<Tarefa>> listarConcluidos(){
        System.out.println("[Controller] Requisição recebida:  GET /tarefas/concluidas");
        return ResponseEntity.ok(service.listarConcluidos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable Long id) {
        System.out.println("[CONTROLLER] Requisição recebida: GET/tarefas/" + id);
        return ResponseEntity.ok(service.buscaPorId(id));
    }
}