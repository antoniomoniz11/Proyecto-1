/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.awt.Desktop;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Antonio
 */
public class Proyecto{
    public static Grafo miGrafo;
    //Variable general que contiene el grafo
    
        public static Grafo extraerGrafo(File file){
            //Toma el file correspondiente
        Grafo res = null;
        Lista<Usuario> verticesList = new Lista();
        //scanea el file
         try {
            Scanner scanner = new Scanner(file);
            if(scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.equals("Relaciones")) {
                    verticesList.insertarInicio(null);
                    break;
                }
                if (!line.equals("")) {
                //Guardamos los usuarios
                String[] parts = line.split(", @");
                for(int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();
                verticesList.insertarInicio(new Usuario(Integer.parseInt(parts[0]), parts[1]));   
                }
            }
            
            Usuario[] vertices = new Usuario[verticesList.size()];            
            Nodo<Usuario> actual = verticesList.getPfirst(); 
            for(int i = 0; i < verticesList.size(); i++) {
                vertices[i] = actual.getElement(); 
                actual = actual.getPnext();
            }
            res = new Grafo(vertices);
            //Guardamos las relaciones
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                for(int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();
                res.insertarAristaValor(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                
            }
            
            scanner.close();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage()+ "\nTry again");
           
        }
        
       return res;
    }
    
    public static void guardarGrafo(Grafo grafo, File ruta){
        //Toma el grafo y el file donde se guardara
        try{
        FileWriter fileWriter = new FileWriter(ruta);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        printWriter.println("Usuarios");
        Usuario[] usuarios = grafo.getUsuarios();
        //Toma los usuarios y los escribe en el archivo
        for(Usuario usuario : usuarios){
            try{
                printWriter.println(usuario.getId()+", @"+ usuario.getNickname());
            }catch (Exception e){
            }
        }
        printWriter.println("Relaciones");
        Arista[] aristas = grafo.getAristas();
        //Toma las aristas y los escribe en el archivo
        for(Arista arista : aristas){
            try{
            printWriter.println(usuarios[arista.getOrigen()].getId()+", "+ usuarios[arista.getDestino()].getId() +", "+ arista.getPeso());
            }catch (Exception e){
                }
        }
        
        printWriter.close();
    }catch(Exception e){
            System.out.println("Error " + e);
    }
    }
    
    public static String mostrarisla(File file){
        extraerGrafo(file);
        String resultado = "";
        String[] opciones = {"DFS", "BFS", "Cancelar"};
        int selec = JOptionPane.showOptionDialog(null, "Seleccione un método para hacer el recorrido",
                    "Mostrar Número de Islas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    opciones, opciones[0]);
        
        switch (selec){
            case 0:
                miGrafo.setDFS();
                resultado = "Número de Islas: " + miGrafo.numIslas();
                break;
            case 1:
                miGrafo.setBFS();
                resultado = "Número de Islas: " + miGrafo.numIslas();
                break;
            case 2:
                break;
            default:
                break;
        }
                return resultado;
    }    
}