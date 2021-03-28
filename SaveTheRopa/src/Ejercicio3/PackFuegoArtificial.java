package Ejercicio3;

import java.util.ArrayList;

public class PackFuegoArtificial extends Explosivo {
    private ArrayList<Explosivo> ListaDeFuego = new ArrayList<Explosivo>();

    public PackFuegoArtificial(ArrayList<Explosivo> listaDeFuego) {
        ListaDeFuego = listaDeFuego;
    }

    @Override
    public void Reventar() {
        for(Explosivo f:ListaDeFuego)
        {
            f.Reventar();
        }
    }
}
