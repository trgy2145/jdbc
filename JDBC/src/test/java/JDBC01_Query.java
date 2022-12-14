import java.sql.*;

public class JDBC01_Query {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1) ilgili dirver yükle

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // baglantı kur
       //  String connectionUrl = (""jdbc:mysql://localhost:3306/sys?serverTimezone=UTC","root","passwp"");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC","root","1234");

        // 3- sql sorguları icin kendimizebir alan acıyoruz
         Statement st =  con.createStatement();
         // dataları alıp bir sete atıyoruz
        ResultSet data = st.executeQuery("SELECT * FROM CALISANLAR");

        while(data.next()){
            System.out.println(data.getInt("ID")+" "+data.getString("AD")+ " "+data.getString("SOYAD")+
                    " "+ data.getInt("MAAS")+" "+data.getString("SIRKET"));
        }
        con.close();
        st.close();
        data.close();

    }

}
