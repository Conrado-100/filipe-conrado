package br.edu.ifrn.demo.service;

import br.edu.ifrn.demo.dto.UsuarioResponseDTO;
import br.edu.ifrn.demo.model.Usuario;
import br.edu.ifrn.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        String titulo=dto.nome();
        Usuario usuario = new Usuario(sequencia.incrementAndGet(),dto.nome(),dto.email(),dto.cargo());
        System.out.println("[SERVICE] Validando regra de negócio para: " +
                nome);
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do usuario não pode ser vazio.");
        }
        Usuario salva= repository.salvar(usuario);
        return toResponseDTO(salva);
    }

    private UsuarioResponseDTO toResponseDTO(Usuario salva) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCargo(),
                usuario.getEmail
        );
    }

    public Usuario buscarPorId(Long id) {
        System.out.println("[SERVICE] Processando busca por id: " + id);
        return repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado: " + id));
    }
}
