package Library;

import java.sql.*;
import java.util.Scanner;

public class Login {

    public static boolean authenticate(String username, String password) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
