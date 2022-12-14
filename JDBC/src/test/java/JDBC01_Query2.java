import java.sql.*;

public class JDBC01_Query2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC","root","1234");

        Statement st = con.createStatement();
        ResultSet data = st.executeQuery("SELECT ADI,SAYAD FROM CALISANLAR WHERE SIRKET ='TOYOTA'");

        while(data.next()){
            System.out.println(data.getString("AD")+" "+ data.getString("SOYAD"));
        }



    }
}
