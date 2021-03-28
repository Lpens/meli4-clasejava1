package Ejercicio3;

public class FuegoArtificial extends Explosivo {
    public String sonido;

    public FuegoArtificial(String sonido) {
        this.sonido = sonido;
    }

    @Override
    public void Reventar() {
        System.out.println(sonido);
    }
}
