/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Antonio
 */
public class Lista<E>
{
    private Nodo<E> pfirst;
    private Nodo<E> plast;
    private int size;
    
    public void Eliminararistaa(E x){
        size--;
        if (size==0) {
            plast = pfirst = null;
        }
        else plast = pfirst = new Nodo(x, null);
    }
    
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
        else {
            plast = pfirst = new Nodo(x, null);
        }
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
    public boolean isEmpty(){
        return pfirst == null;
    }
    public void imprimir(){
        Nodo<E> temp = pfirst;
        int cuenta = 0;
        if (this.isEmpty()) {
            System.out.println("Está vacía");
        }
        while (temp != null){
            cuenta++;
            System.out.println(cuenta + ".,  " + temp.getElement());
            temp = temp.getPnext();
        }
        System.out.println(size);
        
    }
    
    public Nodo getPfirst() {
        return pfirst;
    }

    
    public void eliminar(Nodo<E> nodo){
        Nodo<E> actual = pfirst;
        if(size == 1) {pfirst = plast = null;return;}
        if(nodo.equals(actual)) {pfirst = pfirst.getPnext(); return;}
        while(!actual.getPnext().equals(nodo)) actual = actual.getPnext();
        if(nodo.equals(plast)) plast = actual; 
        actual.setPnext(nodo.getPnext());
        size--;
    }
    
   
}
