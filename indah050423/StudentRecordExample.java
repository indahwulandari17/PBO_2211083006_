/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah050423;

/**
 *
 * @author A409FA
 */
public class StudentRecordExample {
    public static void main(String[] args){
        //membuat 3 object StudentRecord 
        StudentRecord annaRecord = new StudentRecord();
        StudentRecord crisRecord = new StudentRecord();
        StudentRecord aliRecord = new StudentRecord();
        
        //Mengisi data siswa 
        annaRecord.setName("Anna"); 
        annaRecord.setAddress("Padang");
        annaRecord.setAge(20);
        
        crisRecord.setName("Cris");
        crisRecord.setAddress("Solok"); 
        crisRecord.setAge(22);
        
        aliRecord.setName("Ali");
        aliRecord.setAddress("Bukittinggi"); 
        aliRecord.setAge(24);
        
        //Menampilkan data siswa 
        System.out.println("Nama : " +annaRecord.getName());
        System.out.println("Alamat : " +annaRecord.getAddress());
        System.out.println("Umur : " +annaRecord.getAge());
        
        System.out.println("\nNama : " +crisRecord.getName());
        System.out.println("Alamat : " +crisRecord.getAddress());
        System.out.println("Umur : " +crisRecord.getAge());
        
        System.out.println("\t");
        aliRecord.print("");
        System.out.print("\n");
        aliRecord.print(60,70,80);
        
        //Menampilkan jumlah siswa 
        System.out.println("Count : "+StudentRecord.getStudentCount()); 
    }
}
