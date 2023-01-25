package jdbc;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //  1. adım drivere kayıt ol
        Class.forName("org.postgresql.Driver");

        //2.adım database baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/wisequarter","postgres","1234");

        //3.adım statement olustur
        Statement st = con.createStatement();
        //companies tablosundan en yüksek ikinci number_of_employees değeri
        // olan company ve number_of_employees cagır

        String sql1 = "select company,number_of_employees from companies\n" +
                "Order by number_of_employees desc\n" +
                "offset 1 row\n" +
                "fetch next 1 row only;";

        ResultSet result1 = st.executeQuery(sql1);

        while(result1.next()){
            System.out.println((result1.getString(1) + "--->" + result1.getInt(2)));
        }

        // 2. yol sub query ile
        String sql2= "select company,number_of_employees \n" +
                "from companies\n" +
                "where number_of_employees = (select max(number_of_employees) \n" +
                "                            from companies \n" +
                "                            where number_of_employees < (select max(number_of_employees) \n" +
                "\t\t\t\t\t\t\tfrom companies ));";

        ResultSet result2 = st.executeQuery(sql2);

        while(result2.next()){
            System.out.println((result2.getString(1) + "--->" + result2.getInt(2)));
        }
        con.close();
        st.close();
        result1.close();
        result2.close();
    }
}
