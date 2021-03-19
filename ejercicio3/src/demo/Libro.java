package demo;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    public Libro()
    {}
    public Libro(String tit, String autor, String isbn)
    {
        this.titulo = tit;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return this.getTitulo() + ", " + this.getIsbn() + ", " + this.getAutor();
    }
}
