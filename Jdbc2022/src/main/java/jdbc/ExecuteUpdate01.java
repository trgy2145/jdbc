package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/wisequarter", "postgres", "1234");

        Statement st = con.createStatement();
        // number_of_employees degeri ortalama calısan sayısından az olan number_of_employees 
        //-- degerlerini 16000 olarak update et

        String sql1 = "update companies\n" +
                "set number_of_employees =16000\n" +
                "where number_of_employees < (select avg(number_of_employees)\n" +
                "\t\t\t\t\t\t\tfrom companies);";


        int numberOfRow = st.executeUpdate(sql1);
        System.out.println("numberOfRow = " + numberOfRow);
    }
}
