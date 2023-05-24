/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah120423;

/**
 *
 * @author A409FA
 */
public class StudentRecord {
    public String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    private double average;
    private static int studentCount;
        
    //Menghasilkan nama dari Siswa
    public String getName(){
        return name;
    }

    //Mengubah nama siswa
    public void setName( String temp ){
        name = temp;
    }

    //Menghitung rata – rata nilai Matematik, Bahasa Inggris,IlmuPasti
    public double getAverage(){
        double result = 0;
        result = ( mathGrade+englishGrade+scienceGrade )/3;
        return result;
    }

    //Menghasilkan jumlah instance StudentRecord
    public static int getStudentCount(){
        return studentCount;
    }
}
