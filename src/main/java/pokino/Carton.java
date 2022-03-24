package pokino;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Carton {
    private Carta[][] carton = new Carta[5][5];

    public Carton() {
        //temporar
        carton= new Carta[][]{
                {new Carta(Simbolo.MARCADA, 0), new Carta(Simbolo.SOTA, 1), new Carta(Simbolo.COPAS, 2), new Carta(Simbolo.SOTA, 1), new Carta(Simbolo.OROS, 1)},
                {new Carta(Simbolo.MARCADA, 0), new Carta(Simbolo.SOTA, 2), new Carta(Simbolo.COPAS, 3), new Carta(Simbolo.SOTA, 2), new Carta(Simbolo.OROS, 2)},
                {new Carta(Simbolo.MARCADA, 0), new Carta(Simbolo.SOTA, 3), new Carta(Simbolo.COPAS, 1), new Carta(Simbolo.SOTA, 3), new Carta(Simbolo.OROS, 3)},
                {new Carta(Simbolo.MARCADA,0),new Carta(Simbolo.SOTA,4),new Carta(Simbolo.COPAS,4),new Carta(Simbolo.SOTA,4),new Carta(Simbolo.OROS,4)},
                {new Carta(Simbolo.MARCADA,0),new Carta(Simbolo.SOTA,5),new Carta(Simbolo.COPAS,5),new Carta(Simbolo.SOTA,5),new Carta(Simbolo.OROS,5)}
        };
    }

    public void imprimirCarton() {
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                System.out.print(carton[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public Carta[][] getCarton() {
        return carton;
    }

    //metodo para marcar la carta
    public Carta marcarCarta(int fila,int columna){
       return carton[fila][columna]=new Carta(Simbolo.MARCADA,0);
    }

    //method looking if a cart exist in a carton or not
    public boolean isCartaExist(Carta carta){
        boolean exist=false;
        for (int i = 0; i <carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if(carton[i][j].equals(carta)){
                    carton[i][j]=marcarCarta(i,j);
                    return true;
                }
            }
        }
        return false;
    }


    //recorrer vertical carton and check if any columna have marked cards
   public boolean coincidenciaVertical() {
        Carta cartaRecojada;
        boolean coincidencia=true;

        for (int j = 0; j < carton.length; j++) {
            //Cogemos la carta de la columna
            cartaRecojada = carton[0][j];
            for (int i = 1; i < carton[0].length; i++) {
                //sino coincide ya no hay premio en esta columna
                if (cartaRecojada != carton[i][j]) {
                    coincidencia = false;
                }
            }
        }
        return coincidencia;
    }


    public boolean coincidenciaDiagonal() {
        Carta cartaRecojada;
        boolean coincidencia = true;

        //Diagonal principal
        cartaRecojada = carton[0][0];
        for (int i = 1; i < carton.length; i++) {
            if (cartaRecojada != carton[i][i]) {
                coincidencia = false;
            }
        }
        return coincidencia;
    }

    public boolean coincidenciaDiagonalInversa(){
        //Diagonal inversa
        boolean coincidencia=true;
        Carta cartaRecojada = carton[0][2];
            for (int i = 1, j = 1; i < carton.length; i++, j--) {
                if (cartaRecojada != carton[i][j]) {
                    coincidencia = false;
                }
            }
            return coincidencia;
    }

    public boolean coincidenciaLinea() {

        Carta cartaRecojada;
        boolean coincidencia;
        //Reiniciamos la coincidencia
        coincidencia = true;

        for (int i = 0; i < carton.length; i++) {
            //Cogemos la carta de la fila
            cartaRecojada = carton[i][0];
                for (int j = 1; j < carton[0].length; j++) {
                    //si no coincide no hay coimcidencia en este linea
                    if (cartaRecojada != carton[i][j]) {
                        coincidencia = false;
                    }
                }
        }
        return coincidencia;
    }



    //method check premio pokino
    public String checkPremioPokino(){
        String premio="pokino";
     if(coincidenciaVertical() || coincidenciaDiagonal() || coincidenciaDiagonalInversa() || coincidenciaLinea() ){
         return premio;
     }
     return "noHayPremio";

    }

}
