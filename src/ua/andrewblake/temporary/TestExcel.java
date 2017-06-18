package ua.andrewblake.temporary;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

/**
 * Created by AndrewBlake on 06.05.2017.
 */
public class TestExcel {
    public static void main(String[] args) {
        Workbook workbook = null;
        try (InputStream inputStream = new FileInputStream("src/ua/andrewblake/excel/123.xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(1);
        cell.setCellValue("qwerty");
        try (FileOutputStream fos = new FileOutputStream("src/ua/andrewblake/excel/1234.xls")){
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
