package br.edu.ifrn.demo.repository;


import br.edu.ifrn.demo.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UsuarioRepository {
    private final Map<Long, Usuario> banco = new LinkedHashMap<>();

    public Optional<Usuario> buscarPorId(Long id) {
        System.out.println("[REPOSITORY] Buscando usuario por id: " + id);
        return Optional.ofNullable(banco.get(id));
    }
}
