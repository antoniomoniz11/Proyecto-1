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
public class Lista<E>{
    private Nodo<E> pFirst;
    private Nodo<E> pLast;
    private int size;
    
    public void insertarInicio(E x){
        size++;
        if(pFirst != null){
            pFirst = new Nodo(x, pFirst);
        }
        else pLast = pFirst = new Nodo(x, null);
    }
    
    public void insertarFinal(E x){
        size++;
        if(pLast != null) {
            pLast.setPnext(new Nodo(x, null));
            pLast = pLast.getPnext();
        }
        else pLast = pFirst = new Nodo(x, null);
    }
    
    public int size(){
        return size;
    }
    
    public boolean contains(E e){
        Nodo actual = pFirst;
        while(actual != null){
            if(actual.getElement().equals(e)) return true;
            actual = actual.getPnext();
        }
        return false;
    }
    
    public String toString(){
        String res = "";
        Nodo actual = pFirst;
        while(actual != null){
            if(actual.getPnext() != null) res += actual.getElement() + "-> ";
            else res += actual.getElement();
            actual = actual.getPnext();
        }
        return res;
    }
    
    public void imprimir(){
        System.out.println(toString());
    }
    
    public Nodo getPfirst() {return pFirst;}
    
    public void eliminar(Nodo<E> nodo) {
        if (pFirst == null) {
            return; //
        }

        if (nodo == pFirst) {
            pFirst = pFirst.getPnext();

            if (pFirst == null) {
                pLast = null; //
            }

            size--;
            return;
        }

        Nodo<E> current = pFirst;
        Nodo<E> previous = null;

        while (current != null && current != nodo) {
            previous = current;
            current = current.getPnext();
        }

        if (current == null) {
            return; // 
        }

        previous.setPnext(current.getPnext());

        if (current == pLast) {
            pLast = previous; 
        }

        size--;
    }
}