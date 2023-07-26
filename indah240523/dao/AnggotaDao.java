/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package indah240523.dao;
import indah240523.model.Anggota;
import java.util.List;
import java.sql.SQLException;
/**
 *
 * @author A409FA
 */
public interface AnggotaDao {
    void insert (Anggota anggota) throws SQLException;
    void update(Anggota anggota)throws SQLException;
    void delete(String nobp)throws SQLException;
    Anggota getAnggota(String nobp)throws SQLException;
    List<Anggota> getAll()throws SQLException;
}
