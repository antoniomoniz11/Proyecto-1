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
        public static Grafo extraerGrafo(File file){
        Grafo res = null;
        Lista<Usuario> verticesList = new Lista();
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
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                for(int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();
                res.insertarAristaValor(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                res.insertarAristaValor(Integer.parseInt(parts[1]),Integer.parseInt(parts[0]),  Integer.parseInt(parts[2]));
            }
            
            scanner.close();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage()+ "\nTry again");
           
        }
        
       return res;
    }
    
    public static void guardarGrafo(Grafo grafo, File ruta){
        try{
        FileWriter fileWriter = new FileWriter(ruta);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        printWriter.println("Usuarios");
        Usuario[] usuarios = grafo.getUsuarios();
            
        for(Usuario usuario : usuarios){
            
            try{
                printWriter.println(usuario.getId()+", @"+ usuario.getNickname());
                
            }catch (Exception e){
                System.out.println(usuario);//revisar
            }
            
            
            
        }
        printWriter.println("Relaciones");
        Arista[] aristas = grafo.getAristas();
        for(Arista arista : aristas){
            try{
            printWriter.println(usuarios[arista.getOrigen()].getId()+", "+ usuarios[arista.getDestino()].getId() +", "+ arista.getPeso());
                
            }catch (Exception e){
                System.out.println(arista);//ver
                
                }
        }
        
        printWriter.close();
    }catch(Exception e){
            System.out.println("Error " + e);
    }
    }
    
    public static void main(String[] args){
        File guardado_automatico = new File("src\\Archivos\\guardado_automatico.txt");
        JFileChooser file=new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        file.setFileFilter(filter);
        file.showOpenDialog(file);
        File abre=file.getSelectedFile();
        int result = file.getDialogType();
        if (result == JFileChooser.APPROVE_OPTION) {
        miGrafo = extraerGrafo(abre);
        guardarGrafo(miGrafo,guardado_automatico);
        }else{
             JOptionPane.showMessageDialog(null, "La carga de archivo se ha cancelado");
        }
            int option = JOptionPane.showOptionDialog(null, "¿Deseas guardar los datos actuales antes de cargar un nuevo archivo?",
                    "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
                    new Object[]{"Guardar", "Descartar", "Cancelar"}, "Guardar");
            if (option == JOptionPane.YES_OPTION) {
                try {
                    miGrafo = extraerGrafo(guardado_automatico);
                    guardarGrafo(miGrafo,abre);
                    JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente.");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
                }
            } else if (option == JOptionPane.NO_OPTION) {
                
            } else if (option == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "La carga de archivo se ha cancelado");
                System.exit(0);
            }
        }
    
    
}
    
    


