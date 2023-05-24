/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah060423;

/**
 *
 * @author A409FA
 */
public class StudentRecordExam {
    public static void main(String[] args){
        StudentRecord anna = new StudentRecord("Anna","Padang");
        anna.print("");
        
        System.out.println("Jumlah Record : "+StudentRecord.getStudentCount());
    }  
}
