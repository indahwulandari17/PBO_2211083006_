/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah160323;

/**
 *
 * @author A409FA
 */
public class Hari_DoWhile {
    public static void main (String[] args) {
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};
        int i = 0;
        
        do {
            System.out.println (hari[i]);
            i++;
        }
        
        while (i<hari.length);
    }
}
