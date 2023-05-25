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
import java.io.FileReader;
import java.io.BufferedReader;

/**
 *
 * @author Antonio
 */
public class Proyecto {

    private static Usuario[] obtenerContenido(String ruta) throws IOException {
    Usuario[] usuarios = new Usuario[20];
    int numUsuarios = 0;
    
    boolean seccionUsuarios = false;
    boolean seccionRelaciones = false;
    
    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.startsWith("Usuarios")) {
                seccionUsuarios = true;
                continue;
            } else if (linea.startsWith("Relaciones")) {
                seccionUsuarios = false;
                seccionRelaciones = true;
                continue;
            }
            
            if (seccionUsuarios) {
              
                String[] datosUsuario = linea.split(",");
                int id = Integer.parseInt(datosUsuario[0]);
                String nickname = datosUsuario[1];
                Usuario usuario = new Usuario(id, nickname);
                usuarios[numUsuarios] = usuario;
                numUsuarios++;
            } else if (seccionRelaciones) {
             
                String[] datosRelaciones = linea.split(",");
                int idUsuario = Integer.parseInt(datosRelaciones[0]);
                Usuario usuario = usuarios[idUsuario];
                
                for (int i = 1; i < datosRelaciones.length; i++) {
                    int idAmigo = Integer.parseInt(datosRelaciones[i]);
                    usuario.agregarAmigo(idAmigo);
                }
            }
        }
    }
    
    Usuario[] resultado = new Usuario[numUsuarios];
    System.arraycopy(usuarios, 0, resultado, 0, numUsuarios);
    
    return resultado;
}


    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            java.io.File selectedFile = fileChooser.getSelectedFile();
    
            int option = JOptionPane.showOptionDialog(null, "¿Deseas guardar los datos actuales antes de cargar un nuevo archivo?",
                    "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
                    new Object[]{"Guardar", "Descartar", "Cancelar"}, "Guardar");

            if (option == JOptionPane.YES_OPTION) {
                
                String ruta = "archivos/texto.txt";

                try {
                 
                    Usuario[] usuarios = obtenerContenido(ruta);

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
