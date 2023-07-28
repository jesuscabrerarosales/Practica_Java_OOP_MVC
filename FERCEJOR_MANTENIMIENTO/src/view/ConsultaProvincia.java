package view;

import controller.ControladorClientes;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Clientes;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author user
 */
public class ConsultaProvincia extends javax.swing.JFrame {

    ControladorClientes model = new ControladorClientes();
    Clientes cl= new Clientes();
    public ConsultaProvincia() {
        initComponents();
        listaClientes();
    }

    private void listaClientes() {
        List<Clientes> data = model.listaClientes();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        for (Clientes c : data) {
            Object[] fila = {c.getIdClientes(),
                c.getNombrecliente(),
                c.getRuc(),
                c.getDireccion(),
                c.getProvincia()};
            dtm.addRow(fila);
        }

        dtm.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxProvincia = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Buenos Aires", "Catamarca", "Chaco", "Chubut", "Ciudad Autónoma de Buenos Aires", "Córdoba", "Corrientes", "Entre Ríos", "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", "Río Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero", "Tierra del Fuego", "Antártida e Islas del Atlántico Sur", "Tucumán" }));
        cbxProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProvinciaItemStateChanged(evt);
            }
        });
        cbxProvincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxProvinciaMouseClicked(evt);
            }
        });
        cbxProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvinciaActionPerformed(evt);
            }
        });

        jLabel1.setText("Provincias");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idCliente", "NombreCliente", "RUC", "Dirección", "Provincia"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Consulta Clientes por Provincia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void cbxProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvinciaActionPerformed
        
        List<Clientes>data=model.buscarProvincia(cl.getProvincia().toString());
        DefaultTableModel dataTable=(DefaultTableModel)table.getModel();
        dataTable.setRowCount(0);
        for (Clientes c:data) {
            Object[] fila={c.getIdClientes(),
                           c.getNombrecliente(),
                           c.getRuc(),
                           c.getDireccion(),
                           c.getProvincia()
            };
            dataTable.addRow(fila);
        }
        dataTable.fireTableDataChanged();
    }//GEN-LAST:event_cbxProvinciaActionPerformed

    private void cbxProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxProvinciaMouseClicked

        try {
            String prov = (String) cbxProvincia.getSelectedItem().toString();
            ControladorClientes m = new ControladorClientes();
            List<Clientes> data = m.buscarClientes(prov);
            DefaultTableModel dataTable = (DefaultTableModel) table.getModel();
            dataTable.setRowCount(0);
            for (Clientes c : data) {
                Object[] fila = {c.getIdClientes(),
                    c.getNombrecliente(),
                    c.getRuc(),
                    c.getDireccion(),
                    c.getProvincia()};
                dataTable.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
     }//GEN-LAST:event_cbxProvinciaMouseClicked

    private void cbxProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProvinciaItemStateChanged
try {
            String prov = (String) cbxProvincia.getSelectedItem().toString();
            ControladorClientes m = new ControladorClientes();
            List<Clientes> data = m.buscarClientes(prov);
            DefaultTableModel dataTable = (DefaultTableModel) table.getModel();
            dataTable.setRowCount(0);
            for (Clientes c : data) {
                Object[] fila = {c.getIdClientes(),
                    c.getNombrecliente(),
                    c.getRuc(),
                    c.getDireccion(),
                    c.getProvincia()};
                dataTable.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProvinciaItemStateChanged

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
            java.util.logging.Logger.getLogger(ConsultaProvincia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaProvincia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaProvincia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaProvincia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaProvincia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
