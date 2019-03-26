/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectanggota.ui;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projectanggota.model.Anggota;
import projectanggota.service.AnggotaClient;

/**
 *
 * @author PKane_NS
 */
public class home extends javax.swing.JFrame {
    public static AnggotaClient client = new AnggotaClient();
    DefaultTableModel tabModel =new DefaultTableModel();
    /**
     * Creates new form home
     */
    public home() {
        initComponents();
        runTime();
    }
    void runTime(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                showData();
            }
        }, 0, 6000);
    }
    void showData(){
        List<Anggota> anggotas = client.getAnggotas();
        Object[] column = {"ID", "NAMA", "NIM"};
        Object[][] data = new Object[anggotas.size()][3];
        int i =0;
        for (Anggota a: anggotas) {
            Object[] arr_data = {a.getId(), a.getNama(), a.getNim()};
            data[i] = arr_data;
            i++;
        }
        tabModel = new DefaultTableModel(data, column);
        tableAnggota.setModel(tabModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAnggota = new javax.swing.JTable();
        bHapus = new javax.swing.JButton();
        tfId = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        tfNim = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bSimpan = new javax.swing.JButton();
        bKepo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableAnggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableAnggota);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 356, 210));

        bHapus.setText("HAPUS");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });
        getContentPane().add(bHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, -1));

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });
        getContentPane().add(tfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 120, -1));
        getContentPane().add(tfNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 120, -1));
        getContentPane().add(tfNim, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 120, -1));

        jLabel1.setText("NIM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel3.setText("NAMA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        bSimpan.setText("SIMPAN");
        bSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSimpanMouseClicked(evt);
            }
        });
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(bSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        bKepo.setText("KEPO");
        bKepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKepoActionPerformed(evt);
            }
        });
        getContentPane().add(bKepo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Semoga membantu buat belajar.. Semangat :D");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 360, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        int iTable = tableAnggota.getSelectedRow();
        if (iTable == -1) {
            return;
        }
        long id = Long.parseLong(tableAnggota.getValueAt(iTable, 0).toString());
        JOptionPane.showMessageDialog(null, client.deleteAnggota(id));
        // TODO add your handling code here:
    }//GEN-LAST:event_bHapusActionPerformed

    private void bSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSimpanMouseClicked
        
        // TODO add your handling code here:
    }//GEN-LAST:event_bSimpanMouseClicked

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        try {
            String nama = tfNama.getText();
            String nim = tfNim.getText();
            Anggota anggota = new Anggota();
            JOptionPane.showMessageDialog(null, client.saveAnggota(nama, nim));            
            tfId.setText("");
            tfNama.setText("");
            tfNim.setText("");
        } catch (Exception e) {
        }
// TODO add your handling code here:
    }//GEN-LAST:event_bSimpanActionPerformed

    private void bKepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKepoActionPerformed
        KepoDialog kd = new KepoDialog(this, true);
        kd.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_bKepoActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bKepo;
    private javax.swing.JButton bSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAnggota;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNim;
    // End of variables declaration//GEN-END:variables
}