package Model;


import Entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO Employee (CMND, Full_Name, Birthday, Address, Position, Department) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM users WHERE id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE users set name = ?, email= ?, country =? WHERE id = ?";
    public EmployeeDAO() {

    }
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        String hostName = "localhost";//127.0.0.1
        String dbName = "test2";
        String username = "root";
        String password = "";
        String connURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
        conn = DriverManager.getConnection(connURL, username, password);
        return conn;
    }

    public void insertEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
        preparedStatement.setString(1, employee.getCMND());
        preparedStatement.setString(2, employee.getFull_Name());
        preparedStatement.setString(3, employee.getBirthday());
        preparedStatement.setString(4, employee.getAddress());
        preparedStatement.setString(5, employee.getPosition());
        preparedStatement.setString(6, employee.getDepartment());
        preparedStatement. executeUpdate();


    }


    public List<Employee> selectAllEmployees() throws  SQLException, ClassNotFoundException{
        List<Employee> employees = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String cmnd = rs.getString("CMND");
            String fullname = rs.getString("Full_Name");
            String birthday = rs.getString("Birthday");
            String address = rs.getString("Address");
            String position = rs.getString("Position");
            String department = rs.getString("Department");


            employees.add(new Employee(id, cmnd, fullname, birthday, address, position, department));
        }
        return employees;
    }

//    public boolean delete(int id) throws  SQLException, ClassNotFoundException{
//        boolean rowDelete;
//        Connection connection = getConnection();
//        PreparedStatement statement = connection.prepareStatement();
//        statement.setInt(1, id);
//        rowDelete = statement.executeUpdate() > 0;
//        return rowDelete;
//    }
//
//    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
//        boolean rowUpdate;
//        Connection connection = getConnection();
//        PreparedStatement statement = connection.prepareStatement();
//        statement.setString(1, user.getName());
//        statement.setString(2, user.getEmail());
//        statement.setString(3, user.getCountry());
//        statement.setInt(4, user.getId());
//        rowUpdate = statement.executeUpdate() > 0;
//        return rowUpdate;
//
//    }

}