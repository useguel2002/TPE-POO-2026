package Logica;

public class CeldaViva extends Celda{
    @Override
    public Celda siguienteEstado(int vecVivos){
        //La celda se mantiene viva si la rodean 2 o 3 vecinos vivos. En ualquier otro caso muere.
        if (vecVivos ==2 || vecVivos == 3) return this;
        return new CeldaMuerta();
    };
    public boolean estaViva(){
        return true;
    };
}
