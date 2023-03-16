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
public class BacaBilangan {
    public static void main(String[] args) {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader (System.in));
        String num = "";

        System.out.println("Masukkan Angka Dari 1-10 = ");
        
        try {
        num = dataIn.readLine();
        }
        
        catch(IOException e) {
            System.out.println("Error!");
        }
        int i = Integer.parseInt(num);

        if (i == 1) {
            System.out.println("Satu");
        }
        else if (i == 2) {
            System.out.println("Dua");
        }
        else if (i == 3) {
            System.out.println("Tiga");
        }
        else if (i == 4) {
            System.out.println("Empat");
        }
        else if (i == 5) {
            System.out.println("Lima");
        }
        else if (i == 6) {
            System.out.println("Enam");
        }
        else if (i == 7) {
            System.out.println("Tujuh");
        }
        else if (i == 8) {
            System.out.println("Delapan");
        }
        else if (i == 9) {
            System.out.println("Sembilan");
        }
        else if (i == 10) {
            System.out.println("Sepuluh");
        }
        else {
            System.out.println("Invalid Number!");
        }
    }
}
