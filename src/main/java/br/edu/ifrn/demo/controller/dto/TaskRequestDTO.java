package br.edu.ifrn.demo.controller.dto;

import java.time.LocalDate;
public record TaskRequestDTO(
        String titulo,
        String descricao,
        LocalDate prazo
) {}
