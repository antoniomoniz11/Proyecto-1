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
public class Arista {
    private int destino;
    private int origen;
    private int peso;
    
    public Arista(int o, int v, int p) { 
        origen = o;
        destino = v;  
        peso = p; 
    }
    
    public int getDestino() { return destino; }
    
    public int getOrigen() { return origen; }

    public int getPeso() { return peso; }
 
    public String toString() { return origen + " -> " +destino + "(" + peso + ") "; }
    
    public boolean equals(Arista otro){
        return ((otro.destino == destino && origen == otro.origen && otro.peso == peso) || (otro.destino == origen && otro.origen == destino && otro.peso == peso));
    }
    
    public boolean equals(Object otro){
        return otro instanceof Arista && (((Arista)otro).destino == destino && origen == ((Arista)otro).origen && ((Arista)otro).peso == peso) || (((Arista)otro).destino == origen && ((Arista)otro).origen == destino && ((Arista)otro).peso == peso);
    }
}
