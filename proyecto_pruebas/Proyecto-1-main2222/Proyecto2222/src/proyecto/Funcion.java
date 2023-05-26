/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author donat
 */
public class Funcion {
    
    public void escribir_txt(Lista personas){
        String personas_actuales= "";
        if (!personas.esVacia()) {
            Nodo tem = personas.getpFirst();
            for (int i = 0; i < personas.getSize()-1; i++) {
                
                personas_actuales += tem.getElement()+ "\n";
                
                tem= tem.getPnext();
            }
        }
        try{
            PrintWriter pw = new PrintWriter("test\\personas.txt");
            pw.print(personas_actuales);
            pw.close();
            JOptionPane.showMessageDialog(null, "listo cdtm");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public Lista leer_txt(){
        Lista personas = new Lista();
        String line;
        String personas_txt= "";
        String path= "test\\personas.txt";
        File file = new File(path);
        try{
            if (!file.exists()) {
                file.createNewFile();
                
            }else{
                FileReader fr= new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) !=null){
                    if (!line.isEmpty()){
                        personas_txt += line + "\n";
                       
                    }
                }
                if (!"".equals(personas_txt)) {
                    
                    String[] personas_split = personas_txt.split("\n");
                    
                    for (int i = 0; i < personas_split.length; i++) {
//                        String[] persona = personas_split[i].split(",");
//                        NodoRelaciones relacion = new NodoRelaciones(Integer.parseInt(persona[2]));
                        
                        personas.insertarFinal(new Nodo(personas_split[i]));
                                                
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "se leyo to");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return personas;
    }
}