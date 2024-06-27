package Model.Mahasiswa;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelMahasiswa extends AbstractTableModel {

    List<ModelMahasiswa> daftarMahasiswa;

    String kolom[] = {"ID", "Nama", "NIM", "Email", "Password", "Angkatan"};

    public ModelTabelMahasiswa(List<ModelMahasiswa> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }

    // Method untuk mengambil jumlah baris dari tabel
    @Override
    public int getRowCount() {
        return daftarMahasiswa.size();
    }

    // Method untuk mengambil jumlah kolom dari tabel
    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelMahasiswa mahasiswa = daftarMahasiswa.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mahasiswa.getId();
            case 1:
                return mahasiswa.getNama();
            case 2:
                return mahasiswa.getNim();
            case 3:
                return mahasiswa.getEmail();
            case 4:
                return mahasiswa.getPassword();
            case 5:
                return mahasiswa.getAngkatan();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
    
    public void setData(List<ModelMahasiswa> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
        fireTableDataChanged();
    }
}