package ua.andrewblake.save;

import java.io.Serializable;
import java.sql.Blob;

public class BackupDataBase implements Serializable {

    public String[][] equipmentTechnicalPoints;
    public String[][] peregons;
    public String[][] positions;
    public String[][] shch;
    public String[][] users;
    public String[][] stations;
    public String[][] records;
    public Stat[] stats;

}
