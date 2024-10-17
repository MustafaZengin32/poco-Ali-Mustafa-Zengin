package firstTest;

import org.junit.Test;

import java.sql.*;

public class Query01 {

    @Test

    public void testName() throws ClassNotFoundException, SQLException {

        //1.Adim--> Driver Tanimlama

        Class.forName("org.postgresql.Driver");

        //2.Adim--> Database'e baglanma

        Connection connection= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbcReview",
                "postgres",
                "Abc1299t."
        );


        //3.Statement
        Statement statement=connection.createStatement();


        //Resultset

        ResultSet resultSet = statement.executeQuery("SELECT * FROM musteriler");//burda herseyi result set e aldik sorgu ile

        //5.Adim:Datalari al ve yazdir//simdi result setteki verileri yazdirmak kaldi

        while(resultSet.next()){

            System.out.format("| %-4d| %-20s | %-20s |\n",
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
            System.out.println("+-----+----------------------+-----------------------+");

        }

        //6.Adim:DB baglantiyi kapatma

        connection.close();

        statement.close();

        resultSet.close();


    }


}
