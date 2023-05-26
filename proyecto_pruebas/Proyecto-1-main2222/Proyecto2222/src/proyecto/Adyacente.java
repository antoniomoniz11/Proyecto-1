/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Antonio
 */
public class Adyacente {
    
    private int destino;
    private double peso;
    
    public Adyacente(int v, double p){
        destino = v;
        peso = p;
    }

    /**
     * @return the destino
     */
    public int getDestino() {
        return destino;
    }


    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    public String toString(){
        return destino + "(" + peso + ")";
    }
    
}
