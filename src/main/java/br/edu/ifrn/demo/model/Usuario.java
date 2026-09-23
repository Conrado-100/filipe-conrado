package br.edu.ifrn.demo.model;

import java.time.LocalDate;
public record Usuario() {
        private static Long id;
        private static String email;
        private static String nome;
        private static String cargo;

    public Usuario(Long id, String email, String nome, String cargo ){
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.cargo = cargo;
    }
    public Long getId(){ return id;    }
    public String getNome(){ return nome; }
    public static String getCargo() {    return cargo;  }
    public static String getEmail() {  return email;    }
}
