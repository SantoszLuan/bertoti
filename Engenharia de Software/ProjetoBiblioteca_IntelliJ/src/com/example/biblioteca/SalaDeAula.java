package com.example.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalaDeAula {
    private String nome;
    private final List<Aluno> alunos = new ArrayList<>();

    public SalaDeAula() {}
    public SalaDeAula(String nome) { this.nome = nome; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public void adicionarAluno(Aluno a) { if (a != null) alunos.add(a); }
    public List<Aluno> listarAlunos() { return Collections.unmodifiableList(alunos); }

    @Override
    public String toString() {
        return "SalaDeAula{nome='" + nome + "', alunos=" + alunos + "}";
    }
}
