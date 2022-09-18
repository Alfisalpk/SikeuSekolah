/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alfisal.sikeusekolah;

/**
 *
 * @author ALFISAL-PUNJUNG
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
    public Connection konekDB;
    public Statement perintah;
   
    
public Koneksi(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/javadb";
        String user = "root";
        String pass = "";
        konekDB = DriverManager.getConnection(url, user, pass);
        perintah = konekDB.createStatement();
        System.out.println("Berhasil Terhubung");
    } catch (SQLException salahe) {
        JOptionPane.showMessageDialog(null, "Gagala Terhubung Database");
        System.err.println("Gagal Koneksi: "+salahe.getMessage());
        
    } catch (ClassNotFoundException salahe) {
        System.err.println("Class Tidak Ditemukan: "+salahe.getMessage());
    }
}

}
