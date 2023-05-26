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
public class Lista<E>{
    private Nodo<E> pFirst;
    private Nodo<E> pLast;
    private int size;
    
    public void mostrar_todo(){
        if (esVacia()) {
            JOptionPane.showMessageDialog(null, "lista vacia crack");
            
        }else{
            Nodo tem;
            tem =getpFirst();
            System.out.println("esto es tem");
            String mostrarT="";
            for (int i = 0; i < getSize()-1; i++) {
                mostrarT += "Persona: "+ tem.toString() + "\n";
                tem= tem.getPnext();
                
            }
            JOptionPane.showMessageDialog(null, mostrarT);
        }
    }
    
    public boolean esVacia(){
        return pFirst==null;
    }
    public void insertarInicio(E x){
        size++;
        if(pFirst != null){
            Nodo data = new Nodo(x);
            data.setPnext(pFirst);
            setpFirst(data);
            
        }
        else pLast = pFirst = new Nodo(x, null);
    }
    
    public void insertarFinal(E x){
        size++;
        if(pLast != null) {
            Nodo data = new Nodo(x);
            pLast.setPnext(data);
            data.setPnext(null);
            setpLast(data);
        }
        else{
            pLast = pFirst = new Nodo(x);
        }
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
    
    

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo<E> pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo<E> getpLast() {
        return pLast;
    }

    public void setpLast(Nodo<E> pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
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