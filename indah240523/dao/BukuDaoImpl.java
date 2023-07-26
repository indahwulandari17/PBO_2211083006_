/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah240523.dao;
import indah240523.model.Buku;
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
public class BukuDaoImpl implements BukuDao {
    private Connection connection;

    public BukuDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Buku buku) throws SQLException {
        String sql = "insert into buku values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, buku.getKodeBuku());
        ps.setString(2, buku.getJudulBuku());
        ps.setString(3, buku.getPengarang());
        ps.setString(4, buku.getPenerbit());
        ps.executeUpdate();
    }

    @Override
    public void update(Buku buku) throws SQLException {
    }

    @Override
    public void delete(String kodebuku) throws SQLException {
    }

    @Override
    public Buku getBuku(String kodebuku) throws SQLException {
        String sql = "select * from buku where kodebuku=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, kodebuku);
        ResultSet rs = ps.executeQuery();
        Buku buku = null;
        if (rs.next()) {
            buku = new Buku();
            buku.setKodeBuku(rs.getString(1));
            buku.setJudulBuku(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
        }
        return buku;
    }

    @Override
    public List<Buku> getAll() throws SQLException {
        String sql = "select * from buku";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Buku> list = new ArrayList<>();
        Buku buku = null;
        while (rs.next()) {
            buku = new Buku();
            buku.setKodeBuku(rs.getString(1));
            buku.setJudulBuku(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
            list.add(buku);
        }
        return list;
    }

}
