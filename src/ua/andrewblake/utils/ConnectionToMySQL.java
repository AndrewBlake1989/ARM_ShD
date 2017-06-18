package ua.andrewblake.utils;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;

public class ConnectionToMySQL {

    private ConnectionToMySQL() {}

    private static Connection connectionToMySQL = null;
    private static Statement statementForMySQL = null;

    public static Connection getConnectionToMySQL() {
        if(connectionToMySQL == null) {
            try {
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
                connectionToMySQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/arm_shd_database", "root", "password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connectionToMySQL;
    }

    public static Statement getStatementForMySQL() {
        if(statementForMySQL == null) {
            try {
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
                statementForMySQL = connectionToMySQL.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return statementForMySQL;
    }

    public static void closeConnectionToMySQL() {
        try {
            connectionToMySQL.close();
        } catch (SQLException e) {
            //NOP
        }
    }
}
