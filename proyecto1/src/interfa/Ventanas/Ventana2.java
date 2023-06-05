/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfa.Ventanas;

import static interfa.Ventanas.Ventana1.guardado_automatico;
import javax.swing.JOptionPane;
import static proyecto.Proyecto.extraerGrafo;
import static proyecto.Proyecto.guardarGrafo;
import static proyecto.Proyecto.miGrafo;
import proyecto.Usuario;


/**
 *
 * @author donat
 */
public class Ventana2 extends javax.swing.JFrame {
    /**
     * Creates new form Ventana2
     */
    public Ventana2() {
        //Extraemos el grafo y creamos un id al azar, que no se repita
//        this.setLocationRelativeTo(null);
    miGrafo = extraerGrafo(guardado_automatico);
        initComponents();
        String idU= Integer.toString((int) (Math.random() * (999 - 100) + 100));
        miGrafo = extraerGrafo(guardado_automatico);  
        idcreado.setText(miGrafo.buscar(Integer.parseInt(idU)));
        while (!idcreado.getText().equals("no encontrado")){
        idU= Integer.toString((int) (Math.random() * (999 - 100) + 100));    
        idcreado.setText(miGrafo.buscar(Integer.parseInt(idU)));
        }
        idcreado.setText(idU);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        limpiar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        aceptar = new javax.swing.JButton();
        devolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dialogo = new javax.swing.JLabel();
        nombretxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idcreado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        limpiar.setBorderPainted(false);
        limpiar.setContentAreaFilled(false);
        limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 30, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        aceptar.setBorderPainted(false);
        aceptar.setContentAreaFilled(false);
        aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 30, 30));

        devolver.setBorderPainted(false);
        devolver.setContentAreaFilled(false);
        devolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        devolver.setFocusable(false);
        devolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverActionPerformed(evt);
            }
        });
        getContentPane().add(devolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 30, 20));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Pulsa aqui para volver");
        jLabel2.setFocusable(false);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 130, 30));

        dialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dialogo 8 bit peq.png"))); // NOI18N
        getContentPane().add(dialogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        nombretxt.setBackground(new java.awt.Color(255, 255, 255));
        nombretxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombretxtActionPerformed(evt);
            }
        });
        getContentPane().add(nombretxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 150, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre:");
        jLabel3.setFocusable(false);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 60, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        idcreado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idcreado.setForeground(new java.awt.Color(0, 0, 0));
        idcreado.setText("128");
        idcreado.setFocusable(false);
        getContentPane().add(idcreado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 50, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario text.png"))); // NOI18N
        jLabel5.setFocusable(false);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/8bitfondo2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombretxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombretxtActionPerformed
        miGrafo = extraerGrafo(guardado_automatico);
        //crea un id al azar sin que se repita
        JOptionPane.showMessageDialog(null, miGrafo);
        int id= (int) (Math.random() * (999 - 100) + 100);
        while ("no encontrado".equals(miGrafo.buscar(id))){
        id= (int) (Math.random() * (999 - 100) + 100);
        }
        idcreado.setText(String.valueOf(id));
                    
    }//GEN-LAST:event_nombretxtActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        //crea un id al azar sin que se repita
        nombretxt.setText("");
        String idU= Integer.toString((int) (Math.random() * (999 - 100) + 100));
        miGrafo = extraerGrafo(guardado_automatico);  
        idcreado.setText(miGrafo.buscar(Integer.parseInt(idU)));
        while (!idcreado.getText().equals("no encontrado")){
        idU= Integer.toString((int) (Math.random() * (999 - 100) + 100));    
        idcreado.setText(miGrafo.buscar(Integer.parseInt(idU)));
        }
        idcreado.setText(idU);
    }//GEN-LAST:event_limpiarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        //Comprueba los datos puestos
        if (nombretxt.getText()!="") {
        try{
        miGrafo = extraerGrafo(guardado_automatico);
        Usuario nuevoU = new Usuario(Integer.parseInt(idcreado.getText()), nombretxt.getText());
        JOptionPane.showMessageDialog(null, nuevoU.getId() + "\n" +nuevoU.getNickname());
        //Agrega el usuario al grafo y lo guarda
        miGrafo.agregarUsuario(nuevoU);
        guardarGrafo(miGrafo, guardado_automatico);
        //Abre otra ventana
        dispose();
            Ventana2_2 v2_2 = new Ventana2_2();
            v2_2.Ventanatext("Añadir Amigo",nuevoU.getId());
            v2_2.setVisible(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error, "+ e);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Introduzca los datos");
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void devolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverActionPerformed
        guardarGrafo(miGrafo, guardado_automatico);
        Ventana1 v1 = new Ventana1(true);
        dispose();
        v1.setVisible(true);

    }//GEN-LAST:event_devolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton devolver;
    private javax.swing.JLabel dialogo;
    private javax.swing.JLabel idcreado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField nombretxt;
    // End of variables declaration//GEN-END:variables
}
