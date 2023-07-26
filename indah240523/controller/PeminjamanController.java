/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah240523.controller;
import indah240523.dao.AnggotaDao;
import indah240523.dao.AnggotaDaoImpl;
import indah240523.dao.BukuDao;
import indah240523.dao.BukuDaoImpl;
import indah240523.dao.PeminjamanDao;
import indah240523.dao.PeminjamanDaoImpl;
import indah240523.database.DatabaseHelper;
import indah240523.model.Anggota;
import indah240523.model.Buku;
import indah240523.model.Peminjaman;
import indah240523.view.FormPeminjaman;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author A409FA
 */
public class PeminjamanController {
    FormPeminjaman formPeminjaman;
    Peminjaman peminjaman;
    PeminjamanDao peminjamanDao;
    AnggotaDao anggotaDao;
    BukuDao bukuDao;

    public PeminjamanController(FormPeminjaman formPeminjaman) {
        try {
            this.formPeminjaman = formPeminjaman;
            peminjamanDao = new PeminjamanDaoImpl(DatabaseHelper.getConnection());
            anggotaDao = new AnggotaDaoImpl(DatabaseHelper.getConnection());
            bukuDao = new BukuDaoImpl(DatabaseHelper.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
        formPeminjaman.getTxtTglKembali().setText("");
        formPeminjaman.getTxtTglPinjam().setText("");
    }
    
    public void isiComboAnggota(){
        try {
            formPeminjaman.getCboNobp().removeAllItems();
            List<Anggota> list = anggotaDao.getAll();
            for (Anggota anggota : list) {
                formPeminjaman.getCboNobp()
                        .addItem(anggota.getNobp()+"-"+anggota.getNama());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void isiComboBuku(){
        try {
            formPeminjaman.getCboKodebuku().removeAllItems();
            List<Buku> list = bukuDao.getAll();
            for (Buku buku : list) {
                formPeminjaman.getCboKodebuku()
                        .addItem(buku.getKodeBuku()+"-"+buku.getJudulBuku());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            peminjaman = new Peminjaman();
            Anggota anggota = anggotaDao.getAnggota(formPeminjaman.getCboNobp()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setAnggota(anggota);
            Buku buku = bukuDao.getBuku(formPeminjaman.getCboKodebuku()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setBuku(buku); 
            peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
            peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText()); 
            peminjamanDao.insert(peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Entri Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formPeminjaman, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        try {
            Anggota anggota = anggotaDao.getAnggota(formPeminjaman.getCboNobp()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setAnggota(anggota);
            Buku buku = bukuDao.getBuku(formPeminjaman.getCboKodebuku()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setBuku(buku); 
            peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
            peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText()); 
            peminjamanDao.update(peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Update Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formPeminjaman, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            peminjamanDao.delete(peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Delete Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formPeminjaman, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void getPeminjaman(){
        try {
            String nobp = formPeminjaman.getTabelPeminjaman()
                    .getValueAt(formPeminjaman.getTabelPeminjaman()
                            .getSelectedRow(), 0).toString();
            String kodebuku = formPeminjaman.getTabelPeminjaman()
                    .getValueAt(formPeminjaman.getTabelPeminjaman()
                            .getSelectedRow(), 2).toString();
            String tglpinjam = formPeminjaman.getTabelPeminjaman()
                    .getValueAt(formPeminjaman.getTabelPeminjaman()
                            .getSelectedRow(), 4).toString();
 
            peminjaman = peminjamanDao.getPeminjaman(nobp, kodebuku, tglpinjam);
            Anggota anggota = anggotaDao.getAnggota(peminjaman.getAnggota().getNobp());
            formPeminjaman.getCboNobp().setSelectedItem(anggota.getNobp()+"-"+anggota.getNama());
            Buku buku = bukuDao.getBuku(peminjaman.getBuku().getKodeBuku());
            formPeminjaman.getCboKodebuku()
                    .setSelectedItem(buku.getKodeBuku()+"-"+buku.getJudulBuku());
            formPeminjaman.getTxtTglPinjam().setText(peminjaman.getTglpinjam());
            formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglkembali());
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampilTabel() {
        try {
            DefaultTableModel tabelModel
                    = (DefaultTableModel) formPeminjaman.getTabelPeminjaman().getModel();
            tabelModel.setRowCount(0);
            List<Peminjaman> list = peminjamanDao.getAll();
            for (Peminjaman p : list) {
                Anggota anggota = anggotaDao.getAnggota(p.getAnggota().getNobp());
                Buku buku = bukuDao.getBuku(p.getBuku().getKodeBuku());
                Object[] row = {
                    anggota.getNobp(),
                    anggota.getNama(),
                    buku.getKodeBuku(),
                    buku.getJudulBuku(),
                    p.getTglpinjam(),
                    p.getTglkembali()
                };
                tabelModel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
