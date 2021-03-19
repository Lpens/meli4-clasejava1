package demo;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private String owner;
    private String currentOwner;
    public boolean estaEnPrestamo;
    public Libro()
    {}
    public Libro(String tit, String autor, String isbn, String owner)
    {
        this.setTitulo(tit);
        this.setAutor(autor);
        this.setIsbn(isbn);
        this.setOwner(owner);
        this.setCurrentOwner(owner);
    }

    public void setCurrentOwner(String currentOwner) {
        this.currentOwner = currentOwner;
    }

    public void setEstaEnPrestamo(boolean estaEnPrestamo) {
        this.estaEnPrestamo = estaEnPrestamo;
    }

    public String getCurrentOwner() {
        return currentOwner;
    }

    public String getOwner() {
        return owner;
    }

    public boolean getEstaEnPrestamo()
    {
        return currentOwner != owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public void prestamo(String NewOwner)
    {
        this.setCurrentOwner(NewOwner);
    }

    public void Devolucion()
    {
        currentOwner = owner;
    }
}
