/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah060423;

/**
 *
 * @author A409FA
 */
public class StudentRecordData {
    public static void main(String[] args){
        StudentRecord data[] = new StudentRecord[100];
        StudentRecord student1 =  new StudentRecord();
        //
        student1.setName("Ani");
        student1.setAddress("Padang");
        student1.setAge(20);
        student1.setMathGrade(70);
        student1.setEnglishGrade(80);
        student1.setScienceGrade(90);
        
        StudentRecord student2 =  new StudentRecord();
        //
        student2.setName("Budi");
        student2.setAddress("Solok");
        student2.setAge(20);
        student2.setMathGrade(70);
        student2.setEnglishGrade(80);
        student2.setScienceGrade(90);
        
        data[1] = student2; //tambah
        
        System.out.println(data[0].getName());
        System.out.println(data[0].getAddress());
        data[0].setName("Doni");
        data[0].setAddress("");
        System.out.println(data[0].getName());
        System.out.println(data[0].getAddress());    
    }
}
