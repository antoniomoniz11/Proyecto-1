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
    private E element;
    private Nodo pnext;
    
    public Nodo(E element, Nodo pnext){
        this.element = element;
        this.pnext = pnext;
    }
    
    public E getElement() {return element;}
    public Nodo getPnext() {return pnext;}
    public void setPnext(Nodo pnext) {this.pnext = pnext;}
    
    public boolean equals(Nodo<E> otro){
        return element == otro.element && ((pnext == null && otro.pnext == null) || pnext.equals(otro.pnext));
    }
}

