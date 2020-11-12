package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Usuario {
    
    private int id;
    
    private String cpf;
    
    private String email;
    
    private String nome;
    
    private int papel;
    
    private String senha;

    private char cadastroAprovado;
    
    public Usuario(String cpf, String email, String nome, int papel, String senha, char cadastroAprovado) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.papel = papel;
        this.senha = senha;
        this.cadastroAprovado = cadastroAprovado;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPapel() {
        return papel;
    }

    public void setPapel(int papel) {
        this.papel = papel;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public char getCadastroAprovado() {
        return cadastroAprovado;
    }

    public void setCadastroAprovado(char cadastroAprovado) {
        this.cadastroAprovado = cadastroAprovado;
    }
    
    
}
