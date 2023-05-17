/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTSA_indah170523.model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A409FA
 */
public class PelangganDaoImpl implements PelangganDao {
    List<Pelanggan> data = new ArrayList<>();
    public PelangganDaoImpl(){
    
    }
    public void save(Pelanggan pelanggan){
        data.add(pelanggan);
    }
    public void update(int index,Pelanggan pelanggan){
        data.set(index, pelanggan);
    }
    public void delete(int index){
        data.remove(index);
    }
    public Pelanggan getPelanggan(int index){
        return data.get(index);
    }
    public List<Pelanggan> getAllPelanggan(){
        return data;
    }
}
