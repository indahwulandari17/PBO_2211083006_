/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package indah270423.model;
import java.util.List;
/**
 *
 * @author A409FA
 */
public interface AnggotaDao {
    void save(Anggota anggota);
    void update(int index, Anggota anggota);
    void delete(int index);
    Anggota getAnggota(int index);
    List<Anggota> getAll();
}
