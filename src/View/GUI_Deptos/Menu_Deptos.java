
package View.GUI_Deptos;

import View.GUI_MenuPrincipal.Menu_Principal;

/**
 *
 * @author alexis
 */
public class Menu_Deptos extends javax.swing.JFrame {

    /**
     * Creates new form Departamentos
     */
    public Menu_Deptos() {
        initComponents();
        this.setTitle("Control de Departamentos");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        regresar_Menu = new javax.swing.JButton();
        altaDepto = new javax.swing.JButton();
        verDeptos = new javax.swing.JButton();
        bajaDepto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menú Departamentos");

        regresar_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actualizar.png"))); // NOI18N
        regresar_Menu.setText("Regresar a Menú");
        regresar_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar_MenuActionPerformed(evt);
            }
        });

        altaDepto.setText("Alta de Departamentos");
        altaDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaDeptoActionPerformed(evt);
            }
        });

        verDeptos.setText("Consulta de Departamentos");
        verDeptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDeptosActionPerformed(evt);
            }
        });

        bajaDepto.setText("Baja de Departamentos");
        bajaDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaDeptoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regresar_Menu)
                    .addComponent(bajaDepto)
                    .addComponent(verDeptos)
                    .addComponent(altaDepto)
                    .addComponent(jLabel1))
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(altaDepto)
                .addGap(18, 18, 18)
                .addComponent(verDeptos)
                .addGap(18, 18, 18)
                .addComponent(bajaDepto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(regresar_Menu)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresar_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar_MenuActionPerformed
        new Menu_Principal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_regresar_MenuActionPerformed

    private void altaDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaDeptoActionPerformed
        new Alta_Depto().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_altaDeptoActionPerformed

    private void verDeptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDeptosActionPerformed
        new Consultar_Deptos().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_verDeptosActionPerformed

    private void bajaDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaDeptoActionPerformed
        new Baja_Depto().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bajaDeptoActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Deptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Deptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Deptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Deptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Deptos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton altaDepto;
    private javax.swing.JButton bajaDepto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton regresar_Menu;
    private javax.swing.JButton verDeptos;
    // End of variables declaration//GEN-END:variables
}
