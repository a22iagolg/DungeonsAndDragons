package dd.main;

import java.util.Random;

import dd.core.*;

class ControlLucha {
    Random r = new Random();
    Personaje[] ejercito_hombres = new Personaje[3];
    Personaje[] ejercito_troll = new Personaje[r.nextInt(9) + 2];

    ControlLucha() {
        crearEjercitos();
        imprimirIntro();
        lucha();
    }

    void imprimirIntro() {
        System.out.println("Tal día como hoy, en una húmeda y fría mañana de finales de primavera,");
        System.out.println("la partida formada por: [" + "[" + ejercito_hombres[0].getNombre() + "]" + ", ["
                + ejercito_hombres[1].getNombre() + "], " + "[" + ejercito_hombres[2].getNombre() + "]]");
        System.out.println("hallándose en los frondosos bosques del sitio de Deorham, se topó con una");
        System.out.println(
                "patrulla de " + ejercito_troll.length + " de esas sanguinarias e inhumanas criaturas popularmente");
        System.out.println("conocidas como trolls.");
        System.out.println("De la batalla que aconteció, dejo aquí testimonio:");
    }

    void crearEjercitos() {
        // Crear ejercito hombres
        ejercito_hombres[0] = new Rey("Arturo", new AtaqueEspada());
        ejercito_hombres[1] = new Caballero("Lancelot", new AtaqueEspada());
        ejercito_hombres[2] = new Caballero("Percival", new AtaqueArco());


        // Crear ejercito Troll
        for (int i = 0; i < ejercito_troll.length; i++) {
            int tipoArma = r.nextInt(3);
            switch (tipoArma) {
                case 0 -> ejercito_troll[i] = new Troll("Troll " + (i + 1), new AtaqueEspada());
                case 1 -> ejercito_troll[i] = new Troll("Troll " + (i + 1), new AtaqueCuchillo());
                case 2 -> ejercito_troll[i] = new Troll("Troll " + (i + 1), new AtaqueArco());
            }
        }
    }

    void imprimirAtaques(int[] ataques, Personaje pj) {
        for (int ataque : ataques) {
            System.out.println("Ataque con " + pj.getAtaque() + "("
                    + (ataque > 0 ? "-" + ataque + ")" : "falla)"));
        }
    }

    void pelea(Personaje peleon, Personaje enemigo) {
        System.out.println(peleon.toString() + " lucha contra " + enemigo.toString());
        int[] ataques = peleon.ataca(enemigo);
        imprimirAtaques(ataques, peleon);
        if (enemigo.getSalud() <= 0)
            System.out.println(enemigo.getNombre() + " muere!");
    }

    void lucha() {
        // Bucle principal, se ejecuta siempre que haya supervivientes en ambos bandos
        while (haySupervivientes(ejercito_hombres) && haySupervivientes(ejercito_troll)) {
            // Turno humanos
            for (int i = 0; i < ejercito_hombres.length; i++) {
                // Saltamos si el Personaje está muerto
                if (ejercito_hombres[i].getSalud() <= 0)
                    continue;

                // Chequeamos que quedan Trolls en cada turno antes de atacar
                if (haySupervivientes(ejercito_troll)) {
                    Personaje enemigo = elegirEnemigo(ejercito_troll);
                    pelea(ejercito_hombres[i], enemigo);
                } else {
                    break;
                }
            }

            // Turno trolls
            for (int i = 0; i < ejercito_troll.length; i++) {
                // Saltamos si el Troll está muerto
                if (ejercito_troll[i].getSalud() <= 0)
                    continue;
                // Chequeamos que quedan Humanos en cada turno antes de atacar
                if (haySupervivientes(ejercito_hombres)) {
                    Personaje enemigo = elegirEnemigo(ejercito_hombres);
                    pelea(ejercito_troll[i], enemigo);
                } else {
                    break;
                }

            }

        }
        if (haySupervivientes(ejercito_hombres) && !haySupervivientes(ejercito_troll)) {
            String supervivientes = "";
            for (int i = 0; i < ejercito_hombres.length; i++) {
                if (ejercito_hombres[i].getSalud() > 0) {
                    supervivientes += ejercito_hombres[i].toString();
                    if (i != ejercito_hombres.length - 1)
                        if (ejercito_hombres[i + 1].getSalud() > 0)
                            supervivientes += ", ";
                }
            }
            System.out.println("Finalmente, el ejército del Rey Arturo venció!!!");
            System.out.println("Los supervivientes de la batalla fueron: ");
            System.out.println("{" + supervivientes + "}");
        } else {
            System.out.println("El ejercito del Rey Arturo ha sido derrotado...");
        }
    }

    // Metodo para verificar que el array tiene personajes vivos
    boolean haySupervivientes(Personaje[] ejercito) {
        for (Personaje p : ejercito) {
            if (p.getSalud() > 0)
                return true;
        }
        return false;
    }

    // Metodo para elegir enemigo aleatoriamente y que siga vivo!
    Personaje elegirEnemigo(Personaje[] ejercito) {
        int index = r.nextInt(ejercito.length);
        while (ejercito[index].getSalud() <= 0) {
            index = r.nextInt(ejercito.length);
        }
        return ejercito[index];
    }
}

public class DDApp {
    public static void main(String[] args) {
        new ControlLucha();
    }

}