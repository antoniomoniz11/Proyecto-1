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
/**
 *
 * @author donat
 */
public class Ventana3 extends javax.swing.JFrame {

    /**
     * Creates new form Ventana3
     */
    public Ventana3() {
        miGrafo = extraerGrafo(guardado_automatico);
//        this.setLocationRelativeTo(null);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        devolver = new javax.swing.JButton();
        devolveroculto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        idusuario = new javax.swing.JTextField();
        idamigo = new javax.swing.JTextField();
        buscaruser = new javax.swing.JButton();
        buscaramigo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreamigo = new javax.swing.JLabel();
        nombreuser = new javax.swing.JLabel();
        crearamistad = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        añosamistad = new javax.swing.JTextField();
        ver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        devolver.setBorderPainted(false);
        devolver.setContentAreaFilled(false);
        devolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        devolver.setFocusable(false);
        devolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverActionPerformed(evt);
            }
        });
        getContentPane().add(devolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 20, 20));

        devolveroculto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        devolveroculto.setBorderPainted(false);
        devolveroculto.setContentAreaFilled(false);
        devolveroculto.setFocusable(false);
        devolveroculto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverocultoActionPerformed(evt);
            }
        });
        getContentPane().add(devolveroculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Agregar Amigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        idusuario.setText("000");
        idusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idusuarioActionPerformed(evt);
            }
        });
        getContentPane().add(idusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 90, -1));

        idamigo.setText("000");
        idamigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idamigoActionPerformed(evt);
            }
        });
        getContentPane().add(idamigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 90, -1));

        buscaruser.setBackground(new java.awt.Color(51, 204, 0));
        buscaruser.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        buscaruser.setForeground(new java.awt.Color(0, 0, 0));
        buscaruser.setText("Search");
        buscaruser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscaruser.setName(""); // NOI18N
        buscaruser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaruserActionPerformed(evt);
            }
        });
        getContentPane().add(buscaruser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 70, -1));

        buscaramigo.setBackground(new java.awt.Color(51, 204, 0));
        buscaramigo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        buscaramigo.setForeground(new java.awt.Color(0, 0, 0));
        buscaramigo.setText("Search");
        buscaramigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscaramigo.setName(""); // NOI18N
        buscaramigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaramigoActionPerformed(evt);
            }
        });
        getContentPane().add(buscaramigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 70, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("ID Usuario:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 80, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Años de amistad: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 120, 20));

        nombreamigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nombreamigo.setText("Nombre: ");
        getContentPane().add(nombreamigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 210, 20));

        nombreuser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nombreuser.setText("Nombre: ");
        getContentPane().add(nombreuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 210, 20));

        crearamistad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/añadirb.png"))); // NOI18N
        crearamistad.setBorderPainted(false);
        crearamistad.setContentAreaFilled(false);
        crearamistad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearamistad.setFocusable(false);
        crearamistad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearamistadActionPerformed(evt);
            }
        });
        getContentPane().add(crearamistad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));

        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete8bit.png"))); // NOI18N
        Delete.setBorderPainted(false);
        Delete.setContentAreaFilled(false);
        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.setFocusable(false);
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("ID Amigo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 80, 20));

        añosamistad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        añosamistad.setText("000");
        añosamistad.setToolTipText("");
        getContentPane().add(añosamistad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 35, -1));

        ver.setBackground(new java.awt.Color(0, 204, 204));
        ver.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ver.setForeground(new java.awt.Color(0, 0, 0));
        ver.setText("Ver Usuarios");
        ver.setFocusable(false);
        ver.setMargin(new java.awt.Insets(2, 8, 2, 8));
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        getContentPane().add(ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 80, 20));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/8bitfondo3.png"))); // NOI18N
        jLabel1.setFocusable(false);
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void devolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverActionPerformed
        guardarGrafo(miGrafo, guardado_automatico);
        dispose();
        Ventana1 v1 = new Ventana1(true);
        v1.setVisible(true);
    }//GEN-LAST:event_devolverActionPerformed

    private void devolverocultoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverocultoActionPerformed
        guardarGrafo(miGrafo, guardado_automatico);
        dispose();
        Ventana1 v1 = new Ventana1(true);
        v1.setVisible(true);
    }//GEN-LAST:event_devolverocultoActionPerformed

    private void buscaruserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaruserActionPerformed
        miGrafo = extraerGrafo(guardado_automatico);
        //Busca el nombre del usuario con el id
        nombreuser.setText("Nombre: " +miGrafo.buscar(Integer.parseInt(idamigo.getText())));
    }//GEN-LAST:event_buscaruserActionPerformed

    private void buscaramigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaramigoActionPerformed
        miGrafo = extraerGrafo(guardado_automatico);
        //Busca el nombre del usuario con el id
        nombreamigo.setText("Nombre: " +miGrafo.buscar(Integer.parseInt(idusuario.getText())));
    }//GEN-LAST:event_buscaramigoActionPerformed

    private void crearamistadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearamistadActionPerformed
        miGrafo = extraerGrafo(guardado_automatico);
        //Comprueba datos
        if (idusuario.getText().equals(idamigo.getText())) {
            JOptionPane.showMessageDialog(null, "Error, introduzca datos validos");
        }else{
        try{
            //Crea una amistad entre los dos usuarios colocados
        miGrafo.insertarAristaValor(Integer.parseInt(idusuario.getText()), Integer.parseInt(idamigo.getText()), Integer.parseInt(añosamistad.getText()));
        guardarGrafo(miGrafo, guardado_automatico);
        JOptionPane.showMessageDialog(null, "Accion realizada");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, introduzca datos validos");
        }
        }
    }//GEN-LAST:event_crearamistadActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        miGrafo = extraerGrafo(guardado_automatico);
        //Comprueba datos
        if (idusuario.getText().equals(idamigo.getText())) {
            JOptionPane.showMessageDialog(null, "Error, introduzca datos validos");
        }else{
            //Elimina la amistad entre los dos usuarios colocados
            try{            
            miGrafo.insertarAristaValor(Integer.parseInt(idusuario.getText()), Integer.parseInt(idamigo.getText()), -20);
            guardarGrafo(miGrafo, guardado_automatico);
            JOptionPane.showMessageDialog(null, "Accion realizada");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error, introduzca datos validos");
            }     
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void idusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idusuarioActionPerformed

    private void idamigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idamigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idamigoActionPerformed

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        miGrafo = extraerGrafo(guardado_automatico);
        //Muestra los usuarios
        JOptionPane.showMessageDialog(null, miGrafo);
    }//GEN-LAST:event_verActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JTextField añosamistad;
    private javax.swing.JButton buscaramigo;
    private javax.swing.JButton buscaruser;
    private javax.swing.JButton crearamistad;
    private javax.swing.JButton devolver;
    private javax.swing.JButton devolveroculto;
    private javax.swing.JTextField idamigo;
    private javax.swing.JTextField idusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreamigo;
    private javax.swing.JLabel nombreuser;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables
}
