/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTSA_indah170523.model;

/**
 *
 * @author A409FA
 */
public class Pelanggan {
    private String kodePelanggan;
    private String nama;
    private String meterBulanIni;
    private String meterBulanLalu;
    private String tarif;
    private String diskon;
    
    public Pelanggan(String kodePelanggan, String nama, String meterBulanIni, String meterBulanLalu, String tarif, String diskon){
        this.kodePelanggan = kodePelanggan;
        this.nama = nama;
        this.meterBulanIni = meterBulanIni;
        this.meterBulanLalu = meterBulanLalu;
        this.tarif = tarif;
        this.diskon = diskon;
    }
    
    public void setkodePelanggan(String kodepelanggan){
        this.kodePelanggan = kodepelanggan; 
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setmeterBulanIni(String meterbulanini){
        this.meterBulanIni = meterbulanini;
    }
    public void setmeterBulanLalu(String meterbulanlalu){
        this.meterBulanLalu = meterbulanlalu;
    }
    public void setTarif(String tarif){
        this.tarif = tarif;
    }
    public void setDiskon(String diskon){
        this.diskon = diskon;
    }
    public String getkodePelanggan(){
        return kodePelanggan;
    }
    public String getNama(){
        return nama;
    }
    public String getmeterBulanIni(){
        return meterBulanIni;
    }
    public String getmeterBulanLalu(){
        return meterBulanLalu;
    }
    public String getTarif(){
        return tarif;
    }
    public String getDiskon(){
        return diskon;
    }
}
