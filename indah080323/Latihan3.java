/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah080323;

/**
 *
 * @author A409FA
 */
public class Latihan3 {
    public static void main (String[] args) {
        int a = 10;
        int b = 23;
        int c = 5;
        int nb;
        
        nb = (a>b)?a:(b>c)?b:(c>a)?c:a;
        
        System.out.println ("Number 1 = "+a);
        System.out.println ("Number 2 = "+b);
        System.out.println ("Number 3 = "+c);
        System.out.println ("Nilai Terbesar = "+nb);
    }
}
