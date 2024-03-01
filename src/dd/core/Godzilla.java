package dd.core;

public class Godzilla extends Personaje {
    public Godzilla(String nombre) {
        super(nombre);
        this.salud = 4000;
        this.setAtaque(new AtaqueLaser());
    }



    public int[] ataca(Personaje enemigo) {
        int[] ataques = new int[1];
        if (this.ataque != null) {
            ataques[0] = ataque.lanzaAtaque(enemigo);
        }
        return ataques;
    }
}
