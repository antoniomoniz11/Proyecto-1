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
public class Lista<E>
{
    private Nodo<E> pfirst;
    private Nodo<E> plast;
    private int size;
    
    public void insertarInicio(E x){
        size++;
        if(pfirst != null){
            pfirst = new Nodo(x, pfirst);
        }
        else plast = pfirst = new Nodo(x, null);
    }
    
    public void insertarFinal(E x){
        size++;
        if(plast != null) {
            plast.setPnext(new Nodo(x, null));
            plast = plast.getPnext();
        }
        else plast = pfirst = new Nodo(x, null);
    }
    
    public int size(){
        return size;
    }
    
    public boolean contains(E e){
        Nodo actual = pfirst;
        int i = 0;
        while(actual != null){
            if(actual.getElement().equals(e)) return true;
            actual = actual.getPnext();
        }
        return false;
    }
    
    public String toString(){
        String res = "";
        Nodo actual = pfirst;
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
    
    public Nodo getPfirst() {return pfirst;}
    
    public void eliminar(Nodo<E> nodo){
        size--;
        Nodo<E> actual = pfirst;
        if(size == 1) {pfirst = plast = null; return;}
        if(nodo.equals(actual)) {pfirst = plast.getPnext(); return;}
        while(!actual.getPnext().equals(nodo)) actual = actual.getPnext();
        if(nodo.equals(plast)) plast = actual; 
        actual.setPnext(nodo.getPnext());
    }
    
   
}
