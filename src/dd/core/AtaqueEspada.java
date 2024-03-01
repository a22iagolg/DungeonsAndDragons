package dd.core;

import java.util.Random;

public class AtaqueEspada implements Ataque {
    Random r = new Random();
    int ataque = 100;

    public int lanzaAtaque(Personaje enemigo) {
        int acierta = r.nextInt(2);
        double factor = r.nextDouble();
        int valor = (int) (acierta * factor * ataque);
        enemigo.setSalud(enemigo.salud - valor);

        return valor;
    }

    @Override
    public String toString() {
        return "Espada";
    }
}