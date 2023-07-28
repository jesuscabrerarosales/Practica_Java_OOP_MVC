package view;

import controller.ControladorPedido;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Pedido;

public class CRUD_Pedidos extends javax.swing.JFrame {
    ControladorPedido model=new ControladorPedido();
    int idSeleccionado=-1;
    public CRUD_Pedidos() {
        initComponents();
        listaPedido();
    }
    void cerrar(){
        System.exit(0);
    }
    void limpiar(){
        txtNombre.setText("");
        txtPrecio.setText("");
        txtNombre.requestFocus();
    }
    public void listaPedido(){
        List<Pedido>data=model.listaPedido();
        DefaultTableModel dtm=(DefaultTableModel)table.getModel();
        dtm.setRowCount(0);
        for (Pedido c:data) {
            Object[]fila={ c.getIdPedido(),
                           c.getNombrePedido(),
                           c.getPrecio()};
            dtm.addRow(fila);
        }
        dtm.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mantenimiento de Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 0, 294, 68));

        jLabel2.setText("Nombre_Pedido:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 77, -1, -1));

        jLabel3.setText("Precio");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 126, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 74, 252, -1));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 123, 69, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 172, -1, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 172, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 172, -1, -1));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 172, -1, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre_Pedido", "Precio"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 213, -1, 201));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nom=txtNombre.getText().trim();
        double Precio=Double.parseDouble(txtPrecio.getText());
        Pedido obj=new Pedido();
        obj.setNombrePedido(nom);
        obj.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
        model.insertarPedido(obj);
        limpiar();
        listaPedido();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String nom=txtNombre.getText().trim();
        double Precio=Double.parseDouble(txtPrecio.getText());
        Pedido obj=new Pedido();
        obj.setIdPedido(idSeleccionado);
        obj.setNombrePedido(nom);
        obj.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
        model.actualizarPedidos(obj);
        listaPedido();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       model.eliminarPedido(idSeleccionado);
       listaPedido();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int fila=table.getSelectedRow();
        DefaultTableModel dtm=(DefaultTableModel)table.getModel();
        idSeleccionado=(Integer)dtm.getValueAt(fila, 0);
        String nom=(String)dtm.getValueAt(fila, 1);
        double Precio=(Double)dtm.getValueAt(fila, 2);
        txtNombre.setText(nom);
        txtPrecio.setText(String.valueOf(Precio));
    }//GEN-LAST:event_tableMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        cerrar();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD_Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
