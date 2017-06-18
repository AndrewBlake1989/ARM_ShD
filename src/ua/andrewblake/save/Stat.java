package ua.andrewblake.save;


import ua.andrewblake.tablemodels.TableModel2_1;
import ua.andrewblake.tablemodels.TableModel4_1;
import ua.andrewblake.tablemodels.TheftResultTableModel;
import ua.andrewblake.tablemodels.TheftTableModel;

import java.io.Serializable;

public class Stat implements Serializable {

    public int dist;
    public int year;
    public byte month;
    public byte day;
    public int numberOfRecord;
    public int department;
    public String[] simpleRecord;
    public String[] createAndEditUsers;
    public String[][] paramsPanelIntroductionError;
    public String[][] paramsPanelTypeOfDeviceOnPanelIntroductionError;
    public String[][] paramsPanelObjectsAndReasons;
    public TheftTableModel theftTableModel;
    public TheftResultTableModel theftResultTableModel;
    public String[] paramsPanelIntroductionError2;
    public TableModel2_1 tableModel2_1;
    public TableModel4_1 tableModel4_1;
    public String additionalData;



}
