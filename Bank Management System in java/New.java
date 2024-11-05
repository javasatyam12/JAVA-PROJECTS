

import java.sql.*;

public class New {
    Connection connection;
    Statement statement;
    public New (){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankManagement","root","Mysqldatabase@123456");
            statement = connection.createStatement();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
