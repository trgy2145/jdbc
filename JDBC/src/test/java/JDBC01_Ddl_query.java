import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC01_Ddl_query{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC","root","1234");
        Statement st =  con.createStatement();
        String isDrop = "DROP TABLE isciler";

        String result = st.execute(isDrop) ? "table was deleted" : "table was not deleted";
        System.out.println(result);

        String createTable = "CREATE TABLE isciler" + "(id INT ," + "birim VARCHAR(10)," + "maas INT)";
        st.execute(createTable);

        String result1 = st.execute(createTable) ? "table was not created" :"table was created";
        System.out.println(result1);

        String insertData = "INSERT INTO isciler (80,'ARGE', 4000";
        int number = st.executeUpdate(insertData);
        System.out.println("islemden etkielenen satır sayısı :" + number);

       // method 1
        String[] datas = {"INSERT INTO isciler (80,'ARGE', 5000","INSERT INTO isciler (80,'LAB', 6000",
                          "INSERT INTO isciler (80,'HR', 7000","INSERT INTO isciler (30,'LAB', 6000"};
        int count = 0 ;
        for (String each : datas) {

            count += st.executeUpdate(each);
        }
        System.out.println("the number of added row" + count);

        // method 2
        String[] datas2 = {"INSERT INTO isciler (40,'ARGE', 5000","INSERT INTO isciler (60,'LAB', 6000",
                "INSERT INTO isciler (80,'HR', 7000","INSERT INTO isciler (30,'LAB', 6000"};


        for (String each : datas2) {
            st.addBatch(each);   // bütün veriler icin bir depo acar ve tek tek deil topluca executeBATCh() e gönderir.
        }
        st.executeBatch();
        System.out.println("every row were added..");

        System.out.println("*******************************************************");

        String update = "UPDATE isciler " + "SET maas = maas*1.1" + "WHERE maas < 5000";

        int row = st.executeUpdate(update);
        System.out.println(row + "were updated");


        con.close();
        st.close();
    }
}
