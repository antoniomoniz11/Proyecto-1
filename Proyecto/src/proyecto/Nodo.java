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
public class Nodo<E>
{
    private E valor;
    private Nodo pnext;
    
    public Nodo(E valor, Nodo sig){
        this.valor = valor;
        this.pnext = pnext;
    }
    
    public E getElement() {return valor;}
    public Nodo getPnext() {return pnext;}
    public void setPnext(Nodo pnext) {pnext = pnext;}
}
