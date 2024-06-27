package Model.Dosen;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModelTabelDosen extends AbstractTableModel {
    List<ModelDosen> daftarDosen;

    String kolom[] = {"ID", "Nama", "No Hp","Email"};
    
    public ModelTabelDosen(List<ModelDosen> daftarDosen) {
        this.daftarDosen = daftarDosen;
    }

    @Override
    public int getRowCount() {
        return daftarDosen.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarDosen.get(rowIndex).getId();
            case 1:
                return daftarDosen.get(rowIndex).getNama();
            case 2:
                return daftarDosen.get(rowIndex).getNohp();
            case 3:
                return daftarDosen.get(rowIndex).getEmail();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
    
    public void setData(List<ModelDosen> daftarDosen) {
        this.daftarDosen = daftarDosen;
        fireTableDataChanged();
    }
}