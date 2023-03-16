/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah160323;
import javax.swing.JOptionPane;
/**
 *
 * @author A409FA
 */
public class NomorTebesar_JP {
    public static void main(String [] args){
        int[] a = new int[11];
        String[] n = new String[11];
        int terbesar = 0;
    
        for(int i=1;i+1<=a.length;i++)
        {
            System.out.println(i); 
            n[i] = JOptionPane.showInputDialog("Masukkan Angka Ke-"+i+" = ");
            a[i] = Integer.parseInt(n[i]);
            if(terbesar>a[i])
            {
                if(terbesar>a[i])
                {
                    terbesar=terbesar;
                    System.out.println(terbesar); 
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
                System.out.println(terbesar); 
            }
        }
        String hasil="Terbesar Adalah "+terbesar;
        JOptionPane.showMessageDialog(null,hasil); 
    }
}
