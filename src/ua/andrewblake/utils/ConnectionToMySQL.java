package ua.andrewblake.utils;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import ua.andrewblake.settings.ConnectionSettings;

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
                ConnectionSettings connectionSettings = SerializeConnectionSettings.deserialize();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("jdbc:mysql://");
                stringBuilder.append(connectionSettings.ip1);
                stringBuilder.append(".");
                stringBuilder.append(connectionSettings.ip2);
                stringBuilder.append(".");
                stringBuilder.append(connectionSettings.ip3);
                stringBuilder.append(".");
                stringBuilder.append(connectionSettings.ip4);
                stringBuilder.append(":");
                stringBuilder.append(connectionSettings.port);
                stringBuilder.append("/");
                stringBuilder.append(connectionSettings.nameDB);
                connectionToMySQL = DriverManager.getConnection(stringBuilder.toString(), connectionSettings.username, connectionSettings.password);
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
