package util;

import java.sql.*;

public class Koneksi {

    private Connection connection;
    private Statement statement;

    public Koneksi() throws SQLException, SQLTimeoutException {
       openConnection();
    }

    public void openConnection() throws SQLException, SQLTimeoutException {
        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mahasiswa",
                "root", "rahasia");
        statement = connection.createStatement();
    }

    public ResultSet eksekusiSelect(String sql) throws SQLException,
            SQLTimeoutException {
        ResultSet result;
        openConnection();
        result = statement.executeQuery(sql);
        closeConnection();
        return result;
    }

    public int eksekusiUpdate(String sql) throws SQLException, SQLTimeoutException {
        openConnection();
        int result = statement.executeUpdate(sql);
        closeConnection();
        return result;
    }

    public void closeConnection() throws SQLException, SQLTimeoutException {
        connection.close();
    }

}