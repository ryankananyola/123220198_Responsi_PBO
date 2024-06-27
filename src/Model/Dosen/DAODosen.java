package Model.Dosen;

import Model.Connector;
import java.sql.*;
import java.util.*;

public class DAODosen implements InterfaceDAODosen{

    @Override
    public void insert(ModelDosen dosen) {
        try {
                String query = "INSERT INTO dosen (nama, no_hp, email) VALUES (?,?,?);";

                PreparedStatement statement;
                statement = Connector.Connect().prepareStatement(query);
                statement.setString(1, dosen.getNama());
                statement.setString(2, dosen.getNohp());
                statement.setString(3, dosen.getEmail());

                statement.executeUpdate();

                statement.close();
            } catch (SQLException e) {
                System.out.println("Input Failed: " + e.getLocalizedMessage());
            } 
    }

    @Override
    public void update(ModelDosen dosen) {
        try {
            String query = "UPDATE dosen SET nama=?, no_hp=?, email=? WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNohp());
            statement.setString(3, dosen.getEmail());
            statement.setInt(4, dosen.getId());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM dosen WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelDosen> getAll() {
        List<ModelDosen> listDosen = null;

        try {
            
            listDosen = new ArrayList<>();
            
            Statement statement = Connector.Connect().createStatement();
            
            String query = "SELECT * FROM dosen;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                ModelDosen dsn = new ModelDosen();
                
                dsn.setId(resultSet.getInt("id"));
                dsn.setNama(resultSet.getString("nama"));
                dsn.setNohp(resultSet.getString("no_hp"));
                dsn.setEmail(resultSet.getString("email"));
                
                listDosen.add(dsn);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listDosen;
    }

    @Override
    public List<ModelDosen> cariDosen(String keyword) {
        List<ModelDosen> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM dosen WHERE nama LIKE ? OR no_hp LIKE ? OR email LIKE ?";
            PreparedStatement statement = Connector.Connect().prepareStatement(query);
            String searchKeyword = "%" + keyword + "%";
            for (int i = 1; i <= 3; i++) {
                statement.setString(i, searchKeyword);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ModelDosen dsn = new ModelDosen();
                dsn.setId(resultSet.getInt("id"));
                dsn.setNama(resultSet.getString("nama"));
                dsn.setNohp(resultSet.getString("no_hp"));
                dsn.setEmail(resultSet.getString("email"));
                result.add(dsn);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return result;
    }    
}