package jdbc;

import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/wisequarter", "postgres", "1234");
        Statement st = con.createStatement();

        // 1.örnek region id si 1 olan "country name" degerlerini cagırın
      String sql1 = "select country_name from countries where region_id = 1";

       //  st.execute(sql1);

        // recordları görmek icin executeQuery methodunu kullan..

        ResultSet result1 = st.executeQuery(sql1);

        while (result1.next()){
            System.out.println(result1.getString("country_name"));
        }

        //2.örnek "region_id" si 2 den büyük olan "country_id" ve "country_name" değerlerini cagırın

      String sql2 = "select country_id, country_name from countries where region_id > 2";

        ResultSet result2 = st.executeQuery(sql2);

        while(result2.next()){
            System.out.println(result2.getString("country_id")+"===>"+result2.getString("country_name"));
        }

        // 3.SORU companies tablosundan "number_of_employees" değeri en küçük olanın tüm satır değerlerini cagır


        String sql3 = "select *  from companies where number_of_employees =  (select min(number_of_employees) from companies)";

        ResultSet result3 = st.executeQuery(sql3);

        while(result3.next()){
            System.out.println((result3.getInt("company_id") + "--" + result3.getString("company")
                    + "--" + result3.getInt("number_of_employees")));
        }

        con.close();
        st.close();

    }
}
