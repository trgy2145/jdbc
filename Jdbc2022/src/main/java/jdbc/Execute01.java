package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //  1. adım drivere kayıt ol
        Class.forName("org.postgresql.Driver");

        //2.adım database baglan
       Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/wisequarter","postgres","1234");
        
        //3.adım statement olustur
        Statement st = con.createStatement();

        // 4 adım query calıstır

        // 1.örnek "workers" adında bir table olustur "worker_id,worker_name,worker_salary" sütünları ekle
        String sql1 = "CREATE table workers(worker_id VARCHAR(50),worker_name VARCHAR(50), worker_salary INT)";
        st.execute(sql1);

        // 2.örnek table worker_address sütunu ekle

        String sql2 = "ALTER table workers ADD worker_address varchar(80)";
        st.execute(sql2);

        // 3.örnek Drop ile table sil
         String sql3 = "DROP table workers";

         // 4 . baglantı ve statemant kapat.
        con.close();
        st.close();

    }
}
