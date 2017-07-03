package ua.andrewblake.version;

import java.io.Serializable;

public class Version implements Serializable {
    public String sVersion;
    public int countVersion;
    public String sDate;

    public Version(String sVersion, int countVersion, String sDate) {
        this.sVersion = sVersion;
        this.countVersion = countVersion;
        this.sDate = sDate;
    }
}
