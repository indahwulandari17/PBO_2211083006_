/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah160323;

/**
 *
 * @author A409FA
 */
public class BukuAlamat {
    public static void main(String []args){
        String alamat[][] = {{"Florence", "735-1234", "Manila"}, 
                            {"Joyce", "983-3333", "Quezon City"},{"Becca", "456-3322", "Manila"}};
        int i = 0;
        do
        {
            System.out.println("Name    :" + alamat[i][0] );
            System.out.println("Tel. #  :" + alamat[i][1] );
            System.out.println("Address :" + alamat[i][2] );
            System.out.println(" ");
            i++;
        }
        
        while (i < 3);
    }
}