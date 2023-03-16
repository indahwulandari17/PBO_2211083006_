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
public class PerpangkatanWhile {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan Angka = ");
        int input = in.nextInt();

        System.out.println("Masukkan Pangkat = ");
        int pangkat = in.nextInt();

        int i = 1;
        int h = 1;

        while (i <= pangkat){
        h = h * input;
        i++;
        }
        System.out.println(input + " ^ " +pangkat +" = " +h);
    }
}
