/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah300323;

/**
 *
 * @author A409FA
 */
public class AritmatikaExample {
    public static void main(String[] args) {
        Aritmatika aritmatika = new Aritmatika();
        int c = aritmatika.tambah(10, 5);
        System.out.println("C : "+c);
        
        System.out.println("Ganjil?"+aritmatika.cekGanjil(c));
        
        int n =8;
        int [] ganjil = aritmatika.getGanjil(n);
        System.out.println("Bilangan Ganjil Sebanyak "+n+" Adalah ");
        
        for(int i=0;i<ganjil.length;i++)
        {
            System.out.print(ganjil[i]+" ");
        }
        int p = 10; //Ganti dengan nilai p yang diinginkan
        
        //Cetak p bilangan prima
        int [] prima = aritmatika.getPrima(p);
        System.out.println("\nBilangan Prima Sebanyak "+p+" Adalah");
        for (int i = 0; i < p; i++){
            System.out.print(prima[i] + " ");
        }  
    }
}

