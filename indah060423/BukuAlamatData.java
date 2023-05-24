/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah060423;

/**
 *
 * @author A409FA
 */
public class BukuAlamatData {
    private String nama;
    private String alamat;
    private String nomor;
    private String email;
    
    
    public BukuAlamatData(String nama, String alamat, String nomor, String email){
        this.nama = nama;
        this.alamat = alamat;
        this.nomor = nomor;
        this.email = email;
    }
    
    public BukuAlamatData(){    
    }
    
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getAlamat(){
        return alamat;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public String getNomor(){
        return nomor;
    }
    public void setNomor(String nomor){
        this.nomor = nomor;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public void print(String temp){
        System.out.println("\nNama          : "+nama);
        System.out.println("Alamat          : "+alamat);
        System.out.println("Nomor Telpon    : "+nomor);
        System.out.println("Email           : "+email);
    }
}
