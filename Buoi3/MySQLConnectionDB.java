import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionDB {
    public static Connection getMySQLConnection () throws SQLException {
        Connection conn = null;
        String hostName = "localhost";//127.0.0.1
        String dbName = "test2";
        String username = "root";
        String password = "";
        String connURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
        conn = DriverManager.getConnection(connURL, username, password);
        return conn;
    }

    public static void main(String[] args) throws SQLException{
        if (getMySQLConnection() != null) {
            System.out.println("Kết nối thành công!");
        }

    }
}
