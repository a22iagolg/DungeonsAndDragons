package dd.core;

public abstract class Personaje {
    protected String nombre;
    protected Ataque ataque;
    protected int salud;

    public void setSalud(int salud) {
        this.salud = salud;
    }

    Personaje(String nombre) {
        this.nombre = nombre;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public int getSalud() {
        return salud;
    }

    public String getNombre() {
        return nombre;
    }

    abstract public int[] ataca(Personaje enemigo);

    @Override
    public String toString() {
        return "[" + nombre + ": " + salud + "]";
    }
}
