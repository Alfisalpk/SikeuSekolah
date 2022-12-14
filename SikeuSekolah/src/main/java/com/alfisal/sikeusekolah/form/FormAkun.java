/*
 * Aplikasi ini dibuat oleh: Alfisal PUnjung Kurniawan.Com
 * Sistem Informasi - Universitas Duta Bangsa
 */
package com.alfisal.sikeusekolah.form;
import com.alfisal.sikeusekolah.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ALFISAL-PUNJUNG
 */
public class FormAkun extends javax.swing.JInternalFrame {
Koneksi kon;
ResultSet rs;
String mode;
    /**
     * Creates new form FormAkun
     */
    public FormAkun() {
        initComponents();
        kon = new Koneksi();
        tampilData("");
        
    }
private void tampilData(String filter){
    Object[] judulKolom = {"No","Kode","Nama Akun"};
    DefaultTableModel modelAkun= new DefaultTableModel(null, judulKolom);
    tabelData.setModel(modelAkun);
    
    try{
        String sql = "select * from akun where kode like '%"+filter+"' or nama_akun like '%"+filter+"%' ";
        rs = kon.perintah.executeQuery(sql);
        int no = 0;
        while (rs.next()){
            no++;
            String txtKode = rs.getString("kode");
            String txtNama_akun = rs.getString("nama_akun");
            String[] barisBaru = {Integer.toString(no), txtKode, txtNama_akun};
            modelAkun.addRow(barisBaru);
        }
    } catch(SQLException salahe){
        System.err.println("Gagal Tampil dat : "+salahe.getMessage());
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogForm = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
        nama_akun = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Cari = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelData1 = new javax.swing.JTable();
        tambah1 = new javax.swing.JButton();
        ubah1 = new javax.swing.JButton();
        hapus1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Cari1 = new javax.swing.JTextField();

        jLabel2.setText("Kode");

        jLabel3.setText("Nama Akun");

        kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeActionPerformed(evt);
            }
        });

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogFormLayout = new javax.swing.GroupLayout(dialogForm.getContentPane());
        dialogForm.getContentPane().setLayout(dialogFormLayout);
        dialogFormLayout.setHorizontalGroup(
            dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(68, 68, 68)
                        .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(nama_akun, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        dialogFormLayout.setVerticalGroup(
            dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogFormLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nama_akun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        tabelData.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelData);

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        jLabel1.setText("CARI");

        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        tabelData1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelData1);

        tambah1.setText("Tambah");
        tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah1ActionPerformed(evt);
            }
        });

        ubah1.setText("Ubah");
        ubah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah1ActionPerformed(evt);
            }
        });

        hapus1.setText("Hapus");
        hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus1ActionPerformed(evt);
            }
        });

        jLabel4.setText("CARI");

        Cari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cari1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cari1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                            .addComponent(tambah1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ubah1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(hapus1))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah1)
                    .addComponent(ubah1)
                    .addComponent(hapus1))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Cari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tambah)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ubah)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(hapus))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(ubah)
                    .addComponent(hapus))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        mode="tambah";
        nama_akun.setText(null);
        kode.setEnabled(true);
        dialogForm.setTitle("Form Akun - Tambah");
        dialogForm.pack();
        dialogForm.setLocationRelativeTo(null);
        dialogForm.setLocationRelativeTo(null);
        dialogForm.setVisible(true);

    }//GEN-LAST:event_tambahActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        int baris_index = tabelData.getSelectedRow();
        if (baris_index>=0) {
            mode="ubah";
            String id_pilih =(tabelData.getModel().getValueAt(baris_index, 1).toString());
            try{
                String sql="select * from akun where kode='"+id_pilih+"'";
                rs = kon.perintah.executeQuery(sql);
                if (rs.next()){
                    String txtKode =rs.getString("kode");
                    String txtNama_akun =rs.getString("nama_akun");
                    kode.setText(txtKode);
                    nama_akun.setText(txtNama_akun);
                    
                    kode.setEnabled(false);
                    dialogForm.setTitle("Form Akun - Ubah");
                    dialogForm.pack();
                    dialogForm.setLocationRelativeTo(null);
                    dialogForm.setVisible(true);
                }
                
            }catch(SQLException salahe){
                System.err.println("Gagal Tampil data: "+salahe.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(this, "Belum ada data yang dipilih");
        }

    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        int baris_index = tabelData.getSelectedRow();
        if (baris_index>=0){
            int jwb = JOptionPane.showConfirmDialog(this, "Yakin mau hapus data ini?","Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jwb==JOptionPane.YES_OPTION){
                String id_pilih =(tabelData.getModel().getValueAt(baris_index, 1).toString());
                try{
                    String sql="delete from akun where kode='"+id_pilih+"'";
                    kon.perintah.execute(sql);
                    tampilData("");
                    
                }catch(SQLException salahe){
                    System.err.println("Gagal Hapus data : "+salahe.getMessage());
                    
                }
            }
        }else {
            JOptionPane.showMessageDialog(this, "Belum ada data yang dipilih");
            
        }

    }//GEN-LAST:event_hapusActionPerformed

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        // TODO add your handling code here:
        String txtCari = Cari.getText();
        tampilData(txtCari);
    }//GEN-LAST:event_CariActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        String txtKode = kode.getText();
        String txtNama_akun = nama_akun.getText();
        String sql= "";
    
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        String waktu_sekarang = now.format(format);
        
        if("tambah".equals(mode)){
            sql = "insert into akun values("
                    + "'" + txtKode + "',"
                    + "'" + txtNama_akun + "',"
                    + "'" + waktu_sekarang + "',"
                    + "'" + waktu_sekarang + "',"                   
                    + "null" + ")";
        } else {
            sql = "update akun set nama_akun='"+txtNama_akun+"',"
                + "updated_at='"+waktu_sekarang+"'"
                + "where kode='"+txtKode+"'";
                   
                    
        } try {
            kon.perintah.execute(sql);
            dialogForm.setVisible(false);
            tampilData("");
            
        } catch(SQLException salahe) {
            System.err.println("Gagal Simpan Data : "+salahe.getMessage());
            JOptionPane.showMessageDialog(this, "Gagal Simpan");
        }

    }//GEN-LAST:event_simpanActionPerformed

    private void kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeActionPerformed

    private void tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambah1ActionPerformed

    private void ubah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubah1ActionPerformed

    private void hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hapus1ActionPerformed

    private void Cari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cari1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cari1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cari;
    private javax.swing.JTextField Cari1;
    private javax.swing.JDialog dialogForm;
    private javax.swing.JButton hapus;
    private javax.swing.JButton hapus1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kode;
    private javax.swing.JTextField nama_akun;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabelData;
    private javax.swing.JTable tabelData1;
    private javax.swing.JButton tambah;
    private javax.swing.JButton tambah1;
    private javax.swing.JButton ubah;
    private javax.swing.JButton ubah1;
    // End of variables declaration//GEN-END:variables
}
