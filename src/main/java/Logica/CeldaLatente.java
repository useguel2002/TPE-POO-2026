package Logica;

public class CeldaLatente extends CeldaMuerta{
    @Override
    public Celda siguienteEstado(int vecVivos) {
        if (vecVivos == 1) return new CeldaViva();
        return this;
    }
}
