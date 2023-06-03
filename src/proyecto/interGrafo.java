/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import static interfa.Ventanas.Ventana1.guardado_automatico;
import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
    import org.graphstream.graph.*;
    import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;
import static proyecto.Proyecto.extraerGrafo;
import static proyecto.Proyecto.guardarGrafo;
import static proyecto.Proyecto.miGrafo;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.AbstractGraph;

/**
 *
 * @author donat
 */
public class interGrafo {
    /**
     * @param args the command line arguments
     */
    public static void muestragrafo() {
        // Create a graph
        Graph graph = new SingleGraph("My Graph");
        miGrafo = extraerGrafo(guardado_automatico);
        guardarGrafo(miGrafo,guardado_automatico);
        System.setProperty("org.graphstream.ui", "swing");
        Usuario[] usuarios = miGrafo.getUsuarios();
        Arista[] aristas = miGrafo.getAristas();
        int o=0;
        for(Usuario usuario : usuarios){
            try{
         graph.addNode(Integer.toString(usuario.getId()));
            o++;  
        }catch(Exception e){
        }
        }
        new interGrafo(graph);
    }
        public interGrafo(Graph graph) {
            graph.setAttribute("ui.stylesheet", styleSheet);
            Viewer nah = graph.display();
            nah.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
            int i = 0;
            
        Usuario[] usuarios = miGrafo.getUsuarios();
        Arista[] aristas = miGrafo.getAristas();
            int z=0;
            for(Arista arista : aristas){
            try{
            graph.addEdge(Integer.toString(z),  Integer.toString(usuarios[arista.getDestino()].getId()),Integer.toString(usuarios[arista.getOrigen()].getId()));
            graph.setAttribute("ui.style", "size: 900px;" );
            graph.getEdge(Integer.toString(z)).setAttribute("ui.label",arista.getPeso());
            graph.getEdge(Integer.toString(z)).setAttribute("ui.style","size: 15px;");
            graph.getEdge(Integer.toString(z)).setAttribute("ui.style","text-size: 18px;");
            graph.getEdge(Integer.toString(z)).setAttribute("ui.style","text-color: grey;");
            z++;
            }catch(Exception e){
        }
            }
            for (Node node : graph) {
        node.setAttribute("ui.label", node.getId());
        node.setAttribute("ui.style", "text-size: 18px;");
            node.setAttribute("ui.style", "size: 35px;" );
        }
        }
        public void explore(Node source) {
            Iterator<? extends Node> k = source.getBreadthFirstIterator();
            while (k.hasNext()) {
                Node next = k.next();
                next.setAttribute("ui.class", "marked");
                sleep();
            }
        }
        protected void sleep() {
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
        protected String styleSheet =
        "node {" +
        "	fill-color: #40CFFF;" +
        "}" +
        "node.marked {" +
        "	fill-color: #40CFFF;" +
        "}";
        
        
        
}
