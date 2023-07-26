/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indah240523.controller;
import indah240523.dao.BukuDao;
import indah240523.dao.BukuDaoImpl;
import indah240523.model.Buku;
import indah240523.database.DatabaseHelper;
import indah240523.view.FormBuku;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author A409FA
 */
public class BukuController {
     FormBuku view;
    Buku model;
    BukuDao dao;
    public BukuController (FormBuku view){
        this.view = view;
        try {
            dao = new BukuDaoImpl(DatabaseHelper.getConnection());
        } catch (Exception ex) {
        }
    }
    
    public void clearForm(){
        view.getTxtKodeBuku().setEditable(true);
        view.getTxtKodeBuku().setText("");
        view.getTxtJudulBuku().setText("");
        view.getTxtPengarang().setText("");
        view.getTxtPenerbit().setText("");
        view.getBtnInsert().setEnabled(true);
        view.getBtnUpdate().setEnabled(false);
        view.getBtnDelete().setEnabled(false);
    }
    
    public void saveBuku() throws SQLException{
        model = new Buku();
        model.setKodeBuku(view.getTxtKodeBuku().getText());
        model.setJudulBuku(view.getTxtJudulBuku().getText());
        model.setPengarang(view.getTxtPengarang().getText());
        model.setPenerbit(view.getTxtPenerbit().getText());
        dao.insert(model);
        JOptionPane.showMessageDialog(view, "Insert ok ");
    }
       
    public void tampil() throws SQLException{
        DefaultTableModel tabelModel = (DefaultTableModel) view.getTblBuku().getModel();
        tabelModel.setRowCount(0);
        List<Buku> list = dao.getAll();
        if (list != null){
            for (Buku buku1 : list){
                Object row[]= {
                    buku1.getKodeBuku(),
                    buku1.getJudulBuku(),
                    buku1.getPengarang(),
                    buku1.getPenerbit()
                };
                tabelModel.addRow(row);
            }
        }
    }
    
    public void getBuku() {
        view.getTxtKodeBuku().setEditable(false);
        view.getBtnInsert().setEnabled(false);
        view.getBtnUpdate().setEnabled(true);
        view.getBtnDelete().setEnabled(true);
        try {
            String kodeBuku = view.getTblBuku().getValueAt(view.getTblBuku().getSelectedRow(), 0).toString();
            model = dao.getBuku(kodeBuku);
            if(model != null){
                view.getTxtKodeBuku().setText(model.getKodeBuku());
                view.getTxtJudulBuku().setText(model.getJudulBuku());
                view.getTxtPengarang().setText(model.getPengarang());
                view.getTxtPenerbit().setText(model.getPenerbit());    
            }
        } catch (SQLException ex ){
        }
    }
    
    public void update () throws SQLException{
        model = new Buku();
        model.setKodeBuku(view.getTxtKodeBuku().getText());
        model.setJudulBuku(view.getTxtJudulBuku().getText());
        model.setPengarang(view.getTxtPengarang().getText());
        model.setPenerbit(view.getTxtPenerbit().getText());
        dao.update(model);
        JOptionPane.showMessageDialog(view, "Update ok ");
    }
    
    public void delete () throws SQLException{
        String kodeBuku = view.getTxtKodeBuku().getText().toString();
        dao.delete(kodeBuku);
        JOptionPane.showMessageDialog(view, "Delete ok ");
    }
}
