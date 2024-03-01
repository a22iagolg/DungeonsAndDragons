package dd.core;

public class Rey extends Personaje {
    public Rey(String nombre) {
        super(nombre);
        this.salud = 2000;
    }
    public Rey(String nombre, Ataque ataque){
        super(nombre, ataque);
        this.salud = 2000;
    }

    @Override
    public int[] ataca(Personaje enemigo) {
        int[] ataques = new int[3];
        if (ataque != null) {
            for (int i = 0; i < 3; i++) {
                ataques[i] = ataque.lanzaAtaque(enemigo);

            }
        }
        return ataques;
    }

}
