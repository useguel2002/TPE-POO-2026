package Logica;

public class CeldaEnferma extends CeldaViva {
    @Override
    public Celda siguienteEstado(int vecVivos) {
        return new CeldaMuerta();
    }
}
