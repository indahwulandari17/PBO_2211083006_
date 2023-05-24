/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package indah270423.model;
import java.util.*;
/**
 *
 * @author A409FA
 */
public interface BukuDao {
    void save(Buku buku);
    void update(int idx, Buku buku);
    void delete(int idx);
    Buku getBuku(int idx);
    List<Buku> getAll();
}
