/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah160323;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author A409FA
 */
public class NomorTerbesar_BR {
    public static void main (String[] args) {
        BufferedReader masukan = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[11];
        int terbesar = 0;
        for(int i=1;i+1<=a.length;i++)
        {
            System.out.print ("Masukkan Angka "+i+" = ");
            try
            {
                a[i] = Integer.parseInt(masukan.readLine());
            }
            
            catch( IOException e)
            {
                
            }
            
            if(terbesar>a[i])
            {
                if(terbesar>a[i])
                {
                    terbesar=terbesar;
                }
            }
            
            else
            {
                if(a[i]>a[i-1])
                {
                    terbesar=a[i];
                }
                
                else
                {
                    terbesar=a[i-1];
                }
            }
        }
        String hasil = "Terbesar Adalah = "+terbesar;
        System.out.println(hasil);     
    }
}
