package com.example.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
    private final List<Livro> livros = new ArrayList<>();

    public void addLivro(Livro l) {
        if (l != null) livros.add(l);
    }

    public List<Livro> listar() {
        return Collections.unmodifiableList(livros);
    }
}
