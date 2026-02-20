package Library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== LIBRARY LOGIN =====");
        System.out.print("Username: ");
        String username = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        if (Login.authenticate(username, password)) {

            System.out.println("Login Successful!");

            while (true) {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Books Available");
                System.out.println("2. Staff Details");
                System.out.println("3. Add Books");
                System.out.println("4. Remove Books");
                System.out.println("5. Add Staff");
                System.out.println("6. Remove Staff");
                System.out.println("7. Exit");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        Book.viewBooks();
                        break;

                    case 2:
                        StaffOperation.viewStaff();
                        break;

                    case 3:
                        sc.nextLine();
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        Book.addBook(title, author, qty);
                        break;

                    case 4:
                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();
                        Book.removeBook(bookId);
                        break;

                    case 5:
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Position: ");
                        String pos = sc.nextLine();
                        System.out.print("Contact: ");
                        String contact = sc.nextLine();
                        StaffOperation.addStaff(name, pos, contact);
                        break;

                    case 6:
                        System.out.print("Enter Staff ID: ");
                        int staffId = sc.nextInt();
                        StaffOperation.removeStaff(staffId);
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                }
            }

        } else {
            System.out.println("Invalid Login!");
        }
    }
}
