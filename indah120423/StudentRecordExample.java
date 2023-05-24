/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah120423;

/**
 *
 * @author A409FA
 */
public class StudentRecordExample {
    public static void main( String[] args ){
    StudentRecord annaRecord = new StudentRecord();

    //Memberi nama siswa
    annaRecord.setName("Anna");

    //Menampilkan nama siswa
    System.out.println(annaRecord.getName() );

    //Menampilkan jumlah siswa
    System.out.println("Count = "+StudentRecord.getStudentCount());
    }

    class CobaOverride extends StudentRecord {
    @Override
        public String getName(){
        System.out.println("Anna merupakan student");
        return name;
        }
    }
}
