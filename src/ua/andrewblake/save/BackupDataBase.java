package ua.andrewblake.save;

import java.io.Serializable;

public class BackupDataBase implements Serializable {

    public String[][] equipmentTechnicalPoints;
    public String[][] peregons;
    public String[][] users;
    public String[][] stations;
    public String[][] records;
    public Stat[] stats;

}
