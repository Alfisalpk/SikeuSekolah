/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.alfisal.sikeusekolah;
import com.alfisal.sikeusekolah.form.DialogLogin;
import com.alfisal.sikeusekolah.form.FormUtama;

/**
 *
 * @author ALFISAL-PUNJUNG
 */
public class SikeuSekolah {
    public static void main(String[] args) {
System.out.println("Menjalankan aplikasi SIKEU - Sekolah");
FormUtama tampilanUtama = new FormUtama();
DialogLogin tampilanLogin = new DialogLogin(tampilanUtama,true);
tampilanLogin.setVisible(true);
}
    
}
