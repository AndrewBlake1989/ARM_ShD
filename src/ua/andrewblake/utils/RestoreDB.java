package ua.andrewblake.utils;

import ua.andrewblake.exceptions.AccessingFileException;
import ua.andrewblake.exceptions.FailureLoadDataFromDatabaseException;
import ua.andrewblake.save.BackupDataBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class RestoreDB {

    private static BackupDataBase bdb;
    private static Connection connection;

    public static void restoreDB(BackupDataBase bdb) throws FailureLoadDataFromDatabaseException, AccessingFileException {
        connection = ConnectionToMySQL.getConnectionToMySQL();
        RestoreDB.bdb = bdb;
//        restoreShCh();
//        restorePositions();
        restoreUsers();
        restoreEquipmentTechnicalPoints();
        restorePeregons();
        restoreStations();
        restoreRecords();

    }

    private static void restoreShCh() throws FailureLoadDataFromDatabaseException {
        try {
            for (int row = 0; row < bdb.shch.length; row++) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO shch (id, name, code, deleted) values (?, ?, ?, ?);");
                preparedStatement.setString(1, bdb.shch[row][0]);
                preparedStatement.setString(2, bdb.shch[row][1]);
                preparedStatement.setString(3, bdb.shch[row][2]);
                preparedStatement.setString(4, bdb.shch[row][3]);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        }
    }

    private static void restorePositions() throws FailureLoadDataFromDatabaseException {
        try {
            for (int row = 0; row < bdb.positions.length; row++) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO positions (id, position_full, position_short) values (?, ?, ?);");
                preparedStatement.setString(1, bdb.positions[row][0]);
                preparedStatement.setString(2, bdb.positions[row][1]);
                preparedStatement.setString(3, bdb.positions[row][2]);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        }
    }

    private static void restoreUsers() throws FailureLoadDataFromDatabaseException {
        if (bdb.users == null) {return;}
        try {
            for (int row = 0; row < bdb.users.length; row++) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (id, access_id, name, position, administrator, deleted) values (?, ?, ?, ?, ?, ?);");
                preparedStatement.setString(1, bdb.users[row][0]);
                preparedStatement.setString(2, bdb.users[row][1]);
                preparedStatement.setString(3, bdb.users[row][2]);
                preparedStatement.setString(4, bdb.users[row][3]);
                preparedStatement.setString(5, bdb.users[row][4]);
                preparedStatement.setString(6, bdb.users[row][5]);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        }
    }

    private static void restoreEquipmentTechnicalPoints() throws FailureLoadDataFromDatabaseException {
        try {
            for (int row = 0; row < bdb.equipmentTechnicalPoints.length; row++) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO equipment_technical_points (id, year, shch, ec, klz, ab, rpb, ps, gac, dc, other) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
                preparedStatement.setString(1, bdb.equipmentTechnicalPoints[row][0]);
                preparedStatement.setString(2, bdb.equipmentTechnicalPoints[row][1]);
                preparedStatement.setString(3, bdb.equipmentTechnicalPoints[row][2]);
                preparedStatement.setString(4, bdb.equipmentTechnicalPoints[row][3]);
                preparedStatement.setString(5, bdb.equipmentTechnicalPoints[row][4]);
                preparedStatement.setString(6, bdb.equipmentTechnicalPoints[row][5]);
                preparedStatement.setString(7, bdb.equipmentTechnicalPoints[row][6]);
                preparedStatement.setString(8, bdb.equipmentTechnicalPoints[row][7]);
                preparedStatement.setString(9, bdb.equipmentTechnicalPoints[row][8]);
                preparedStatement.setString(10, bdb.equipmentTechnicalPoints[row][9]);
                preparedStatement.setString(11, bdb.equipmentTechnicalPoints[row][10]);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        }
    }

    private static void restorePeregons() throws FailureLoadDataFromDatabaseException {
        try {
            for (int row = 0; row < bdb.peregons.length; row++) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO peregons (id, name, shch, closed) values (?, ?, ?, ?);");
                preparedStatement.setString(1, bdb.peregons[row][0]);
                preparedStatement.setString(2, bdb.peregons[row][1]);
                preparedStatement.setString(3, bdb.peregons[row][2]);
                preparedStatement.setString(4, bdb.peregons[row][3]);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        }
    }

    private static void restoreStations() throws FailureLoadDataFromDatabaseException {
        try {
            for (int row = 0; row < bdb.stations.length; row++) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO stations (id, name, shch, closed) values (?, ?, ?, ?);");
                preparedStatement.setString(1, bdb.stations[row][0]);
                preparedStatement.setString(2, bdb.stations[row][1]);
                preparedStatement.setString(3, bdb.stations[row][2]);
                preparedStatement.setString(4, bdb.stations[row][3]);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        }
    }

    private static void restoreRecords() throws FailureLoadDataFromDatabaseException, AccessingFileException {
        try {
            for (int row = 0; row < bdb.records.length; row++) {
                SerializeToBlob.serialize(bdb.stats[row]);
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO records (id, date, number_of_record, dist, department, first_create, edited, deleted, file_record) values (?, ?, ?, ?, ?, ?, ?, ?, ?);");
                preparedStatement.setString(1, bdb.records[row][0]);
                preparedStatement.setString(2, bdb.records[row][1]);
                preparedStatement.setString(3, bdb.records[row][2]);
                preparedStatement.setString(4, bdb.records[row][3]);
                preparedStatement.setString(5, bdb.records[row][4]);
                preparedStatement.setString(6, bdb.records[row][5]);
                preparedStatement.setString(7, bdb.records[row][6]);
                preparedStatement.setString(8, bdb.records[row][7]);
                preparedStatement.setBlob(9, new FileInputStream("src/ua/andrewblake/save/SaveStatToBlob.svf"));
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(0);
        } catch (FileNotFoundException e) {
            throw new AccessingFileException("Stat");
        }
    }


}
