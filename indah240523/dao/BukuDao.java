/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package indah240523.dao;
import indah240523.model.Buku;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author A409FA
 */
public interface BukuDao {
     void insert (Buku buku) throws SQLException;
    void update(Buku buku)throws SQLException;
    void delete(String kodeBuku)throws SQLException;
    Buku getBuku(String kodeBuku)throws SQLException;
    List<Buku> getAll()throws SQLException;
}
