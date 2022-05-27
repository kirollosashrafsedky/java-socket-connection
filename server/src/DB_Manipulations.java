import javax.swing.plaf.nimbus.State;
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

    public String compareUser(String user, String pass) {
        String result = "";
        String SQL = "SELECT user_name, pass "
                + "FROM user";


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "123456789");
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(SQL);

            while(resultSet.next()){
                String uname = resultSet.getString("user_name");
                String password = resultSet.getString("pass");

                if((user.equals(uname)) && (pass.equals(password))){
                    result = "Granted";
                    break;
                }else{
                    result = "Denied";
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
