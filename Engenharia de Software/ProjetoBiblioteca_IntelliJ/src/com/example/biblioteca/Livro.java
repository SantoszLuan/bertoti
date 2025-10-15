package com.example.biblioteca;

public class Livro {
    private Integer id;
    private String titulo;
    private String autor;

    public Livro() {}
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    public Livro(Integer id, String titulo, String autor) {
        this.id = id; this.titulo = titulo; this.autor = autor;
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    @Override
    public String toString() {
        return "Livro{id=" + id + ", titulo='" + titulo + "', autor='" + autor + "'}";
    }
}
