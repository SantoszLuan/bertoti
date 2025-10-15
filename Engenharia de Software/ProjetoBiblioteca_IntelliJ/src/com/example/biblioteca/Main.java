package com.example.biblioteca;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("== Iniciando demonstração Biblioteca + SQLite ==");

        SalaDeAula sala = new SalaDeAula("Sala 101");
        sala.adicionarAluno(new Aluno("Ted Mosby", "20250001"));
        sala.adicionarAluno(new Aluno("Barney Stinson", "20250002"));
        System.out.println("Alunos na " + sala.getNome() + ": " + sala.listarAlunos());

        Biblioteca bib = new Biblioteca();
        bib.addLivro(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry"));
        bib.addLivro(new Livro("Java: Como Programar", "Deitel"));
        System.out.println("Livros em memória: " + bib.listar());

        try {
            String dbFile = "biblioteca.db";
            Path p = Path.of(dbFile);
            if (!Files.exists(p)) Files.createFile(p);

            String url = "jdbc:sqlite:" + dbFile;
            Database db = new Database(url);
            db.criarTabelaSeNecessario();

            Livro l1 = new Livro("Introdução ao Java", "Autor A");
            int id1 = db.inserirLivro(l1);
            System.out.println("Inserido livro id=" + id1 + ": " + l1.getTitulo());

            Livro l2 = new Livro("Estruturas de Dados", "Autor B");
            int id2 = db.inserirLivro(l2);
            System.out.println("Inserido livro id=" + id2 + ": " + l2.getTitulo());

            List<Livro> todos = db.listarLivros();
            System.out.println("Livros no banco: " + todos);

            List<Livro> busca = db.buscarPorTitulo("Java");
            System.out.println("Busca por 'Java': " + busca);

        } catch (Exception e) {
            System.err.println("Erro na demo SQLite: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("== Fim da demonstração ==");
    }
}
