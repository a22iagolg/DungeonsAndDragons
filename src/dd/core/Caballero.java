package dd.core;

public class Caballero extends Personaje {
    public Caballero(String nombre) {
        super(nombre);
        this.salud = 1500;
    }


    @Override
    public int[] ataca(Personaje enemigo) {
        int[] ataques = new int[2];

        if (ataque != null) {
            for (int i = 0; i < 2; i++) {
                ataques[i] = ataque.lanzaAtaque(enemigo);
            }
        }
        return ataques;
    }

}