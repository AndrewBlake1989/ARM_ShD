package ua.andrewblake.temporary;

import ua.andrewblake.utils.ConnectionToMySQL;

import java.sql.*;

/**
 * Created by AndrewBlake on 08.05.2017.
 */
public class TestMySQL {
    public static void main(String[] args) {
        Connection connection = ConnectionToMySQL.getConnectionToMySQL();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select count(*) from `test_table`;";
            ResultSet res = statement.executeQuery(query);
            int count = 0;
            while (res.next()) {
                count = res.getInt(1);
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
