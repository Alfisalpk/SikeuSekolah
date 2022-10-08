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
public class FormSiswa extends javax.swing.JInternalFrame {
Koneksi kon;
ResultSet rs;
String mode;
    /**
     * Creates new form FormJurusan
     */
    public FormSiswa() {
        initComponents();
        kon = new Koneksi();
        tampilData("");
        cbangkatan();
        cbjurusan();
        cbkelas();
    }
    public void cbangkatan(){
     try{
         String sql="select * from angkatan";
         rs = kon.perintah.executeQuery(sql);
         cbangkatan.addItem("-Pilih Angkatan-");
         while (rs.next()) {
             cbangkatan.addItem(rs.getString("tahun"));
         }
        }catch(Exception e){
            System.err.println("Gagal Tampil data: "+e.getMessage());
       }
    }
    
    public void cbjurusan(){
     try{
         String sql="select * from jurusan";
         rs = kon.perintah.executeQuery(sql);
         cbjurusan.addItem("-Pilih Jurusan-");
         while (rs.next()) {
             cbjurusan.addItem(rs.getString("nama_jurusan"));
         }
        }catch(Exception e){
            System.err.println("Gagal Tampil data: "+e.getMessage());
       }
    }
    
    public void cbkelas(){
     try{
         String sql="select * from kelas";
         rs = kon.perintah.executeQuery(sql);
         cbkelas.addItem("-Pilih Kelas-");
         while (rs.next()) {
             cbkelas.addItem(rs.getString("kode_kelas"));
         }
        }catch(Exception e){
            System.err.println("Gagal Tampil data: "+e.getMessage());
       }
    }
    
    
    
private void tampilData(String filter){
    Object[] judulKolom = {"No","ID","NIS","Nama","Angkatan","Jurusan","Kelas","No HP","DU","Status"};
    DefaultTableModel modelAkun= new DefaultTableModel(null, judulKolom);
    tabelData.setModel(modelAkun);
    
    try{
        String sql = "select * from siswa where id like '%"+filter+"' or nis like '%"+filter+"%' ";
        rs = kon.perintah.executeQuery(sql);
        int no = 0;
        while (rs.next()){
            no++;
            String txtId = rs.getString("id");
            String txtNis = rs.getString("nis");
            String txtNama = rs.getString("nama");
            String txtAngkatan = rs.getString("angkatan");
            String txtJurusan = rs.getString("jurusan");
            String txtKelas= rs.getString("Kelas");
            String txtNohp = rs.getString("no_hp");
            String txtDu = rs.getString("du");
            String txtStatus = rs.getString("status");
            
            String[] barisBaru = {Integer.toString(no), txtId, txtNis, txtNama, txtAngkatan, txtJurusan, txtKelas, txtNohp, txtDu, txtStatus};
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
        nis = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nohp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        du = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        cbangkatan = new javax.swing.JComboBox<>();
        cbjurusan = new javax.swing.JComboBox<>();
        cbkelas = new javax.swing.JComboBox<>();
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

        jLabel3.setText("NIS");

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

        jLabel5.setText("Angkatan");

        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama");

        jLabel7.setText("Jurusan");

        jLabel8.setText("Kelas");

        jLabel9.setText("No HP");

        jLabel10.setText("DU");

        jLabel11.setText("Password");

        jLabel12.setText("Status");

        javax.swing.GroupLayout dialogFormLayout = new javax.swing.GroupLayout(dialogForm.getContentPane());
        dialogForm.getContentPane().setLayout(dialogFormLayout);
        dialogFormLayout.setHorizontalGroup(
            dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogFormLayout.createSequentialGroup()
                                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(38, 38, 38)
                                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(nis)))
                            .addGroup(dialogFormLayout.createSequentialGroup()
                                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10))
                                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogFormLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbjurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(dialogFormLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nohp, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(status, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                                                    .addComponent(du, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(cbkelas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cbangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 80, Short.MAX_VALUE))
                    .addComponent(simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dialogFormLayout.setVerticalGroup(
            dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogFormLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbkelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbjurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(nohp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(du, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 328, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 328, Short.MAX_VALUE)))
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
        String txtNis = nis.getText();
        String txtNama = nama.getText();
        String txtAngkatan = String.valueOf(cbangkatan.getSelectedItem());
        String txtJurusan =  String.valueOf(cbjurusan.getSelectedItem());
        String txtKelas =  String.valueOf(cbkelas.getSelectedItem());
        String txtNohp = nohp.getText();
        String txtDu = du.getText();
        String txtPassword = password.getText();
        String txtStatus = status.getText();
        String sql= "";

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        String waktu_sekarang = now.format(format);

        if("tambah".equals(mode)){
            sql = "insert into siswa values("
            + "'" + txtId + "',"
            + "'" + txtNis + "',"
            + "'" + txtNama + "',"
            + "'" + txtAngkatan + "',"
            + "'" + txtJurusan + "',"
            + "'" + txtKelas + "',"
            + "'" + txtNohp + "',"
            + "'" + txtDu + "',"
            + "'" + txtPassword + "',"
            + "'" + txtStatus + "',"
            + "'" + waktu_sekarang + "',"
            + "'" + waktu_sekarang + "',"
            + "null" + ")";
        } else {
            sql = "update siswa set nis='"+txtNis+"',"
            + "nama='"+txtNama+"',"
            + "angkatan='"+txtAngkatan+"',"
            + "jurusan='"+txtJurusan+"',"
            + "kelas='"+txtKelas+"',"
            + "no_hp='"+txtNohp+"',"
            + "du='"+txtDu+"',"
            + "password='"+txtPassword+"',"
            + "status='"+txtStatus+"',"
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
        nis.setText(null);
  
        nis.setText(null);
        nama.setText(null);
        cbangkatan.setSelectedItem(null);
        cbjurusan.setSelectedItem(null);
        cbkelas.setSelectedItem(null);
        nohp.setText(null);
        password.setText(null);
        du.setText(null);
        status.setText(null);
        id.setEnabled(true);
        dialogForm.setTitle("Form Jurusan - Tambah");
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
                String sql="select * from siswa where id ='"+id_pilih+"'";
                rs = kon.perintah.executeQuery(sql);
                if (rs.next()){
                    String txtId =rs.getString("id");
                    String txtNis =rs.getString("nis");
                    String txtNama =rs.getString("nama");
                    String txtAngkatan =rs.getString("angkatan");
                    String txtJurusan =rs.getString("jurusan");
                    String txtKelas =rs.getString("kelas");
                    String txtNohp =rs.getString("no_hp");
                    String txtDu =rs.getString("du");
                    String txtPassword =rs.getString("password");
                    String txtStatus =rs.getString("status");
                    id.setText(txtId);
                    nis.setText(txtNis);
                    nama.setText(txtNama);
                    cbangkatan.setSelectedItem(txtAngkatan);
                    cbjurusan.setSelectedItem(txtJurusan);
                    cbkelas.setSelectedItem(txtKelas);
                    nohp.setText(txtNohp);
                    password.setText(txtDu);
                    du.setText(txtPassword);
                    status.setText(txtStatus);

                    id.setEnabled(false);
                    dialogForm.setTitle("Form Jurusan - Ubah");
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
                    String sql="delete from siswa where id='"+id_pilih+"'";
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

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cari;
    private javax.swing.JTextField Cari1;
    private javax.swing.JComboBox<String> cbangkatan;
    private javax.swing.JComboBox<String> cbjurusan;
    private javax.swing.JComboBox<String> cbkelas;
    private javax.swing.JDialog dialogForm;
    private javax.swing.JTextField du;
    private javax.swing.JButton hapus;
    private javax.swing.JButton hapus1;
    private javax.swing.JTextField id;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nis;
    private javax.swing.JTextField nohp;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField status;
    private javax.swing.JTable tabelData;
    private javax.swing.JTable tabelData1;
    private javax.swing.JButton tambah;
    private javax.swing.JButton tambah1;
    private javax.swing.JButton ubah;
    private javax.swing.JButton ubah1;
    // End of variables declaration//GEN-END:variables
}
