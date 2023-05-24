/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah290323;

/**
 *
 * @author A409FA
 */
public class OperasiAritmatik {
    public static void main (String[] args) {
        
        if (args.length != 2) {
            System.out.println("Usage: java OperasiAritmatika n1 n2");
            return;
        }

        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);

        System.out.println("Tambah = " + (n1 + n2));
        System.out.println("Kurang = " + (n1 - n2));
        System.out.println("Kali = " + (n1 * n2));
        System.out.println("Bagi = " + (n1 / n2));
    }
}
