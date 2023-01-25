package jdbc;

import java.sql.*;

public class Execute03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/wisequarter", "postgres", "1234");

        Statement st = con.createStatement();

       // String sql1 = "insert into talebeler values ('128','Kaan can','Naciye',90)";

      //  st.execute(sql1);

        String sql2 = "select *  from talebeler where id > '125'";

        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()){
            System.out.println((result1.getString("isim") + "----->" + result1.getInt("yazili_notu")));
        }


    }
}
