package Logica;

public class CeldaMuerta extends Celda{
    @Override
    public Celda siguienteEstado(int vecVivos){
        //Si la celda muerta esta rodeada por 3 vecinos vivos, esta revive.
        if (vecVivos == 3) return new CeldaViva();
        return this;
    };
    public boolean estaViva(){
        return false;
    };
}
