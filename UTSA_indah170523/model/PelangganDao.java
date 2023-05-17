/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package UTSA_indah170523.model;
import java.util.List;
/**
 *
 * @author A409FA
 */
public interface PelangganDao {
    void save(Pelanggan pelanggan);
    void update(int index, Pelanggan pelanggan);
    void delete(int index);
    Pelanggan getPelanggan(int index);
    List<Pelanggan> getAllPelanggan();
}
