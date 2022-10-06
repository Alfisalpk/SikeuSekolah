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
public class FormBiayaPmb extends javax.swing.JInternalFrame {
Koneksi kon;
ResultSet rs;
String mode;
    /**
     * Creates new form FormJurusan
     */
    public FormBiayaPmb() {
        initComponents();
        kon = new Koneksi();
        tampilData("");
    }
private void tampilData(String filter){
    Object[] judulKolom = {"No","ID","Akun ID","Nama Biaya","Jumlah","Tahun Angkatan","Gelombang","Jurusan"};
    DefaultTableModel modelAkun= new DefaultTableModel(null, judulKolom);
    tabelData.setModel(modelAkun);
    
    try{
        String sql = "select * from biaya_pmb where id like '%"+filter+"' or akun_id like '%"+filter+"%' ";
        rs = kon.perintah.executeQuery(sql);
        int no = 0;
        while (rs.next()){
            no++;
            String txtId = rs.getString("id");
            String txtAkun_id = rs.getString("akun_id");
            String txtNama_biaya = rs.getString("nama_biaya");
            String txtJumlah = rs.getString("jumlah");
            String txtTahun_angkatan = rs.getString("tahun_angkatan");
            String txtGelombang= rs.getString("gelombang");
            String txtJurusan = rs.getString("jurusan");
            
            
            String[] barisBaru = {Integer.toString(no), txtId, txtAkun_id, txtNama_biaya, txtJumlah, txtTahun_angkatan, txtGelombang, txtJurusan};
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
        id = new javax.swing.JTextField();
        akun_id = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nama_biaya = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        gelombang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tahun_angkatan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jurusan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        Cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        tambah1 = new javax.swing.JButton();
        ubah1 = new javax.swing.JButton();
        hapus1 = new javax.swing.JButton();
        Cari1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelData1 = new javax.swing.JTable();

        jLabel2.setText("ID");

        jLabel3.setText("Akun ID");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        jLabel5.setText("Jumlah");

        nama_biaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_biayaActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama Biaya");

        jLabel7.setText("Tahun Angkatan");

        tahun_angkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahun_angkatanActionPerformed(evt);
            }
        });

        jLabel8.setText("Gelombang");

        jLabel9.setText("Jurusan");

        javax.swing.GroupLayout dialogFormLayout = new javax.swing.GroupLayout(dialogForm.getContentPane());
        dialogForm.getContentPane().setLayout(dialogFormLayout);
        dialogFormLayout.setHorizontalGroup(
            dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(id)
                                .addComponent(akun_id)
                                .addComponent(nama_biaya, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(gelombang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                .addComponent(tahun_angkatan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jurusan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jumlah)))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addComponent(simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dialogFormLayout.setVerticalGroup(
            dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogFormLayout.createSequentialGroup()
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogFormLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(akun_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nama_biaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(tahun_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gelombang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(18, 18, 18)
                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        setClosable(true);

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

        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        jLabel1.setText("CARI");

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

        Cari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cari1ActionPerformed(evt);
            }
        });

        jLabel4.setText("CARI");

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

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(tambah1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ubah1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapus1)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cari1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah1)
                    .addComponent(ubah1)
                    .addComponent(hapus1)
                    .addComponent(jLabel4)
                    .addComponent(Cari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapus)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(ubah)
                    .addComponent(hapus)
                    .addComponent(jLabel1)
                    .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        String txtId = id.getText();
        String txtAkun_id = akun_id.getText();
        String txtNama_biaya = nama_biaya.getText();
        String txtJumlah = jumlah.getText();
        String txtTahun_angkatan = tahun_angkatan.getText();
        String txtGelombang= gelombang.getText();
        String txtJurusan = jurusan.getText();
        
        String sql= "";

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        String waktu_sekarang = now.format(format);

        if("tambah".equals(mode)){
            sql = "insert into biaya_pmb values("
            + "'" + txtId + "',"
            + "'" + txtAkun_id + "',"
            + "'" + txtNama_biaya + "',"
            + "'" + txtJumlah + "',"
            + "'" + txtTahun_angkatan + "',"
            + "'" + txtGelombang + "',"
            + "'" + txtJurusan + "',"
            
            + "'" + waktu_sekarang + "',"
            + "'" + waktu_sekarang + "',"
            + "null" + ")";
        } else {
            sql = "update biaya_pmb set akun_id='"+txtAkun_id+"',"
            + "nama_biaya='"+txtNama_biaya+"',"
            + "jumlah='"+txtJumlah+"',"
            + "tahun_angkatan='"+txtTahun_angkatan+"',"
            + "gelombang='"+txtGelombang+"',"
            + "jurusan='"+txtJurusan+"',"
            
            + "updated_at='"+waktu_sekarang+"'"
            + "where id='"+txtId+"'";

        } try {
            kon.perintah.execute(sql);
            dialogForm.setVisible(false);
            tampilData("");

        } catch(SQLException salahe) {
            System.err.println("Gagal Simpan Data : "+salahe.getMessage());
            JOptionPane.showMessageDialog(this, "Gagal Simpan");
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        mode="tambah";
        akun_id.setText(null);
  
        akun_id.setText(null);
        nama_biaya.setText(null);
        jumlah.setText(null);
        tahun_angkatan.setText(null);
        gelombang.setText(null);
        jurusan.setText(null);
        
        id.setEnabled(true);
        dialogForm.setTitle("Form Biaya PMB - Tambah");
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
                String sql="select * from biaya_pmb where id ='"+id_pilih+"'";
                rs = kon.perintah.executeQuery(sql);
                if (rs.next()){
                    String txtId =rs.getString("id");
                    String txtAkun_id =rs.getString("akun_id");
                    String txtNama_biaya =rs.getString("nama_biaya");
                    String txtJumlah =rs.getString("Jumlah");
                    String txtTahun_angkatan =rs.getString("tahun_angkatan");
                    String txtGelombang=rs.getString("gelombang");
                    String txtJurusan =rs.getString("jurusan");
                    
                    id.setText(txtId);
                    akun_id.setText(txtAkun_id);
                    nama_biaya.setText(txtNama_biaya);
                    jumlah.setText(txtJumlah);
                    tahun_angkatan.setText(txtTahun_angkatan);
                    gelombang.setText(txtGelombang);
                    jurusan.setText(txtJurusan);
                    

                    id.setEnabled(false);
                    dialogForm.setTitle("Form Biaya PMB - Ubah");
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
                    String sql="delete from biaya_pmb where id='"+id_pilih+"'";
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

    private void nama_biayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_biayaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_biayaActionPerformed

    private void tahun_angkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahun_angkatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahun_angkatanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cari;
    private javax.swing.JTextField Cari1;
    private javax.swing.JTextField akun_id;
    private javax.swing.JDialog dialogForm;
    private javax.swing.JTextField gelombang;
    private javax.swing.JButton hapus;
    private javax.swing.JButton hapus1;
    private javax.swing.JTextField id;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField jurusan;
    private javax.swing.JTextField nama_biaya;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabelData;
    private javax.swing.JTable tabelData1;
    private javax.swing.JTextField tahun_angkatan;
    private javax.swing.JButton tambah;
    private javax.swing.JButton tambah1;
    private javax.swing.JButton ubah;
    private javax.swing.JButton ubah1;
    // End of variables declaration//GEN-END:variables
}
