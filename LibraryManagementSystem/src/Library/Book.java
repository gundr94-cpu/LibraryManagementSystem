package Library;

import java.sql.*;


public class Book {

    public static void viewBooks() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM book");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("book_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("-------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addBook(String title, String author, int quantity) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO book(title, author, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, quantity);
            ps.executeUpdate();

            System.out.println("Book Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeBook(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM book WHERE book_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Book Removed Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
