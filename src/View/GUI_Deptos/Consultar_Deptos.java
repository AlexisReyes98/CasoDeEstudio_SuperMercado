
package View.GUI_Deptos;

import ConectionSQL.Deptos_DB;
import Model.Departamento;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexis
 */
public class Consultar_Deptos extends javax.swing.JFrame {
    Deptos_DB depto_db = new Deptos_DB();

    /**
     * Creates new form Consultar_Deptos
     */
    public Consultar_Deptos() {
        initComponents();
        this.setTitle("Control de Departamentos");
        this.setLocationRelativeTo(null);
    }
    
    public void listarDatos() { // Con esta función se muestra la tabla
        ArrayList<Departamento> deptos;
        deptos = depto_db.consultarDeptos();
        DefaultTableModel tb = (DefaultTableModel)tablaDeptos.getModel();
        for(Departamento d: deptos) {
            tb.addRow(new Object[]{d.getClaveDepto(),d.getNombre(),d.getJefe()});
        }
    }
    
    public void limpiarFormulario() {   // Con esta función se limpia la tabla
        DefaultTableModel tb = (DefaultTableModel)tablaDeptos.getModel();
        for (int i=tb.getRowCount()-1; i>=0; i--)
            tb.removeRow(i);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDeptos = new javax.swing.JTable();
        verDeptos = new javax.swing.JButton();
        regresar_MenuDepto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Consulta de departamentos:");

        tablaDeptos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Clave Departamento", "Nombre", "Jefe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDeptos);

        verDeptos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Lupa.png"))); // NOI18N
        verDeptos.setText("Consulta de Departamentos");
        verDeptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDeptosActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(regresar_MenuDepto)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(verDeptos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel1)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(verDeptos)
                .addGap(30, 30, 30)
                .addComponent(regresar_MenuDepto)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verDeptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDeptosActionPerformed
        limpiarFormulario();
        listarDatos();
    }//GEN-LAST:event_verDeptosActionPerformed

    private void regresar_MenuDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar_MenuDeptoActionPerformed
        new Menu_Deptos().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_regresar_MenuDeptoActionPerformed

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
            java.util.logging.Logger.getLogger(Consultar_Deptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultar_Deptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultar_Deptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultar_Deptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultar_Deptos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar_MenuDepto;
    private javax.swing.JTable tablaDeptos;
    private javax.swing.JButton verDeptos;
    // End of variables declaration//GEN-END:variables
}
