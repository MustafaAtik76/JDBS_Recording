import java.sql.*;

public class LoopingResultSet {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@44.201.88.173:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS" );

           //  next method is moving the cursor to the next line and returning true false according to whether we have next row

            while (rs.next()) {

                System.out.println(rs.getString(1) + " | " + rs.getString(2));
            }
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println("ROW NUMBER IS " + rs.getRow());
                System.out.println(rs.getString(1) + " | " + rs.getString(2));
            }

            // getting row count ---> move cursor to the last row and get the row number

            rs.last();
            System.out.println("ROW NUMBER IS " + rs.getRow());


        } catch (SQLException e) {
            System.out.println("ERROR HAS OCCURRED");
        }
    }
}
