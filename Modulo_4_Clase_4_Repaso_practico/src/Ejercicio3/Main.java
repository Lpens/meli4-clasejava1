package Ejercicio3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        ArrayList<Invitado> listaInvitado = new ArrayList<Invitado>();
        ArrayList<Explosivo> listaExplosivo = new ArrayList<Explosivo>();
        for (int i=0; i<1000; i++)
        {
            if(i%2==0)
            {
                listaInvitado.add(new InvitadoMeli());
            }
            else
            {
                listaInvitado.add(new InvitadoStandard());
            }
        }
        for (int i=0; i<1000; i++)
        {
            if(i%2==0)

            {
                listaExplosivo.add(new FuegoArtificial("kaboom"+i));
            }
            else
            {
                ArrayList<Explosivo> listaPaquete = new ArrayList<Explosivo>();
                for (int j = 0; j < 3; j++)
                {
                    listaPaquete.add(new FuegoArtificial("kaboom"+i+"-"+j));
                }
                listaExplosivo.add(new PackFuegoArtificial(listaPaquete));
            }
        }
        EventoMarte nuevoEvento = new EventoMarte(listaInvitado,listaExplosivo);
        System.out.println("y hora el momento mas esperado de la noche!!!");
        nuevoEvento.apagarVelas();

    }
}
