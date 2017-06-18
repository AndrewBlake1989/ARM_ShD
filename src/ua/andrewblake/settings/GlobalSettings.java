package ua.andrewblake.settings;

import ua.andrewblake.panels.*;
import ua.andrewblake.save.Stat;

import javax.swing.*;

public class GlobalSettings {

    private static JFrame frame = null;
    private static boolean availabilityConnectionWithBD = false;
    private static int userID = 0;
    private static String userName = "";
    private static int userPosition = 0;
    private static boolean userIsAdministrator = false;
    private static Stat currentStat;

    private static PanelNoConnection panelNoConnection;
    private static PanelAuthorization panelAuthorization;
    private static PanelMain panelMain;
    private static PanelIntroductionError panelIntroductionError;
    private static PanelIntroductionError2 panelIntroductionError2;
    private static PanelIntroductionError3 panelIntroductionError3;
    private static PanelPreviousView panelPreviousView;
    private static PanelListOfRecordsFromBase panelListOfRecordsFromBase;
    private static PanelViewRecord panelViewRecord;
    private static PanelViewOrEditCatalogues panelViewOrEditCatalogues;
    private static PanelCatalogueStations panelCatalogueStations;
    private static PanelCataloguePeregons panelCataloguePeregons;
    private static PanelCatalogueUsers panelCatalogueUsers;
    private static PanelReportGenerating panelReportGenerating;
    private static PanelCatalogueEquipmentTechnicalPoints panelCatalogueEquipmentTechnicalPoints;





    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        GlobalSettings.frame = frame;
    }

    public static boolean isAvailabilityConnectionWithBD() {
        return availabilityConnectionWithBD;
    }

    public static void setAvailabilityConnectionWithBD(boolean availabilityConnectionWithBD) {
        GlobalSettings.availabilityConnectionWithBD = availabilityConnectionWithBD;
    }

    public static int getUserID() {
        return userID;
    }

    public static void setUserID(int userID) {
        GlobalSettings.userID = userID;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        GlobalSettings.userName = userName;
    }

    public static int getUserPosition() {
        return userPosition;
    }

    public static void setUserPosition(int userPosition) {
        GlobalSettings.userPosition = userPosition;
    }

    public static boolean isUserIsAdministrator() {
        return userIsAdministrator;
    }

    public static void setUserIsAdministrator(boolean userIsAdministrator) {
        GlobalSettings.userIsAdministrator = userIsAdministrator;
    }

    public static Stat getCurrentStat() {
        return currentStat;
    }

    public static void setCurrentStat(Stat currentStat) {
        GlobalSettings.currentStat = currentStat;
    }

    public static PanelNoConnection getPanelNoConnection() {
        return panelNoConnection;
    }

    public static void setPanelNoConnection(PanelNoConnection panelNoConnection) {
        GlobalSettings.panelNoConnection = panelNoConnection;
    }

    public static PanelAuthorization getPanelAuthorization() {
        return panelAuthorization;
    }

    public static void setPanelAuthorization(PanelAuthorization panelAuthorization) {
        GlobalSettings.panelAuthorization = panelAuthorization;
    }

    public static PanelMain getPanelMain() {
        return panelMain;
    }

    public static void setPanelMain(PanelMain panelMain) {
        GlobalSettings.panelMain = panelMain;
    }

    public static PanelIntroductionError getPanelIntroductionError() {
        return panelIntroductionError;
    }

    public static void setPanelIntroductionError(PanelIntroductionError panelIntroductionError) {
        GlobalSettings.panelIntroductionError = panelIntroductionError;
    }

    public static PanelIntroductionError2 getPanelIntroductionError2() {
        return panelIntroductionError2;
    }

    public static void setPanelIntroductionError2(PanelIntroductionError2 panelIntroductionError2) {
        GlobalSettings.panelIntroductionError2 = panelIntroductionError2;
    }

    public static PanelIntroductionError3 getPanelIntroductionError3() {
        return panelIntroductionError3;
    }

    public static void setPanelIntroductionError3(PanelIntroductionError3 panelIntroductionError3) {
        GlobalSettings.panelIntroductionError3 = panelIntroductionError3;
    }

    public static PanelPreviousView getPanelPreviousView() {
        return panelPreviousView;
    }

    public static void setPanelPreviousView(PanelPreviousView panelPreviousView) {
        GlobalSettings.panelPreviousView = panelPreviousView;
    }

    public static PanelListOfRecordsFromBase getPanelListOfRecordsFromBase() {
        return panelListOfRecordsFromBase;
    }

    public static void setPanelListOfRecordsFromBase(PanelListOfRecordsFromBase panelListOfRecordsFromBase) {
        GlobalSettings.panelListOfRecordsFromBase = panelListOfRecordsFromBase;
    }

    public static PanelViewRecord getPanelViewRecord() {
        return panelViewRecord;
    }

    public static void setPanelViewRecord(PanelViewRecord panelViewRecord) {
        GlobalSettings.panelViewRecord = panelViewRecord;
    }

    public static PanelViewOrEditCatalogues getPanelViewOrEditCatalogues() {
        return panelViewOrEditCatalogues;
    }

    public static void setPanelViewOrEditCatalogues(PanelViewOrEditCatalogues panelViewOrEditCatalogues) {
        GlobalSettings.panelViewOrEditCatalogues = panelViewOrEditCatalogues;
    }

    public static PanelCatalogueStations getPanelCatalogueStations() {
        return panelCatalogueStations;
    }

    public static void setPanelCatalogueStations(PanelCatalogueStations panelCatalogueStations) {
        GlobalSettings.panelCatalogueStations = panelCatalogueStations;
    }

    public static PanelCataloguePeregons getPanelCataloguePeregons() {
        return panelCataloguePeregons;
    }

    public static void setPanelCataloguePeregons(PanelCataloguePeregons panelCataloguePeregons) {
        GlobalSettings.panelCataloguePeregons = panelCataloguePeregons;
    }

    public static PanelCatalogueUsers getPanelCatalogueUsers() {
        return panelCatalogueUsers;
    }

    public static void setPanelCatalogueUsers(PanelCatalogueUsers panelCatalogueUsers) {
        GlobalSettings.panelCatalogueUsers = panelCatalogueUsers;
    }

    public static PanelReportGenerating getPanelReportGenerating() {
        return panelReportGenerating;
    }

    public static void setPanelReportGenerating(PanelReportGenerating panelReportGenerating) {
        GlobalSettings.panelReportGenerating = panelReportGenerating;
    }

    public static PanelCatalogueEquipmentTechnicalPoints getPanelCatalogueEquipmentTechnicalPoints() {
        return panelCatalogueEquipmentTechnicalPoints;
    }

    public static void setPanelCatalogueEquipmentTechnicalPoints(PanelCatalogueEquipmentTechnicalPoints panelCatalogueEquipmentTechnicalPoints) {
        GlobalSettings.panelCatalogueEquipmentTechnicalPoints = panelCatalogueEquipmentTechnicalPoints;
    }
}
