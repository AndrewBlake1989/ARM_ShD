package ua.andrewblake.exceptions;

/**
 * Created by AndrewBlake on 14.06.2017.
 */
public class FailureLoadDataFromDatabaseException extends FailedToCreateReportException {

    private int type;

    public FailureLoadDataFromDatabaseException(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
