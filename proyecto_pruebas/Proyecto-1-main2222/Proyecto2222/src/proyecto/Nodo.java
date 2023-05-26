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
    
    public Nodo(E valor){
        this.valor = valor;
        this.pnext = null;
    }

    public Nodo(E valor, Nodo pnext) {
        this.valor = valor;
        this.pnext = pnext;
    }
    
    public E getElement() {return valor;}
    public Nodo getPnext() {return pnext;}
    public void setPnext(Nodo next) {pnext = next;}
}