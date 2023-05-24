/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah300323;

/**
 *
 * @author A409FA
 */
public class ContohCasting {
    public static void main (String[] args) {
        char valChar = 'A';
        int valInt = valChar;
        
        System.out.print(valInt); //casting rxplisit: keluaran 65
        
        double valDouble = 10.12;
        
        double x = 10.2;
        int y = 2;
        
        int result = (int)(x/y); //hasil typecast operasi ke int
    }
}
