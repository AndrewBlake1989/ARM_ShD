package ua.andrewblake.exceptions;

public class AccessingFileException extends FailedToCreateReportException {

    private String fileName;

    public AccessingFileException(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
