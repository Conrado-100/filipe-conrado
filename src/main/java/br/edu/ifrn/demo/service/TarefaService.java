package br.edu.ifrn.demo.service;

import br.edu.ifrn.demo.controller.dto.TarefaRequestDTO;
import br.edu.ifrn.demo.controller.dto.TarefaResponseDTO;
import br.edu.ifrn.demo.model.Tarefa;
import br.edu.ifrn.demo.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository){
        this.repository = repository;
    }

    public TarefaResponseDTO criar(TarefaRequestDTO tarefaDTO ){
        String titulo = tarefaDTO.titulo();
        System.out.println("[SERVICE] Validando regra de negócio para:" + titulo);

        if (titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("O título da tarefa não pode ser vazio.");
        }
        return repository.salvar(titulo.trim());
        return new TarefaService(salva.getId(),salva.getTitulo(),salva.isConcluida(), "Alta")
    }

    public List<Tarefa> listar(){
        System.out.println("[SERVICE] Solicitando lista d tarefa ao repository");
        return repository.listarTodas();
    }
    public Tarefa buscaPorId(Long id){
        System.out.println("[SERVICE] Processando busca por id:" + id);
        return repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada: " + id));
    }

    public List<Tarefa> listarConcluidos() {
        System.out.println("[SERVICE] Processando todas as Tarefas concluídas")
        List<Tarefa> tarefas = listar();
        List<Tarefa> tarefasConcluidas =new ArrayList<>();

        for(Tarefa tarefa: tarefas){
            if(tarefa.isConcluida()){
                tarefasConcluidas.add(tarefa);
            }
        }
        return tarefasConcluidas;
    }
}
