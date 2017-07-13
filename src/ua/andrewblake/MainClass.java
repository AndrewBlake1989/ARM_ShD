package ua.andrewblake;

import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.utils.ConnectionToMySQL;

import java.sql.Connection;

public class MainClass {
    public static void main(String[] args) {
        Connection connection = ConnectionToMySQL.getConnectionToMySQL();
        if (connection == null) {
            GlobalSettings.setAvailabilityConnectionWithBD(false);
        } else {
            GlobalSettings.setAvailabilityConnectionWithBD(true);
        }
        Frame.main(null);
    }
}
