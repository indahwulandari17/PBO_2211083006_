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
public class PerpangkatanFor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan Angka = ");
        int nilai = in.nextInt();
        System.out.println("Masukkan Pangkat = ");
        int pkt = in.nextInt();

        int h = 1;

        for (int i=1; i<=pkt;i++){
        h = h * nilai;
        }
        System.out.println(nilai+ " ^ " + pkt + " = " +h);
    }
}
