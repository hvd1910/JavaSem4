package Controller;

import Entity.Employee;
import Model.EmployeeDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

@WebServlet("/")
public class ServletEmployee extends HttpServlet {
    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertEmployee(request, response);
                    break;
//                case "/delete":
//                    deleteUser(request, response);
//                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
                default:
                    listEmployees(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        List<Employee> listEmployee = employeeDAO.selectAllEmployees();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
        dispatcher.forward(request, response);
    }



    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        String cmnd = request.getParameter("CMND");
        String fullname = request.getParameter("Full_Name");
        String birthday = request.getParameter("Birthday");
        String address = request.getParameter("Address");
        String position = request.getParameter("Position");
        String department = request.getParameter("Department");

        Employee newEmployee = new Employee();
        newEmployee.setCMND(cmnd);
        newEmployee.setFull_Name(fullname);
        newEmployee.setBirthday(birthday);
        newEmployee.setAddress(address);
        newEmployee.setPosition(position);
        newEmployee.setDepartment(department);
        employeeDAO.insertEmployee(newEmployee);
        response.sendRedirect("list");
    }

//    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User user = new User(id, name, email, country);
//        userDAO.updateUser(user);
//        response.sendRedirect("list");
//    }
//
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        userDAO.delete(id);
//        response.sendRedirect("list");
//    }
}
