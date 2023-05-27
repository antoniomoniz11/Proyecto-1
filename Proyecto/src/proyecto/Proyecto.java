/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Antonio
 */
public class Proyecto{
    private static Grafo miGrafo;
    
    
        private static Grafo extraerGrafo(String filePath){
        Grafo res = null;
        Lista<Usuario> verticesList = new Lista();
         try {
            
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

          
            if(scanner.hasNextLine()) scanner.nextLine();
         
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.equals("Relaciones")) break;
                String[] parts = line.split(", @");
                for(int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();
                verticesList.insertarFinal(new Usuario(Integer.parseInt(parts[0]), parts[1]));
            }
            Usuario[] vertices = new Usuario[verticesList.size()];            
            Nodo<Usuario> actual = verticesList.getPfirst(); 
            for(int i = 0; i < verticesList.size(); i++) {vertices[i] = actual.getElement(); actual = actual.getPnext();}
            res = new Grafo(vertices);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                for(int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();
                res.insertarAristaValor(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            }
            
            scanner.close();            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
       
       return res;
    }
    
    private static void guardarGrafo(Grafo grafo, String ruta){
        try{
        FileWriter fileWriter = new FileWriter(ruta+".txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        printWriter.println("Usuarios");
        Usuario[] usuarios = grafo.getUsuarios();
        for(Usuario usuario : usuarios){
            if(usuario == null) break;
            printWriter.println(usuario.getId()+", @"+ usuario.getNickname());
        }
        printWriter.println("Relaciones");
        Arista[] aristas = grafo.getAristas();
        for(Arista arista : aristas){
            printWriter.println(usuarios[arista.getOrigen()].getId()+", "+ usuarios[arista.getDestino()].getId() +", "+ arista.getPeso());
        }
        
        printWriter.close();
    }catch(IOException e){}
    }
    
    public static void main(String[] args){
        miGrafo = extraerGrafo("grafoText.txt");
        Usuario juanito = new Usuario(999, "Juanito123");
        
        miGrafo.agregarUsuario(juanito);
        miGrafo.insertarAristaValor(miGrafo.getUsuarios()[2].getId(), juanito.getId(), 4);
        guardarGrafo(miGrafo, "GrafoConJuanito");
        System.out.println(miGrafo.toString());
        miGrafo = extraerGrafo("GrafoConJuanito.txt");
        System.out.println(miGrafo.toString());
        
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
           
            java.io.File selectedFile = fileChooser.getSelectedFile();
            

            // Opciones para guardar o descartar el archivo
            int option = JOptionPane.showOptionDialog(null, "¿Deseas guardar los datos actuales antes de cargar un nuevo archivo?",
                    "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
                    new Object[]{"Guardar", "Descartar", "Cancelar"}, "Guardar");

            if (option == JOptionPane.YES_OPTION) {
                
                
                String ruta = "archivos/texto.txt";

                try {
                   
                    PrintWriter writer = new PrintWriter(new FileWriter(ruta));

                   
                    writer.close();


                    JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente.");

                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "La carga de archivo se ha cancelado");
        }
    }
}
