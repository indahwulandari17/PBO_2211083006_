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
import indah240523.dao.PengembalianDao;
import indah240523.dao.PengembalianDaoImpl;
import indah240523.database.DatabaseHelper;
import indah240523.model.Anggota;
import indah240523.model.Buku;
import indah240523.model.Peminjaman;
import indah240523.model.Pengembalian;
import indah240523.view.FormPengembalian;
import java.sql.Connection;
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
public class PengembalianController {
   FormPengembalian formPengembalian;
    PengembalianDao pengembalianDao;
    PeminjamanDao peminjamanDao;
    AnggotaDao anggotaDao;
    BukuDao bukuDao;
    Connection connection;
    Pengembalian pengembalian;

    public PengembalianController(FormPengembalian formPengembalian) {
        try {
            this.formPengembalian = formPengembalian;
            connection = DatabaseHelper.getConnection();
            pengembalianDao = new PengembalianDaoImpl(connection);
            peminjamanDao = new PeminjamanDaoImpl(connection);
            anggotaDao = new AnggotaDaoImpl(connection);
            bukuDao = new BukuDaoImpl(connection);
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void clearForm(){
        formPengembalian.getTxtDenda().setText("");
        formPengembalian.getTxtTerlambat().setText("");
        formPengembalian.getTxtTglDiKembalikan().setText("");
        formPengembalian.getTxtTglPinjam().setText("");
    }
    
    public void isiCboAnggota(){
        try {
            formPengembalian.getCboKodeAnggota().removeAllItems();
            List<Anggota> list = anggotaDao.getAll();
            for (Anggota anggota : list) {
                formPengembalian.getCboKodeAnggota()
                        .addItem(anggota.getNobp()+"-"+anggota.getNama()); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiCboBuku(){
        try {
            formPengembalian.getCboKodeBuku().removeAllItems();
            List<Buku> list = bukuDao.getAll();
            for (Buku buku : list) {
                formPengembalian.getCboKodeBuku()
                        .addItem(buku.getKodeBuku()+"-"+buku.getJudulBuku()); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            pengembalian = new Pengembalian();
            pengembalian.setNobp(formPengembalian.getCboKodeAnggota()
                    .getSelectedItem().toString().split("-")[0]);
            pengembalian.setKodebuku(formPengembalian.getCboKodeBuku()
                    .getSelectedItem().toString().split("-")[0]);
            pengembalian.setTglpinjam(formPengembalian.getTxtTglPinjam().getText());
            pengembalian.setTgldikembalikan(formPengembalian.getTxtTglDiKembalikan().getText());
            pengembalian.setTerlambat(Integer.parseInt(formPengembalian
                    .getTxtTerlambat().getText()));
            pengembalian.setDenda(Double.parseDouble(formPengembalian.getTxtDenda().getText())); 
            pengembalianDao.insert(pengembalian);
            JOptionPane.showMessageDialog(formPengembalian, "Pengembalian Ok");
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void getPengembalian(){
        try {
            pengembalian = new Pengembalian();
            String kodeanggota = formPengembalian.getTabelPengembalian()
              .getValueAt(formPengembalian.getTabelPengembalian().getSelectedRow(), 0).toString();
            String kodebuku = formPengembalian.getTabelPengembalian()
              .getValueAt(formPengembalian.getTabelPengembalian().getSelectedRow(), 2).toString();
            String tglpinjam = formPengembalian.getTabelPengembalian()
              .getValueAt(formPengembalian.getTabelPengembalian().getSelectedRow(), 4).toString();
            Peminjaman peminjaman = peminjamanDao.getPeminjaman(kodeanggota, kodebuku, tglpinjam);
            Anggota anggota = anggotaDao.getAnggota(peminjaman.getAnggota().getNobp());
            formPengembalian.getCboKodeAnggota()
                    .setSelectedItem(anggota.getNobp()+"-"+anggota.getNama());
            Buku buku = bukuDao.getBuku(peminjaman.getBuku().getKodeBuku());
            formPengembalian.getCboKodeBuku()
                    .setSelectedItem(buku.getKodeBuku()+"-"+buku.getJudulBuku());
            formPengembalian.getTxtTglPinjam().setText(peminjaman.getTglpinjam());
            formPengembalian.getTxtTglDiKembalikan().setText(pengembalian.getTgldikembalikan());
            int terlambat = pengembalianDao
                    .selisihTanggal(pengembalian.getTgldikembalikan(), peminjaman.getTglkembali());
            pengembalian.setTerlambat(terlambat); 
            formPengembalian.getTxtTerlambat().setText(""+terlambat);
            formPengembalian.getTxtDenda().setText(""+pengembalian.getDenda()); 
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampilTabel() {
        try {
            DefaultTableModel tabelModel
                    = (DefaultTableModel) formPengembalian.getTabelPengembalian().getModel();
            tabelModel.setRowCount(0);
            List<Pengembalian> list = pengembalianDao.getAll();
            for (Pengembalian p : list) {
                Anggota anggota = anggotaDao.getAnggota(p.getNobp());
                Buku buku = bukuDao.getBuku(p.getKodebuku());
                Peminjaman peminjaman = peminjamanDao.getPeminjaman(p.getNobp(), 
                        p.getKodebuku(), p.getTglpinjam());
                Object[] row = {
                    anggota.getNobp(),
                    anggota.getNama(),
                    buku.getKodeBuku(),
                    buku.getJudulBuku(),
                    p.getTglpinjam(),
                    peminjaman.getTglkembali(),
                    p.getTgldikembalikan(),
                    p.getTerlambat(),
                    p.getDenda()
                };
                tabelModel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
