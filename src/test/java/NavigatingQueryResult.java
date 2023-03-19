import java.sql.*;

public class NavigatingQueryResult {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@44.201.88.173:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS" );

            rs.next();

            System.out.println("Region ID on first row is "+ rs.getString(1));
            System.out.println("Region ID on first row is "+ rs.getString("REGION_ID"));
            System.out.println("Region NAME on first row is "+ rs.getString(2));
            System.out.println("Region NAME on first row is "+ rs.getString("REGION_NAME"));

            rs.next();

            System.out.println("Region NAME on SECOND row is "+ rs.getString("REGION_NAME"));

            rs.next();

            System.out.println("Region NAME on THIRD row is "+ rs.getString("REGION_NAME"));

            System.out.println("DO WE HAVE MORE DATA"+rs.next());

            System.out.println("Region NAME on FOURTH row is "+ rs.getString("REGION_NAME"));

            System.out.println("DO WE HAVE MORE DATA"+rs.next());

           // System.out.println("Region NAME on AFTER LAST row is "+ rs.getString("REGION_NAME"));

           // rs.previous();




        } catch (SQLException e) {
            System.out.println("ERROR HAS OCCURRED");
        }
    }
}
