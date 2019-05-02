import util.*;
import java.sql.*;

public class Aplikasi {
    private static Koneksi koneksi;

    public static void main(String[] args) throws SQLException,
            SQLTimeoutException {
        koneksi = new Koneksi();

        String sql = "select * from mahasiswa";
        ResultSet hasil = koneksi.eksekusiSelect(sql);
        while(hasil.next()) {
            System.out.println("nim : " + hasil.getString(1));
            System.out.println("nama : " + hasil.getString(2));
            System.out.println("kelas : " + hasil.getString(3));
        }
    }

}