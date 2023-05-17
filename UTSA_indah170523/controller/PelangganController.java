/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTSA_indah170523.controller;
import UTSA_indah170523.view.FormPelanggan;
import UTSA_indah170523.model.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author A409FA
 */
public class PelangganController {
    private FormPelanggan formPelanggan;
    private PelangganDao pelangganDao;
    private Pelanggan pelanggan;
    
    public PelangganController(FormPelanggan formPelanggan){
        this.formPelanggan = formPelanggan;
        pelangganDao = new PelangganDaoImpl();
    }
    
    public void bersihForm(){
        formPelanggan.getTxtkodePelanggan().setText("");
        formPelanggan.getTxtNama().setText("");
        formPelanggan.getTxtmeterBulanIni().setText("");
        formPelanggan.getTxtmeterBulanLalu().setText("");
        formPelanggan.getTxtTarif().setText("");
        formPelanggan.getTxtDiskon().setText("");
    }
    
    public void savePelanggan(){
        pelanggan = new Pelanggan();
        pelanggan.setkodePelanggan(formAnggota.getTxtkodePelanggan().getText());
        pelanggan.setNama(formPelanggan.getTxtNama().getText());
        pelanggan.setmeterBulanIni(formPelanggan.getTxtmeterBulanIni().getText());
        pelanggan.setmeterBulanLalu(formPelanggan.getTxtmeterBulanLalu().getText());
        pelanggan.setTarif(formPelanggan.getTxtTarif().getText());
        pelanggan.setDiskon(formPelanggan.getTxtDiskon().getText());
        pelangganDao.save(pelanggan);
        javax.swing.JOptionPane.showMessageDialog(formPelanggan, "Entri Ok");
    }
    
    public void getPelanggan(){
        int index = formPelanggan.getTblPealnggan().getSelectedRow();
        pelanggan = pelangganDao.getPelanggan(index);
        if(pelanggan != null){
            formPelanggan.getTxtkodePelanggan().setText(pelanggan.getkodePelanggan());
            formPelanggan.getTxtNama().setText(pelanggan.getNama());
            formPelanggan.getTxtmeterBulanIni().setText(pelanggan.getmeterBulanIni());
            formPelanggan.getTxtmeterBulanLalu().setText(pelanggan.getmeterBulanLalu());
            formPelanggan.getTxtTarif().setText(pelanggan.getTarif());
            formPelanggan.getTxtDiskon().setText(pelanggan.getDiskon());
        }
    }
    
    public void updatePelanggan(){
        int index = formPelanggan.getTblPelanggan().getSelectedRow();
        pelanggan.setkodePelanggan(formPelanggan.getTxtkodePelanggan().getText());
        pelanggan.setNama(formPelanggan.getTxtNama().getText());
        pelanggan.setmeterBulanIni(formPelanggan.getTxtmeterBulanIni().getText());
        pelanggan.setmeterBulanLalu(formPelanggan.getTxtmeterBulanLalu().getText());
        pelanggan.setTarif(formPelanggan.getTxtTarif().getText());
        pelanggan.setDiskon(formPelanggan.getTxtDiskon().getText());
        anggotaDao.update(index,anggota);
    }
    
    public void deletePelanggan(){
        int index = formPelanggan.getTblPelanggan().getSelectedRow();
        pelangganDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formPelanggan, "Delete");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel =
                (DefaultTableModel) formPelanggan.getTblPelanggan().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Pelanggan> list = pelangganDao.getAll();
        for(Pelanggan pelanggan : list){
            Object[] data = {
                pelanggan.getkodePelanggan(),
                pelanggan.getNama(),
                pelanggan.getmeterBulanIni(),
                pelanggan.getmeterBulanLalu(),
                pelanggan.getTarif(),
                pelanggan.getDiskon()
            };
            tabelModel.addRow(data);
        }
    }
}
