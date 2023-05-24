/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah270423.controller;
import indah270423.view.*;
import indah270423.model.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author A409FA
 */
public class PeminjamanController {
    private Peminjaman peminjaman;
    private PeminjamanDaoImpl peminjamanDao;
    private FormPeminjaman formPeminjaman;
    
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;
    
    public PeminjamanController(FormPeminjaman formPeminjaman){
        this.formPeminjaman = formPeminjaman;
        peminjamanDao = new PeminjamanDaoImpl();
        anggotaDao = new AnggotaDaoImpl();
        bukuDao = new BukuDaoImpl();
    }
    public void bersihForm(){
        formPeminjaman.getTxtTglpinjam().setText("");
        formPeminjaman.getTxtTglkembali().setText("");
    }
    
    public void isiCombo(){
        List<Anggota> listAnggota = anggotaDao.getAll();
        List<Buku> listBuku = bukuDao.getAll();
        formPeminjaman.getCboAnggota().removeAllItems();
        formPeminjaman.getCboBuku().removeAllItems();
        //isi anggota
        for (Anggota anggota : listAnggota) {
            formPeminjaman.getCboAnggota().addItem(anggota.getNobp());
        }
        
        for (Buku buku : listBuku) {
            formPeminjaman.getCboBuku().addItem(buku.getKode());
        }
    }
    public void savePeminjaman(){
        peminjaman = new Peminjaman();
        peminjaman.setAnggota(
   anggotaDao.getAnggota(formPeminjaman.getCboAnggota().getSelectedIndex()));
        peminjaman.setBuku(
            bukuDao.getBuku(formPeminjaman.getCboBuku().getSelectedIndex()));
        peminjaman.setTglpinjam(formPeminjaman.getTxtTglpinjam().getText());
        peminjaman.setTglkembali(formPeminjaman.getTxtTglkembali().getText());
        peminjamanDao.save(peminjaman);
        javax.swing.JOptionPane.showMessageDialog(formPeminjaman, "Entri Ok");
    }
    public void getPeminjaman(){
        int index = formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjaman = peminjamanDao.getPeminjaman(index);
        if(peminjaman != null){
            formPeminjaman.getCboAnggota()
                    .setSelectedItem(peminjaman.getAnggota().getNobp());
            formPeminjaman.getCboBuku()
                    .setSelectedItem(peminjaman.getBuku().getKode());
            formPeminjaman.getTxtTglpinjam()
                    .setText(peminjaman.getTglpinjam());
            formPeminjaman.getTxtTglkembali()
                    .setText(peminjaman.getTglkembali());
        }
    }
    
    public void updatePeminjaman(){
        int idx = formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjaman.setAnggota(
   anggotaDao.getAnggota(formPeminjaman.getCboAnggota().getSelectedIndex()));
        peminjaman.setBuku(
            bukuDao.getBuku(formPeminjaman.getCboBuku().getSelectedIndex()));
        peminjaman.setTglpinjam(formPeminjaman.getTxtTglpinjam().getText());
        peminjaman.setTglkembali(formPeminjaman.getTxtTglkembali().getText());
        peminjamanDao.update(idx,peminjaman);
        javax.swing.JOptionPane.showMessageDialog(formPeminjaman, "Update Ok");
    }
    
    public void deletePeminjaman(){
        int idx = formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjamanDao.delete(idx);
        javax.swing.JOptionPane.showMessageDialog(formPeminjaman, "Deleted");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel =
                (DefaultTableModel) formPeminjaman.getTblPeminjaman().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Peminjaman> list = peminjamanDao.getAllPeminjaman();
        for(Peminjaman peminjaman : list){
            Object[] data = {
                peminjaman.getAnggota().getNobp(),
                peminjaman.getBuku().getKode(),
                peminjaman.getTglpinjam(),
                peminjaman.getTglkembali()
            };
            tabelModel.addRow(data);
        }
    }
}
