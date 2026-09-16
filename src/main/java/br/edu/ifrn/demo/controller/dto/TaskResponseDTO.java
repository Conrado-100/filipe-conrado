package br.edu.ifrn.demo.controller.dto;

public record TaskResponseDTO(
        Long id,
        String titulo,
        boolean concluida,
        String prioridade
) {}