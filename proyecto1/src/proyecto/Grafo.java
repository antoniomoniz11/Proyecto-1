/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Arrays;
import javax.swing.JOptionPane;
import static proyecto.Proyecto.miGrafo;

/**
 *
 * @author Antonio
 */
public class Grafo {
    
    private boolean[] visitados;
    private int numV, numA;
    private Lista<Adyacente>[] adyacentes;
    private Usuario[] valores;
    private boolean bfs;
    
    public void setBFS() {bfs = true;}
    public void setDFS() {bfs = false;}
    
    public Grafo(int nVertices) { 
        numV = nVertices; 
        numA = 0;
        adyacentes = new Lista[numV]; 
        valores = new Usuario[numV];
        //Inicializamos la lista
        for (int i = 0; i < numV; i++) {
            adyacentes[i] = new Lista<Adyacente>();
            valores[i] = new Usuario(i, i+"");
        }
    }
    public int numIslas(){
        //Muestra el numero de islas 
        int res = 0;
        visitados = new boolean[numV];
        for (int i = 0; i < numV; i++) {
            if(!visitados[i]){    
                if(bfs) recorridoBFS(i);
                else recorridoDFS(i);//bien
                if (i>0)res++; 
            }
        }
            return res;
            
        
    }
    
    private void recorridoDFS(int origen){
        //Recorre el grafo de forma DFS
        visitados[origen] = true;
        Lista<Adyacente> ady = adyacentes[origen];
        Nodo<Adyacente> nodoAdyacente = ady.getPfirst();
        while(nodoAdyacente != null) {
            int i = nodoAdyacente.getElement().getDestino();
            if(!visitados[i]) recorridoDFS(i);
            nodoAdyacente = nodoAdyacente.getPnext();
        }
    }
    
    private void recorridoBFS(int origen) {
        //Recorre el grafo de forma BFS
        try{
        visitados[origen] = true;
        Cola<Integer> cola = new Cola();
        cola.add(origen);
        while (cola.getSize() > 0) {
            Lista<Adyacente> ady = adyacentes[cola.dequeue()];
            Nodo<Adyacente> nodoAdyacente = ady.getPfirst();
            while (nodoAdyacente != null) {
                int i = nodoAdyacente.getElement().getDestino();
                if(!visitados[i]){
                    cola.add(i);
                    visitados[i] = true;
                }
                nodoAdyacente = nodoAdyacente.getPnext();
            }
        }
    }catch (Exception e){
    }
    }
    
    public String bridges() {
        //seleccionamos la forma de recorrer el grafo
        setDFS();
        String puentes = "";
        int islas = numIslas();
        boolean[] visitad = new boolean[numV];
        int bridges = 0;
        //Pasamos por cada uno de los usuarios
        for (int i = 1; i < numV; i++) {
            int pointer = valores[i].getId();
            //tomamos su id y adyacentes
            Lista<Adyacente> listaAdyacentes = adyacentes[i];
            Nodo<Adyacente> nodoAdyacente = listaAdyacentes.getPfirst();
            int j = 0;
            while (nodoAdyacente !=null){
                //Comprobamos si aumenta el numero de listas al eliminar la arista
            int destino = nodoAdyacente.getElement().getDestino();
                eliminarArista(i, destino);
                if (islas != numIslas() && !visitad[destino]) {
                    //Si es un puente se agrega en el string y se marca como ya usado el usuario 
                    bridges++;
                    puentes += ("Puente: " + pointer + " -> " + getUsuarioid(destino) + "\n");
                    visitad[i]=true;
                    }
                //Volvemos a agregar la arista para seguir comprobando
                insertarArista(i, destino, 0);
                nodoAdyacente = nodoAdyacente.getPnext();
            }
        }puentes += ("Numero de puentes: " + bridges);
        return puentes;
    }
    public int getUsuarioid(int inde){
        return valores[inde].getId();
    }
    public Grafo(Usuario[] vertices){
        numV = vertices.length; 
        numA = 0;
        adyacentes = new Lista[numV]; 
        valores = new Usuario[numV];
        //Inicializamos la lista
        for (int i = 0; i < numV; i++) {
            adyacentes[i] = new Lista<Adyacente>();
            valores[i] = vertices[i];
        }
    }
    
    public Usuario[] getUsuarios(){return valores;}
    
    public int numVertices() {return numV;}
    
    public int numAristas() {return numA;}
    
    private int getIndex(int value) {
        //Buscamos la localiza cion del ID
        for(int i = 1; i< numV; i++){
            if(valores[i].getId() == value) {
                return i;
                    }
        }   
            return -1;
    }
    
    public boolean existeArista(int i, int j){
        //Se comprueba si existe la arista
        Nodo<Adyacente> actual = adyacentes[i].getPfirst(); 
        while (actual != null) {
            if (actual.getElement().getDestino() == j)  {
                return true;
            } 
            actual = actual.getPnext();
        }
        return false; 
    }
    
    public void insertarArista(int i, int j, int peso){
        //Añadimos la arista
        if (!existeArista(i, j)) { 
            adyacentes[i].insertarInicio(new Adyacente(j, peso));
            numA++; 
            if (!existeArista(j, i)){
                insertarArista(j,i,peso);
            }
        } else{
            JOptionPane.showMessageDialog(null, "ya existe");
        }
    }
    
    public void eliminarArista(int i, int j){
        //Eliminamos la arista 
        if (existeArista(i, j)) { 
            
            Lista<Adyacente> listaAdyacentes = adyacentes[i];
            Nodo<Adyacente> nodoAdyacente = listaAdyacentes.getPfirst();

            while (nodoAdyacente != null) {
                try{
                if (nodoAdyacente.getElement().getDestino() == j) {
                    listaAdyacentes.eliminar(nodoAdyacente);
                }
                nodoAdyacente = nodoAdyacente.getPnext();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error catastral");
                }
        } 
        numA--;
        }
        //Comprobamos que se haya eliminado 
        if (existeArista(j, i)) {
            eliminarArista(j,i);
        }
    }
        
    public void insertarAristaValor(int i, int j, int peso){
        //comprobamos las aristas y eliminamos o agregamos correspondientemente
        i = getIndex(i);
        j = getIndex(j);
        
        if(i == -1 || j == -1)return;
            if (peso==-20) {
              eliminarArista(i,j);
            }else{
               insertarArista(i, j, peso); 
            }
    }
    
    public  Lista<Adyacente> adyacentesDeValor(int i) {return adyacentes[getIndex(i)];}
    
    public Lista<Grafo> islas(){
        Lista<Grafo> res = new Lista();
        visitados = new boolean[numV];
        //Añadimos cada isla (convertida a grafo) al resultado
        for(int i = 0; i<numV; i++) 
            if(!visitados[i]){
                res.insertarInicio(adyacentes2Grafo(islas(i, new Lista[numV])));
        System.out.println("Algo paso"+ res);
            }
        return res;
    }
    
    private Lista<Adyacente>[] islas(int i, Lista<Adyacente>[] res){
       //Inicializamos el iterador
        Nodo<Adyacente> actual = adyacentes[i].getPfirst(); 
       //Marcamos el vértice como visitado
       visitados[i] = true;
       if(res[i] == null) res[i] = new Lista();
       //Mientras el vértice tenga adyacentes
       while(actual != null){
               //Recogemos el destino
               Adyacente ady = actual.getElement();
               actual = actual.getPnext();
               if(!res[i].contains(ady)){
               //Lo añadimos al resultado
                res[i].insertarInicio(ady);
                int destino = ady.getDestino();
                if(res[destino] == null) res[destino] = new Lista();
                res[destino].insertarInicio(new Adyacente(i, ady.getPeso()));
                //Volvemos a buscar desde el vértice adyacente
                islas(ady.getDestino(), res);
            }
       }
       return res;
    }
    
    private Grafo adyacentes2Grafo(Lista<Adyacente>[] list){
       int numVertices = 0;
       Lista<Usuario> verticesList = new Lista();

       //Asignamos los vértices del nuevo grafo
       for(int i = 0; i<list.length; i++) 
           if(list[i] != null) {
               verticesList.insertarInicio(valores[i]);
            }
       Usuario[] vertices = new Usuario[verticesList.size()];
       Nodo<Usuario> act = verticesList.getPfirst(); 
       for(int i = 0; i<vertices.length; i++) {vertices[i] = act.getElement(); act = act.getPnext();}
       
       //Creamos el grafo
       Grafo grafoResultado = new Grafo(vertices);
       //Añadimos las aristas al nuevo grafo
       for(int i = 0; i<list.length; i++) {
           if(list[i] != null){
               Nodo<Adyacente> actual = list[i].getPfirst(); 
               while(actual != null){
                    Adyacente ady = actual.getElement();
                    actual = actual.getPnext();
                    grafoResultado.insertarAristaValor(valores[i].getId(), valores[ady.getDestino()].getId(), (int) ady.getPeso());
                    
               }
           }
       }
       return grafoResultado;
    }
    
    public String toString() {
        //Pasamos los usuarios y relaciones a string
        String res = "";  
        for (int  i = 0; i < numVertices(); i++) {
            if (valores[i]==null){
                
            }else{
            res += "Vertice: " + (i) + " (UserID = " + valores[i].getId() + ", Nickname = " + valores[i].getNickname() +"),";
            Nodo<Adyacente> actual = adyacentes[i].getPfirst();
            if (actual == null) { res += " sin Adyacentes "; }
            else { res += " con Adyacentes "; } 
            while (actual != null) {res += (actual.getElement().toString()) + " "; actual = actual.getPnext();}
            res += "\n";  
            }
        }        
        return res;      
    }
    
    public void agregarUsuario(Usuario usuario) {
        //buscamos si existe el usuario
        int id = usuario.getId();
        if (getIndex(id) != -1) {
            System.out.println("El usuario con ID " + id + " ya existe en el grafo.");
            return;
        }
        numV++;
	int newIndex = 0;
	for(; newIndex < adyacentes.length; newIndex++){
		if(adyacentes[newIndex] == null) break;
	}
        //Agregamos un nuevo espacio
	if(newIndex == adyacentes.length) {duplicarArray();}
        //Agregamos el nuevo usuario en el espacio
           valores[newIndex] = usuario;
           adyacentes[0] = new Lista<Adyacente>();
           System.out.println("Sirvio agregar");
        numV++;
    }
   
    private void duplicarArray() {    
        //Toma el array y le añade espacios
	Lista<Adyacente>[] nuevoArray = new Lista[adyacentes.length*2];
	for(int i = 0; i<adyacentes.length;i++)nuevoArray[i] = adyacentes[i];
	adyacentes = nuevoArray;
	Usuario[] nuevoArrayValores = new Usuario[valores.length*2];
	for(int i = 0; i<valores.length;i++)nuevoArrayValores[i] = valores[i];
	valores = nuevoArrayValores;
    }
    public String buscar(int id) {
        //Busca el nombre del usuario con el respectivo ID
        int index = getIndex(id); 
        if (index == -1) {
            System.out.println("No se encontró el usuario con ID " + id + " en el grafo.");
            return "no encontrado";
        } 
        String encontrado = valores[index].getNickname();
        return encontrado;
    }
    
    public void eliminarUsuario(int id) {
        //Busca si existe el usuario
        int index = getIndex(id);    
        if (index == -1) {
            System.out.println("No se encontró el usuario con ID " + id + " en el grafo.");
            return;
        } 
        //Elimina el usuario
        valores[index] = null;
        //Elimina las adyacencias 
        numA -= adyacentes[index].size();
        adyacentes[index] = null;
        //Eliminamos las adyacencias con el usuario eliminado en cada persona
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
   
    
    public Arista[] getAristas(){
        //Debuelve las aristas con los usuarios
        Arista[] res = new Arista[numA];
        Lista<Arista> lista = new Lista();
        
         int j = 0;
         for (int i = 0; i < numV; i++) {
            if (adyacentes[i] != null) {
                Lista<Adyacente> listaAdyacentes = adyacentes[i];
                Nodo<Adyacente> nodoAdyacente = listaAdyacentes.getPfirst();
                while (nodoAdyacente != null) {
                    Arista arista = new Arista(i, nodoAdyacente.getElement().getDestino(), (int) nodoAdyacente.getElement().getPeso());
                    if(!lista.contains(arista)){
                        lista.insertarInicio(arista);
                        res[j++] = arista;
                    
                    }
                    nodoAdyacente = nodoAdyacente.getPnext();
                }
                
            }
        }
        return res;
    }
}
