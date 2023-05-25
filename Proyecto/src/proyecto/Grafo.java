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
public class Grafo {

    private boolean[] visitados;
    private int numV, numA;
    private Lista<Adyacente>[] adyacentes;
    private Usuario[] valores;
    
 
    public Grafo(int nVertices) { 
        
        numV = nVertices; 
        numA = 0;
       
        adyacentes = new Lista[numV]; 
       
        valores = new Usuario[numV];
        
        for (int i = 0; i < numV; i++) {
            
            adyacentes[i] = new Lista<Adyacente>();
           
            valores[i] = new Usuario(i, i+"");
        }
    }
    
    public Grafo(Usuario[] vertices){
        
        numV = vertices.length; 
        numA = 0;
        adyacentes = new Lista[numV]; 
        valores = new Usuario[numV];
        
        for (int i = 0; i < numV; i++) {
            adyacentes[i] = new Lista<Adyacente>();
            //se asigna obj usuario al vertice
            valores[i] = vertices[i];
        }
    }
    
    public int numVertices() {return numV;}
    
    public int numAristas() {return numA;}
    
    
    private int getIndex(int value) {
        for(int i = 0; i< numV; i++){
            
            if(valores[i].getId() == value) return i;
        }
        
        return -1;
    }
    
    public boolean existeArista(int i, int j){
        Nodo<Adyacente> actual = adyacentes[i].getPfirst(); 
        while (actual != null) {
            if (actual.getElement().getDestino() == j)  return true; 
            actual = actual.getPnext();
        }
        return false; 
    }
    
    public void insertarArista(int i, int j, double peso){
        if (!existeArista(i, j)) { 
            adyacentes[i].insertarInicio(new Adyacente(j, peso)); 
            adyacentes[j].insertarInicio(new Adyacente(i, peso));
            numA++; 
        }
    }
    
    public void insertarAristaValor(int i, int j, double peso){
        i = getIndex(i);
        j = getIndex(j);
        
        if(i == -1 || j == -1) return;
        insertarArista(i, j, peso);
    }

    public  Lista<Adyacente> adyacentesDe(int i) {return adyacentes[i];}
    
    public  Lista<Adyacente> adyacentesDeValor(int i) {return adyacentesDe(getIndex(i));}
    
    public Lista<Grafo> islas(){
        Lista<Grafo> res = new Lista();
        visitados = new boolean[numV];
        
        for(int i = 0; i<numV; i++) 
            if(!visitados[i])res.insertarInicio(adyacentes2Grafo(islas(i, new Lista[numV])));
        return res;
    }
    
    private Lista<Adyacente>[] islas(int i, Lista<Adyacente>[] res){
       
        Nodo<Adyacente> actual = adyacentes[i].getPfirst(); 
      
       visitados[i] = true;
       if(res[i] == null) res[i] = new Lista();
 
       while(actual != null){
             
               Adyacente ady = actual.getElement();
               actual = actual.getPnext();
               if(!res[i].contains(ady)){
               
                res[i].insertarInicio(ady);
                int destino = ady.getDestino();
                if(res[destino] == null) res[destino] = new Lista();
                res[destino].insertarInicio(new Adyacente(i, ady.getPeso()));
               
                islas(ady.getDestino(), res);
            }
       }
       return res;
    }
    
    private Grafo adyacentes2Grafo(Lista<Adyacente>[] list){
       int numVertices = 0;
       Lista<Usuario> verticesList = new Lista();

       
       for(int i = 0; i<list.length; i++) 
           if(list[i] != null) {
               verticesList.insertarInicio(valores[i]);
            }
       Usuario[] vertices = new Usuario[verticesList.size()];
       Nodo<Usuario> act = verticesList.getPfirst(); 
       for(int i = 0; i<vertices.length; i++) {vertices[i] = act.getElement(); act = act.getPnext();}
       

       Grafo grafoResultado = new Grafo(vertices);

       for(int i = 0; i<list.length; i++) {
           if(list[i] != null){
               Nodo<Adyacente> actual = list[i].getPfirst(); 
               while(actual != null){
                    Adyacente ady = actual.getElement();
                    actual = actual.getPnext();
                    grafoResultado.insertarAristaValor(valores[i].getId(), valores[ady.getDestino()].getId(), ady.getPeso());
               }
            }
       }
       return grafoResultado;
    }
    
    public String toString() {
        String res = "";  
        for (int  i = 0; i < numVertices(); i++) {
            res += "Vertice: " + i + " (UserID = " + valores[i].getId() + ", Nickname = " + valores[i].getNickname() +"),";
            Nodo<Adyacente> actual = adyacentesDe(i).getPfirst(); 
            if (actual == null) { res += " sin Adyacentes "; }
            else { res += " con Adyacentes "; } 
            while (actual != null) {res += actual.getElement().toString() + " "; actual = actual.getPnext();}
            res += "\n";  
        }        
        return res;      
    }
    
    
    
    public void agregarUsuario(Usuario usuario) {
        int id = usuario.getId();
        
        if (getIndex(id) != -1) {
            System.out.println("El usuario con ID " + id + " ya existe en el grafo.");
            return;
        }
        
        int newIndex = numV;
        
        valores[newIndex] = usuario;
        
        adyacentes[newIndex] = new Lista<Adyacente>();
        
        numV++;
    }
    
    
    public void eliminarUsuario(int id) {

        int index = getIndex(id);    
        if (index == -1) {
            System.out.println("No se encontró el usuario con ID " + id + " en el grafo.");
            return;
        } 
        valores[index] = null;
        
        adyacentes[index] = null;
        
        for (int i = 0; i < numV; i++) {
            if (adyacentes[i] != null) {
                Lista<Adyacente> listaAdyacentes = adyacentes[i];
                Nodo<Adyacente> nodoAdyacente = listaAdyacentes.getPfirst();
                
                while (nodoAdyacente != null) {
                    if (nodoAdyacente.getElement().getDestino() == index) {
                        listaAdyacentes.eliminar(nodoAdyacente);
                        break;
                    }
                    nodoAdyacente = nodoAdyacente.getPnext();
                }
            }
        }
        
        numV--;
    }
}
