/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah260423.controller;
import indah260423.model.*;
import indah260423.view.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
/**
 *
 * @author A409FA
 */
public class AnggotaController {
    private FormAnggota formAnggota;
    private Anggota anggota;
    private AnggotaDao anggotaDao;
    
    public AnggotaController(FormAnggota formAnggota) {
        this.formAnggota = formAnggota;
        anggotaDao = new AnggotaDaoImpl();
    }
    
    public void bersihForm() {
        formAnggota.getTxtNobp().setText("");
        formAnggota.getTxtNama().setText("");
        formAnggota.getTxtAlamat().setText("");
    }
    
    public void saveAnggota() {
        anggota = new Anggota();
        anggota.setNobp(formAnggota.getTxtNobp().getText());
        anggota.setNama(formAnggota.getTxtNama().getText());
        anggota.setAlamat(formAnggota.getTxtAlamat().getText());
        anggotaDao.save(anggota);
        JOptionPane.showMessageDialog(formAnggota, "Insert Ok");
    }
    
    public void tampil() {
        DefaultTableModel tabelModel =
                (DefaultTableModel) formAnggota.getTblAnggota().getModel();
        tabelModel.setRowCount(0);
        List<Anggota> list = anggotaDao.getAllAnggota();
        for (Anggota anggota1 : list) {
            Object row[] = {
                anggota1.getNobp(),
                anggota1.getNama(),
                anggota1.getAlamat()
            };
            tabelModel.addRow(row);
        }
    }
}
