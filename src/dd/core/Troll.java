package dd.core;

public class Troll extends Personaje {
    public Troll(String nombre) {
        super(nombre);
        this.salud = 1000;
    }

    public Troll(String nombre, Ataque ataque) {
        super(nombre, ataque);
        this.salud = 1000;
    }

    public int[] ataca(Personaje enemigo) {
        int[] ataques = new int[1];
        if (this.ataque != null) {
            ataques[0] = ataque.lanzaAtaque(enemigo);
        }
        return ataques;
    }
}
