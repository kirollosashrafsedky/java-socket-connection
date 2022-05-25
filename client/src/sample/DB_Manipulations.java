package sample;

import java.sql.*;

public class DB_Manipulations {
    public void insertUser(User user) {
        String SQL = "INSERT INTO user(user_id,fname,mname,lname,user_name,pass,balance) "
                + "VALUES(?,?,?,?,?,?,?)";


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "123456789");
             PreparedStatement pstmt = connection.prepareStatement(SQL)) {

            pstmt.setInt(1, user.getUserId());
            pstmt.setString(2, user.getFName());
            pstmt.setString(3, user.getMName());
            pstmt.setString(4, user.getLName());
            pstmt.setString(5, user.getUserName());
            pstmt.setString(6, user.getUserPass());
            pstmt.setFloat(7, user.getBalance());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
