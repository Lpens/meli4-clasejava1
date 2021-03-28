package Ejercicio3;

import java.util.ArrayList;

public class EventoMarte {
    private ArrayList<Invitado> listaInvitados = new ArrayList<Invitado>();
    private ArrayList<Explosivo> listaFuego = new ArrayList<Explosivo>();

    public EventoMarte(ArrayList<Invitado> listaInvitados, ArrayList<Explosivo> listaFuego) {
        this.listaInvitados = listaInvitados;
        this.listaFuego = listaFuego;
    }

    public void apagarVelas()
    {
        for(Explosivo e: listaFuego)
        {
            e.Reventar();
        }
        for(Invitado i: listaInvitados)
        {
            i.recibirTorta();
        }
    }
}
