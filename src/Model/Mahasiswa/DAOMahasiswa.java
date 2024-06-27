package Model.Mahasiswa;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOMahasiswa implements InterfaceDAOMahasiswa {

    @Override
    public void insert(ModelMahasiswa mahasiswa) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "INSERT INTO mahasiswa (nama, nim, email, password, angkatan) VALUES (?, ?,?,?,?);";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getNim());
            statement.setString(3, mahasiswa.getEmail());
            statement.setString(4, mahasiswa.getPassword());
            statement.setString(5, mahasiswa.getAngkatan());
            
            
            // Menjalankan query untuk memasukkan data mahasiswa baru
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal input data.
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        } 
    }

    @Override
    public void update(ModelMahasiswa mahasiswa) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "UPDATE mahasiswa SET nama=?, nim=?, email=?, password=?, angkatan=? WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getNim());
            statement.setString(3, mahasiswa.getEmail());
            statement.setString(4, mahasiswa.getPassword());
            statement.setString(5, mahasiswa.getAngkatan());
            statement.setInt(6, mahasiswa.getId());
            
            // Menjalankan query untuk menghapus data mahasiswa yang dipilih
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal edit data.
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "DELETE FROM mahasiswa WHERE id=?;";
            
            /* 
              Memasukkan id berdasarkan data yang mau dihapus ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            
            // Menjalankan query untuk menghapus data mahasiswa yang dipilih
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal hapus data.
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelMahasiswa> getAll() {
        List<ModelMahasiswa> listMahasiswa = null;

        try {
            
            listMahasiswa = new ArrayList<>();
            
            // Membuat objek statement yang digunakan untuk melakukan query.
            Statement statement = Connector.Connect().createStatement();
            
            String query = "SELECT * FROM mahasiswa;";
            
             // Mengeksekusi query dan menyimpannya ke dalam variabel "resultSet".
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                // Membuat sebuah objek "Mahasiswa" untuk menyimpan data tiap-tiap mahasiswa
                ModelMahasiswa mhs = new ModelMahasiswa();
                
                // Memasukkan hasil query ke objek mahasiswa
                mhs.setId(resultSet.getInt("id"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setNim(resultSet.getString("nim"));
                mhs.setEmail(resultSet.getString("email"));
                mhs.setPassword(resultSet.getString("password"));
                mhs.setAngkatan(resultSet.getString("angkatan"));
                
                listMahasiswa.add(mhs);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal mengambil data.
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listMahasiswa;
    }

    @Override
    public List<ModelMahasiswa> cariMahasiswa(String keyword) {
        List<ModelMahasiswa> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM mahasiswa WHERE nama LIKE ? OR nim LIKE ? OR email LIKE ? OR password LIKE ? OR angkatan LIKE ?";
            PreparedStatement statement = Connector.Connect().prepareStatement(query);
            String searchKeyword = "%" + keyword + "%";
            for (int i = 1; i <= 5; i++) {
                statement.setString(i, searchKeyword);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ModelMahasiswa mhs = new ModelMahasiswa();
                mhs.setId(resultSet.getInt("id"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setNim(resultSet.getString("nim"));
                mhs.setEmail(resultSet.getString("email"));
                mhs.setPassword(resultSet.getString("password"));
                mhs.setAngkatan(resultSet.getString("angkatan"));
                result.add(mhs);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return result;
    }
}