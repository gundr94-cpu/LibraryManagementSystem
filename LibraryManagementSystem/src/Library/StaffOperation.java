package Library;

import java.sql.*;

public class StaffOperation {

    public static void viewStaff() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM staff");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("staff_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Position: " + rs.getString("position"));
                System.out.println("Contact: " + rs.getString("contact"));
                System.out.println("-------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addStaff(String name, String position, String contact) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO staff(name, position, contact) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, position);
            ps.setString(3, contact);
            ps.executeUpdate();

            System.out.println("Staff Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeStaff(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM staff WHERE staff_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Staff Removed Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


