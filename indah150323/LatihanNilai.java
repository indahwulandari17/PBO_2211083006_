/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah150323;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author A409FA
 */
public class LatihanNilai {
    public static void main (String[] args) {
        BufferedReader dataIn = new BufferedReader (new InputStreamReader (System.in));
        int nilai1;
        int nilai2;
        int nilai3;
        float average;
        
        try {
            System.out.print ("Masukkan Nilai 1 = ");
            nilai1 = Integer.parseInt(dataIn.readLine());
            System.out.print ("Masukkan Nilai 2 = ");
            nilai2 = Integer.parseInt(dataIn.readLine());
            System.out.print ("Masukkan Nilai 3 = ");
            nilai3 = Integer.parseInt(dataIn.readLine());
            System.out.println ("Nilai 1 = " +nilai1);
            System.out.println ("Nilai 2 = " +nilai2);
            System.out.println ("Nilai 3 = " +nilai3);
            
            average = (nilai1 + nilai2 + nilai3)/3;
            System.out.println ("Average Is = " +average);
            
            if (average >= 60) {
                System.out.println ("CONGRATULATION!!!");
            }
            else {
                System.out.println ("TRY AGAIN, DON'T GIVE UP!!!");
            }
        }
        
        catch (Exception ex) {
            System.out.println ("Error");
        }
    }
}
