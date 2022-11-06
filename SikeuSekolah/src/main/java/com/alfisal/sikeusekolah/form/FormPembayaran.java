/*
 * Aplikasi ini dibuat oleh: Alfisal PUnjung Kurniawan.Com
 * Sistem Informasi - Universitas Duta Bangsa
 */
package com.alfisal.sikeusekolah.form;

import com.alfisal.sikeusekolah.Koneksi;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALFISAL-PUNJUNG
 */
public class FormPembayaran extends javax.swing.JInternalFrame {

    Koneksi kon;

    /**
     * Creates new form FormPembayaran
     */
    public FormPembayaran() {
        initComponents();
        kon = new Koneksi();
        tampilData("");
    }

    private void tampilData(String filter) {
        Object[] judulKolom = {"No Daftar", "NIS", "Nama", "Jurusan", "Total", "Keterangan"};
        DefaultTableModel model = new DefaultTableModel(null, judulKolom);
        tabelData.setModel(model);
        try {
            String sql = "select * from view_bayar where isnull(deletedAt) and ( nis like '%" + filter + "%' or nama like '%" + filter + "%' or keterangan like '%" + filter + "%' ) group by id";
            Statement perintah = kon.konekDB.createStatement();
            ResultSet rs = perintah.executeQuery(sql);
            while (rs.next()) {
                String txtNoDaftar = rs.getString("no_pend");
                String txtNis = rs.getString("nis");
                String txtNama = rs.getString("nama");
                String txtJurusan = rs.getString("nama_jurusan");
                String txtTotal = rs.getString("total");
                String txtKet = rs.getString("keterangan");
                String[] barisBaru = {txtNoDaftar, txtNis, txtNama, txtJurusan, txtTotal, txtKet};
                model.addRow(barisBaru);
            }
        } catch (Exception salahe) {
            System.err.println("Gagal Tampil data: " + salahe.getMessage());
        }
    }

    private void tampilDataSiswa(String filter) {
        Object[] judulKolom = {"No Daftar", "NIS", "Nama", "Jurusan", "Kelas"};
        DefaultTableModel modelSiswa = new DefaultTableModel(null, judulKolom);
        tabelDataSiswa.setModel(modelSiswa);
        try {
            String sql = "select * from view_siswa where nis like '%" + filter + "%' or nama like '%" + filter + "%' ";
            Statement perintah = kon.konekDB.createStatement();
            ResultSet rsSiswa = perintah.executeQuery(sql);
            while (rsSiswa.next()) {
                String txtNoDaftar = rsSiswa.getString("id");
                String txtNis = rsSiswa.getString("nis");
                String txtNama = rsSiswa.getString("nama");
                String txtJurusan = rsSiswa.getString("nama_jurusan");
                String txtKelas = rsSiswa.getString("kode_kelas");
                String[] barisBaru = {txtNoDaftar, txtNis, txtNama, txtJurusan, txtKelas};
                modelSiswa.addRow(barisBaru);
            }
        } catch (Exception salahe) {
            System.err.println("Gagal Tampil data: " + salahe.getMessage());
        }
    }

    private void tampilTagihan(String no_pend) {
        Object[] judulKolom = {"ID Biaya", "Nama Biaya", "Jumlah", "Dibayar", "Kekurangan"};
        DefaultTableModel modelTagihan = new DefaultTableModel(null, judulKolom);
        tabelTagihan.setModel(modelTagihan);
        System.out.println(no_pend);
        try {
            Statement perintah = kon.konekDB.createStatement();
//baca siswa
            String sql = "select * from siswa where id = '" + no_pend + "' ";
            ResultSet rsSiswa = perintah.executeQuery(sql);
            rsSiswa.next();
            String txtNoDaftar = rsSiswa.getString("id");
            String txtJurusan = rsSiswa.getString("jurusan");
            String txtAngkatan = rsSiswa.getString("angkatan");
//baca tagihan biaya psb
            String sqlBiayaPsb = "SELECT "
                    + "biaya_pmb.id AS id, "
                    + "biaya_pmb.nama_biaya AS nama_biaya, "
                    + "biaya_pmb.jumlah AS jumlah, "
                    + "COALESCE ( sum( view_bayar.jumlah_bayar ), 0 ) AS bayar, "
                    + "(biaya_pmb.jumlah - COALESCE ( sum( view_bayar.jumlah_bayar ), 0 )) AS kekurangan "
                    + "FROM "
                    + "biaya_pmb LEFT JOIN view_bayar ON ( "
                    + "view_bayar.biaya_id = biaya_pmb.id AND "
                    + "view_bayar.jenis_biaya = 'D' AND "
                    + "view_bayar.no_pend = '" + txtNoDaftar + "' "
                    + ") "
                    + "WHERE "
                    + "biaya_pmb.tahun_angkatan= '" + txtAngkatan + "' AND biaya_pmb.jurusan = '" + txtJurusan + "' "
                    + "GROUP BY biaya_pmb.id "
                    + "ORDER BY biaya_pmb.nama_biaya";
            ResultSet rsBiayaPsb = perintah.executeQuery(sqlBiayaPsb);
            while (rsBiayaPsb.next()) {
                String txtId = rsBiayaPsb.getString("id");
                String txtNamaBiaya = rsBiayaPsb.getString("nama_biaya");
                String txtJumlah = rsBiayaPsb.getString("jumlah");
                String txtBayar = rsBiayaPsb.getString("bayar");
                String txtKekurangan = rsBiayaPsb.getString("kekurangan");
                String[] barisBaru = {txtId, txtNamaBiaya, txtJumlah, txtBayar, txtKekurangan};
                modelTagihan.addRow(barisBaru);
            }
//baca tagihan biaya tetap
            String sqlBiayaTetap = "SELECT "
                    + "biaya_tetap.id AS id, "
                    + "biaya_tetap.nama_biaya AS nama_biaya, "
                    + "biaya_tetap.jumlah AS jumlah, "
                    + "COALESCE ( sum( view_bayar.jumlah_bayar ), 0 ) AS bayar, "
                    + "(biaya_tetap.jumlah - COALESCE ( sum( view_bayar.jumlah_bayar ), 0 )) AS kekurangan "
                    + "FROM "
                    + "biaya_tetap LEFT JOIN view_bayar ON ( "
                    + "view_bayar.biaya_id = biaya_tetap.id AND "
                    + "view_bayar.jenis_biaya = 'P' AND "
                    + "view_bayar.no_pend = '" + txtNoDaftar + "' "
                    + ") "
                    + "WHERE "
                    + "biaya_tetap.tahun_angkatan='" + txtAngkatan + "' AND biaya_tetap.jurusan= '" + txtJurusan + "' "
                    + "GROUP BY biaya_tetap.id "
                    + "ORDER BY biaya_tetap.nama_biaya";
            ResultSet rsBiayaTetap = perintah.executeQuery(sqlBiayaTetap);
            while (rsBiayaTetap.next()) {
                String txtId = rsBiayaTetap.getString("id");
                String txtNamaBiaya = rsBiayaTetap.getString("nama_biaya");
                String txtJumlah = rsBiayaTetap.getString("jumlah");
                String txtBayar = rsBiayaTetap.getString("bayar");
                String txtKekurangan = rsBiayaTetap.getString("kekurangan");
                String[] barisBaru = {txtId, txtNamaBiaya, txtJumlah, txtBayar, txtKekurangan};
                modelTagihan.addRow(barisBaru);
            }
//baca tagihan biaya lain
            String sqlBiayaLain = "SELECT "
                    + "biaya_lain.id AS id, "
                    + "biaya_lain.nama_biaya AS nama_biaya, "
                    + "biaya_lain.jumlah AS jumlah, "
                    + "COALESCE ( sum( view_bayar.jumlah_bayar ), 0 ) AS bayar, "
                    + "(biaya_lain.jumlah - COALESCE ( sum( view_bayar.jumlah_bayar ), 0 )) AS kekurangan "
                    + "FROM "
                    + "biaya_lain LEFT JOIN view_bayar ON ( "
                    + "view_bayar.biaya_id = biaya_lain.id AND "
                    + "view_bayar.jenis_biaya = 'L' AND "
                    + "view_bayar.no_pend = '" + txtNoDaftar + "' "
                    + ") "
                    + "WHERE "
                    + "biaya_lain.jurusan = '" + txtJurusan + "' "
                    + "GROUP BY biaya_lain.id "
                    + "ORDER BY biaya_lain.nama_biaya";
            ResultSet rsBiayaLain = perintah.executeQuery(sqlBiayaLain);
            while (rsBiayaLain.next()) {
                String txtId = rsBiayaLain.getString("id");
                String txtNamaBiaya = rsBiayaLain.getString("nama_biaya");
                String txtJumlah = rsBiayaLain.getString("jumlah");
                String txtBayar = rsBiayaLain.getString("bayar");
                String txtKekurangan = rsBiayaLain.getString("kekurangan");
                String[] barisBaru = {txtId, txtNamaBiaya, txtJumlah, txtBayar, txtKekurangan};
                modelTagihan.addRow(barisBaru);
            }
        } catch (Exception salahe) {
            System.err.println("Gagal Tampil data: " + salahe.getMessage());
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

        dialogSiswa = new javax.swing.JDialog();
        cariSiswa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelDataSiswa = new javax.swing.JTable();
        pilih = new javax.swing.JButton();
        dialogTransaksi = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelTagihan = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelBayar = new javax.swing.JTable();
        hapusBayar = new javax.swing.JButton();
        tambahBayar = new javax.swing.JButton();
        simpanBayar = new javax.swing.JButton();
        totalBayar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        detail = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        cariSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariSiswaActionPerformed(evt);
            }
        });

        jLabel2.setText("CARI");

        tabelDataSiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelDataSiswa);

        pilih.setText("Pilih");
        pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogSiswaLayout = new javax.swing.GroupLayout(dialogSiswa.getContentPane());
        dialogSiswa.getContentPane().setLayout(dialogSiswaLayout);
        dialogSiswaLayout.setHorizontalGroup(
            dialogSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogSiswaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(dialogSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dialogSiswaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(cariSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogSiswaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pilih)
                .addGap(53, 53, 53))
        );
        dialogSiswaLayout.setVerticalGroup(
            dialogSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogSiswaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(dialogSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pilih, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabelTagihan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabelTagihan);

        tabelBayar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tabelBayar);

        hapusBayar.setText("Hapus");

        tambahBayar.setText("Tambah");

        simpanBayar.setText("Bayar");

        totalBayar.setBackground(new java.awt.Color(255, 153, 153));
        totalBayar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalBayar.setText("0");
        totalBayar.setCaretColor(new java.awt.Color(153, 153, 255));
        totalBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogTransaksiLayout = new javax.swing.GroupLayout(dialogTransaksi.getContentPane());
        dialogTransaksi.getContentPane().setLayout(dialogTransaksiLayout);
        dialogTransaksiLayout.setHorizontalGroup(
            dialogTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTransaksiLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(dialogTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dialogTransaksiLayout.createSequentialGroup()
                        .addComponent(simpanBayar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dialogTransaksiLayout.createSequentialGroup()
                            .addComponent(tambahBayar)
                            .addGap(18, 18, 18)
                            .addComponent(hapusBayar))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        dialogTransaksiLayout.setVerticalGroup(
            dialogTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTransaksiLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hapusBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setClosable(true);
        setTitle("Transaksi Pembayaran");

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

        detail.setText("Detail");

        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        jLabel1.setText("Cari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(detail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        tampilDataSiswa("");
        dialogSiswa.pack();
        dialogSiswa.setLocationRelativeTo(null);
        dialogSiswa.setModal(true);
        dialogSiswa.setVisible(true);
    }//GEN-LAST:event_tambahActionPerformed

    private void pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihActionPerformed
        // TODO add your handling code here:
        int baris_index = tabelDataSiswa.getSelectedRow();
        if (baris_index >= 0) {
            String no_pend = (tabelDataSiswa.getModel().getValueAt(baris_index, 0).toString());
            String nis = (tabelDataSiswa.getModel().getValueAt(baris_index, 1).toString());
            String nama = (tabelDataSiswa.getModel().getValueAt(baris_index, 2).toString());
            tampilTagihan(no_pend);
            dialogSiswa.setVisible(false);
            dialogTransaksi.setTitle("Transaksi: " + nis + " - " + nama);
            dialogTransaksi.pack();
            dialogTransaksi.setLocationRelativeTo(null);
            dialogTransaksi.setModal(true);
            dialogTransaksi.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(dialogSiswa, "Belum ada data yang dipilih");
        }
    }//GEN-LAST:event_pilihActionPerformed

    private void totalBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalBayarActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        String txtCari = cari.getText();
        tampilData(txtCari);
    }//GEN-LAST:event_cariActionPerformed

    private void cariSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariSiswaActionPerformed
        // TODO add your handling code here:
        String txtCari = cariSiswa.getText();
        tampilDataSiswa(txtCari);
    }//GEN-LAST:event_cariSiswaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JTextField cariSiswa;
    private javax.swing.JButton detail;
    private javax.swing.JDialog dialogSiswa;
    private javax.swing.JDialog dialogTransaksi;
    private javax.swing.JButton hapusBayar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton pilih;
    private javax.swing.JButton simpanBayar;
    private javax.swing.JTable tabelBayar;
    private javax.swing.JTable tabelData;
    private javax.swing.JTable tabelDataSiswa;
    private javax.swing.JTable tabelTagihan;
    private javax.swing.JButton tambah;
    private javax.swing.JButton tambahBayar;
    private javax.swing.JTextField totalBayar;
    // End of variables declaration//GEN-END:variables
}
