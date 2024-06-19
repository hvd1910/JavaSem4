package com.example.demo;

import java.sql.*;

public class LoginBean {
    public boolean checkLogin(String urs, String pwd) throws  Exception{
        try{
            Connection connection = ConnectionSQL.getMySQLConnection();

            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, urs);
            pstmt.setString(2, pwd);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            }else {
                return  false;
            }


        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
