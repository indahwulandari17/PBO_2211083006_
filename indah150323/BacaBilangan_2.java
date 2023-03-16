/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah150323;
import java.io.*;
/**
 *
 * @author A409FA
 */
public class BacaBilangan_2 {
    public static void main(String[] args) {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader (System.in));
        String num = "";

        System.out.println("Masukkan Angka 1-10 = ");

        try {
            num = dataIn.readLine();
        }
        
        catch (IOException e ) {
            System.out.println("Error!");
        }

        int i = Integer.parseInt(num); // ingat untuk mengconvert String menjadi int harus menggunakan ini atau boleh dengan metode yang lain

        switch(i) {
        case 1:
            System.out.println("Satu");
            break;
            
        case 2:
            System.out.println("Dua");
            break;
            
        case 3:
            System.out.println("Tiga");
            break;
            
        case 4:
            System.out.println("Empat");
            break;
            
        case 5:
            System.out.println("Lima");
            break;
            
        case 6:
            System.out.println("Enam");
            break;
            
        case 7:
            System.out.println("Tujuh");
            break;
            
        case 8:
            System.out.println("Delapan");
            break;
            
        case 9:
            System.out.println("Sembilan");
            break;
            
        case 10:
            System.out.println("Sepuluh");
            break;
            
        default:
            System.out.println("Invalid Number!");
        }
    }
}
