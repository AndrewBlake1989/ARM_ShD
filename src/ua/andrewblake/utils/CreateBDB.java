package ua.andrewblake.utils;

import ua.andrewblake.exceptions.FailureLoadDataFromDatabaseException;
import ua.andrewblake.save.BackupDataBase;
import ua.andrewblake.save.Stat;

import java.sql.*;

public class CreateBDB {

    private static BackupDataBase bdb;

    public static BackupDataBase create() throws FailureLoadDataFromDatabaseException {
        bdb = new BackupDataBase();
        fillUsers();
        fillEquipmentTechnicalPoints();
        fillPeregons();
        fillStations();
        fillRecords();
        return bdb;
    }

    private static void fillUsers() throws FailureLoadDataFromDatabaseException {
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            statement.executeQuery("LOCK TABLE users READ;");
            int rowCount = 0;
            ResultSet res = statement.executeQuery("SELECT COUNT(*) FROM users;");
            while (res.next()) {
                rowCount = res.getInt(1);
            }
            if (rowCount == 2) {
                bdb.users = null;
                return;
            }
            String[][] users = new String[rowCount - 2][6];
            res = statement.executeQuery("SELECT * FROM users;");
            int i = 0;
            while (res.next()) {
                if ((i == 0) || (i == 1)) {
                    i++;
                    continue;
                }
                for (int j = 0; j < 6; j++) {
                    users[i - 2][j] = res.getString(j + 1);
                }
                i++;
            }
            statement.executeQuery("UNLOCK TABLES;");
            bdb.users = users;
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        }
    }

    private static void fillEquipmentTechnicalPoints() throws FailureLoadDataFromDatabaseException {
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            String[][] equipmentTechnicalPoints = new String[451][11];
            statement.executeQuery("LOCK TABLE equipment_technical_points READ;");
            ResultSet res = statement.executeQuery("SELECT * FROM equipment_technical_points ;");
            int i = 0;
            while (res.next()) {
                for (int j = 0; j < 11; j++) {
                    equipmentTechnicalPoints[i][j] = res.getString(j + 1);
                }
                i++;
            }
            statement.executeQuery("UNLOCK TABLES;");
            bdb.equipmentTechnicalPoints = equipmentTechnicalPoints;
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        }
    }

    private static void fillPeregons() throws FailureLoadDataFromDatabaseException {
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            statement.executeQuery("LOCK TABLE peregons READ;");
            int rowCount = 0;
            ResultSet res = statement.executeQuery("SELECT COUNT(*) FROM peregons;");
            while (res.next()) {
                rowCount = res.getInt(1);
            }
            String[][] peregons = new String[rowCount][4];
            res = statement.executeQuery("SELECT * FROM peregons;");
            int i = 0;
            while (res.next()) {
                for (int j = 0; j < 4; j++) {
                    peregons[i][j] = res.getString(j + 1);
                }
                i++;
            }
            statement.executeQuery("UNLOCK TABLES;");
            bdb.peregons = peregons;
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        }
    }

    private static void fillStations() throws FailureLoadDataFromDatabaseException {
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            statement.executeQuery("LOCK TABLE stations READ;");
            int rowCount = 0;
            ResultSet res = statement.executeQuery("SELECT COUNT(*) FROM stations;");
            while (res.next()) {
                rowCount = res.getInt(1);
            }
            String[][] stations = new String[rowCount][4];
            res = statement.executeQuery("SELECT * FROM stations;");
            int i = 0;
            while (res.next()) {
                for (int j = 0; j < 4; j++) {
                    stations[i][j] = res.getString(j + 1);
                }
                i++;
            }
            statement.executeQuery("UNLOCK TABLES;");
            bdb.stations = stations;
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        }
    }

    private static void fillRecords() throws FailureLoadDataFromDatabaseException {
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            statement.executeQuery("LOCK TABLE records READ;");
            int rowCount = 0;
            ResultSet res = statement.executeQuery("SELECT COUNT(*) FROM records;");
            while (res.next()) {
                rowCount = res.getInt(1);
            }
            String[][] records = new String[rowCount][8];
            Stat[] stats = new Stat[rowCount];
            res = statement.executeQuery("SELECT * FROM records;");
            int i = 0;
            while (res.next()) {
                for (int j = 0; j < 8; j++) {
                    records[i][j] = res.getString(j + 1);
                }
                stats[i] = SerializeToBlob.fromBlobToStat(res.getBlob(9));
                i++;
            }
            statement.executeQuery("UNLOCK TABLES;");
            bdb.records = records;
            bdb.stats = stats;
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        }
    }
}
