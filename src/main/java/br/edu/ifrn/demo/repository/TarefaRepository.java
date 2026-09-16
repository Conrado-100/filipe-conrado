package br.edu.ifrn.demo.repository;
import br.edu.ifrn.demo.model.Tarefa;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.LinkedHashMap;

@Repository
public class TarefaRepository {
    private final Map<Long, Tarefa> banco = new LinkedHashMap<>();
    private final AtomicLong sequencia = new AtomicLong();
    public Tarefa salvar(String titulo) {
        System.out.println("[REPOSITORY] Salvando tarefa em memória: " +
                titulo);
        Long id = sequencia.incrementAndGet();
        Tarefa tarefa = new Tarefa(id, titulo, false);
        banco.put(id, tarefa);
        return tarefa;
    }
    public List<Tarefa> listarTodas() {
        System.out.println("[REPOSITORY] Buscando todas as tarefas em memória");
        return new ArrayList<>(banco.values());
    }
    public Optional<Tarefa> listarconcluidos(){
        System.out.println("[REPOSITORY] Buscando todas as tarefas concluídas");
        return Optional.ofNullable(banco.get(id));
    }
    public Optional<Tarefa> buscarPorId(Long id) {
        System.out.println("[REPOSITORY] Buscando tarefa por id: " + id);
        return Optional.ofNullable(banco.get(id));
    }

    public List<Tarefa> listarConcluidos(){
        System.out.println("[SERVICE]: Solicitando lista de tarefas concluídas");
        List<Tarefa> tarefas = repository.listarTodas();
        List<Tarefa> tarefasConcluidas = new List<Tarefa>();

        for(tarefa in tarefas){
            if(tarefa.isConcluido()){
                tarefasConcluidas.put(tarefa);
            }
        }
        return tarefasConcluidas;
    }
}
