import java.sql.*;
import java.sql.DriverManager;

public class TestConnection {

//    host :44.201.88.173/

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@44.201.88.173:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTION WAS SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("connection has failed"+e.getMessage());;
        }

    }
}
