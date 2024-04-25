import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        menu();
        int choose;
        choose = new Scanner(System.in).nextInt();
        switch (choose) {
            case 1:
                getAllCustomer();
                break;
            case 2:
                addCustomer();
                break;
            case 3:
                updateCustomer();
                break;
            case 4:
                deleteCustomer();
                break;
            default:
                System.out.println("Không có chức năng này, vui lòng thử lại");
        }

    }

    public static void  getAllCustomer() throws SQLException{
        // Call DT connection
        Connection connection = MySQLConnectionDB.getMySQLConnection();
        // Create statement  để thực thi truy vấn
        Statement stm = connection.createStatement();
        // Cau lenh truy van
        String query = "SELECT * FROM customers";
        // Thuc thi truy van, ket qua tra ve ResultSet
        ResultSet rs = stm.executeQuery(query);
        // Doc ban  ghi den het

        while (rs.next()) {
            System.out.println("===============================");
            System.out.println("Customer Id: " + rs.getInt(1));
            System.out.println("first name: " + rs.getString(2));
            System.out.println("last name: " + rs.getString(3));
            System.out.println("email:" + rs.getString(4));
        }
        connection.close();

    }

    public static void addCustomer() throws SQLException {
        Scanner input = new Scanner(System.in);
        Connection connection = MySQLConnectionDB.getMySQLConnection();
        System.out.println("Nhập Id: ");
        Integer id = input.nextInt();
        System.out.println("Nhập first name: ");
        String firstName = input.next();
        System.out.println("Nhập last name: ");
        String lastName = input.next();
        System.out.println("Nhập email: ");
        String email = input.next();

        String query = "INSERT INTO customers (customer_id, first_name, last_name, email) VALUES (?, ?, ?, ?) ";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.setString(2, firstName);
        pstmt.setString(3, lastName);
        pstmt.setString(4, email);
        pstmt.executeUpdate();
        System.out.println("Thêm thành công.");

        // Đóng các tài nguyên
        pstmt.close();
        connection.close();
    }

    public static void updateCustomer() throws SQLException {
        Scanner input = new Scanner(System.in);
        Connection connection = MySQLConnectionDB.getMySQLConnection();
        System.out.println("Nhập Id: ");
        Integer id = input.nextInt();
        System.out.println("Nhập first name: ");
        String firstName = input.next();
        System.out.println("Nhập last name: ");
        String lastName = input.next();
        System.out.println("Nhập email: ");
        String email = input.next();

        String query = "UPDATE customers SET" +
                " first_name = ? , last_name = ? , email = ? WHERE customer_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, email);
        pstmt.setInt(4, id);

        int rowsUpdated = pstmt.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Dữ liệu đã được cập nhật thành công!");
        } else {
            System.out.println("Không có bản ghi nào được cập nhật.");
        }
        // Đóng các tài nguyên
        pstmt.close();
        connection.close();
    }

    public static void deleteCustomer()throws SQLException {
        Scanner input = new Scanner(System.in);
        Connection connection = MySQLConnectionDB.getMySQLConnection();
        System.out.println("Nhập Id: ");
        Integer id = input.nextInt();

        String query = "DELETE FROM customers WHERE customer_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);

        int rowsDeleted = pstmt.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Bản ghi đã được xóa thành công!");
        } else {
            System.out.println("Không có bản ghi nào được xóa.");
        }

        // Đóng các tài nguyên
        pstmt.close();
        connection.close();
    }

    public static void menu() {
        System.out.println("1. Danh sách tất cả các khách hàng");
        System.out.println("2. Thêm khách hàng mới");
        System.out.println("3. Cập nhật thông tin khách hàng");
        System.out.println("4. Xóa khách hàng");
        System.out.println("Vui lòng chọn chức năng: ");
    }
}