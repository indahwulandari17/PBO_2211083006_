/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah240523.dao;
import indah240523.model.Anggota;
import indah240523.model.Buku;
import indah240523.model.Peminjaman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author A409FA
 */
public class PeminjamanDaoImpl implements PeminjamanDao {
    Connection connection;

    public PeminjamanDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insert(Peminjaman peminjaman) throws SQLException {
        String sql="insert into peminjaman values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getAnggota().getNobp());
        ps.setString(2, peminjaman.getBuku().getKodeBuku());
        ps.setString(3, peminjaman.getTglpinjam());
        ps.setString(4, peminjaman.getTglkembali());
        ps.executeUpdate();
    }

    @Override
    public void update(Peminjaman peminjaman) throws SQLException {
        String sql="update peminjaman set tglkembali=? "
                + "where nobp=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getTglkembali());
        ps.setString(2, peminjaman.getAnggota().getNobp());
        ps.setString(3, peminjaman.getBuku().getKodeBuku());
        ps.setString(4, peminjaman.getTglpinjam());
        ps.executeUpdate();
    }

    @Override
    public void delete(Peminjaman peminjaman) throws SQLException {
        String sql="delete from peminjaman "
                + "where nobp=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getAnggota().getNobp());
        ps.setString(2, peminjaman.getBuku().getKodeBuku());
        ps.setString(3, peminjaman.getTglpinjam());
        ps.executeUpdate();
    }

    @Override
    public Peminjaman getPeminjaman(String nobp, String kodebuku, String tglpinjam) throws SQLException {
        String sql="select * from peminjaman "
                + "where nobp=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, nobp);
        ps.setString(2, kodebuku);
        ps.setString(3, tglpinjam);
        ResultSet rs = ps.executeQuery();
        Peminjaman peminjaman = null;
        if(rs.next()){
            peminjaman = new Peminjaman();
            AnggotaDao anggotaDao = new AnggotaDaoImpl(connection);
            Anggota anggota = anggotaDao.getAnggota(nobp);
            peminjaman.setAnggota(anggota);
            BukuDao bukuDao = new BukuDaoImpl(connection);
            Buku buku = bukuDao.getBuku(kodebuku);
            peminjaman.setBuku(buku);
            peminjaman.setTglpinjam(rs.getString(3));
            peminjaman.setTglkembali(rs.getString(4));
        }
        return peminjaman;
    }

    @Override
    public List<Peminjaman> getAll() throws SQLException {
        String sql="select * from peminjaman";
        PreparedStatement ps = connection.prepareStatement(sql);
        Peminjaman peminjaman;
        ResultSet rs = ps.executeQuery();
        List<Peminjaman> list = new ArrayList<>();
        while(rs.next()){
            peminjaman = new Peminjaman();
            AnggotaDao anggotaDao = new AnggotaDaoImpl(connection);
            Anggota anggota = anggotaDao.getAnggota(rs.getString(1));
            peminjaman.setAnggota(anggota);
            BukuDao bukuDao = new BukuDaoImpl(connection);
            Buku buku = bukuDao.getBuku(rs.getString(2)); 
            peminjaman.setBuku(buku);
            peminjaman.setTglpinjam(rs.getString(3));
            peminjaman.setTglkembali(rs.getString(4));
            list.add(peminjaman);
        }
        return list;
    }
}
