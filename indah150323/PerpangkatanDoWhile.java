/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah150323;
import java.util.Scanner;
/**
 *
 * @author A409FA
 */
public class PerpangkatanDoWhile {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan Angka = ");
        int angka = in.nextInt();
        System.out.println("Masukkan Pangkat = ");
        int pangkat = in.nextInt();

        int i = 1;
        int h = 1;

        do {
        h = h * angka;
        i++ ;
        }

        while(i<=pangkat);
        System.out.println(angka +" ^ " + pangkat + " = " +h);
    }
}
