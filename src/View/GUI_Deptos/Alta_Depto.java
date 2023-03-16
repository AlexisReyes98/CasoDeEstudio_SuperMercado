
package View.GUI_Deptos;

import ConectionSQL.Deptos_DB;
import Model.Departamento;
import javax.swing.JOptionPane;

/**
 *
 * @author alexis
 */
public class Alta_Depto extends javax.swing.JFrame {
    Deptos_DB depto_db = new Deptos_DB();

    /** Creates new form Alta_Depto */
    public Alta_Depto() {
        initComponents();
        this.setTitle("Control de Departamentos");
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        altaClave = new javax.swing.JTextField();
        altaNombre = new javax.swing.JTextField();
        altaJefe = new javax.swing.JTextField();
        altaDepartamento = new javax.swing.JButton();
        regresar_MenuDepto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Alta de departamento:");

        jLabel2.setText("Clave del departamento");

        jLabel3.setText("Nombre del departamento");

        jLabel4.setText("Jefe");

        altaDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GuardarTodo.png"))); // NOI18N
        altaDepartamento.setText("Dar de alta");
        altaDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaDepartamentoActionPerformed(evt);
            }
        });

        regresar_MenuDepto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actualizar.png"))); // NOI18N
        regresar_MenuDepto.setText("Regresar a Menú Departamentos");
        regresar_MenuDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar_MenuDeptoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(altaDepartamento)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(11, 11, 11)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(altaNombre)
                                    .addComponent(altaClave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(altaJefe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(regresar_MenuDepto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altaClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altaJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(altaDepartamento)
                .addGap(32, 32, 32)
                .addComponent(regresar_MenuDepto)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresar_MenuDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar_MenuDeptoActionPerformed
        new Menu_Deptos().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_regresar_MenuDeptoActionPerformed

    private void altaDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaDepartamentoActionPerformed
        if (!"".equals(altaClave.getText()) && !"".equals(altaNombre.getText()) && !"".equals(altaJefe.getText())) {
            String clave_depto = altaClave.getText();
            boolean banDepto;
            banDepto = depto_db.regresaDepto(clave_depto);
            if (banDepto) {
                JOptionPane.showMessageDialog(null, "El departamento con la clave proporcionada ya existe","",JOptionPane.ERROR_MESSAGE);
            } else {
                Departamento d = new Departamento();
                d.setClaveDepto(altaClave.getText());
                d.setNombre(altaNombre.getText());
                d.setJefe(altaJefe.getText());
                depto_db.altaDepto(d);
                JOptionPane.showMessageDialog(null, "El departamento fue dado de alta con éxito","",JOptionPane.INFORMATION_MESSAGE);
            }
            altaClave.setText("");
            altaNombre.setText("");
            altaJefe.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Porfavor, ingresa toda la información","",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_altaDepartamentoActionPerformed

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
            java.util.logging.Logger.getLogger(Alta_Depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alta_Depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alta_Depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alta_Depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alta_Depto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField altaClave;
    private javax.swing.JButton altaDepartamento;
    private javax.swing.JTextField altaJefe;
    private javax.swing.JTextField altaNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton regresar_MenuDepto;
    // End of variables declaration//GEN-END:variables

}
