package recording;

import model.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.apache.poi.ss.util.CellUtil.createCell;

public class XlsWriter {
    private static XlsWriter classXlsWriter;
    private String textName;
    private int textSize;

    private XlsWriter() {
    }

    public XlsWriter setTextName(String textName) {
        this.textName = textName;
        return this;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public static XlsWriter getClassXlsWriter() {
        if (classXlsWriter == null) {
            classXlsWriter = new XlsWriter();
        }
        return classXlsWriter;
    }
    //Метод генерации таблицы
    public void generationExcel(List<Statistics> statisticsList, File file, List<String> tableHeaders) {
        try (XSSFWorkbook wbStatistics = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(file);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOut)) {
            XSSFSheet sheet1 = wbStatistics.createSheet("Статистика");
            XSSFRow rowHeaders = sheet1.createRow(0);
            //Запись заголовков в таблицу
            for (int a = 0; a < tableHeaders.size(); a++) {
                createCell(rowHeaders, a, tableHeaders.get(a), setStyle(wbStatistics, true, -1,false));
                sheet1.autoSizeColumn(a);
            }
            //Запись значений в таблицу
            int temp = 1;
            for (Statistics statistics : statisticsList) {
                XSSFRow rowValue = sheet1.createRow(temp++);
                XSSFCell cellValue0 = rowValue.createCell(0);
                cellValue0.setCellStyle(setStyle(wbStatistics, false, -1,false));
                cellValue0.setCellValue(statistics.getTrainingProfile().toString());

                XSSFCell cellValue1 = rowValue.createCell(1);
                cellValue1.setCellStyle(setStyle(wbStatistics, false, 2,false));
                cellValue1.setCellValue(statistics.getAverageExamScore());

                XSSFCell cellValue2 = rowValue.createCell(2);
                cellValue2.setCellStyle(setStyle(wbStatistics, false, 1,false));
                cellValue2.setCellValue(statistics.getNumbersStudents());

                XSSFCell cellValue3 = rowValue.createCell(3);
                cellValue3.setCellStyle(setStyle(wbStatistics, false, 1,false));
                cellValue3.setCellValue(statistics.getNumbersUniversities());

                XSSFCell cellValue4 = rowValue.createCell(4);
                cellValue4.setCellStyle(setStyle(wbStatistics, false, -1,true));
                cellValue4.setCellValue(statistics.getNamesUniversities());

            }
            wbStatistics.write(bufferedOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Метод реализации форматирования ячейки
    public CellStyle setStyle(XSSFWorkbook wbStatistics, boolean bold, int numberFormat,boolean inHeight) {
        XSSFFont font = wbStatistics.createFont();
        CellStyle style = wbStatistics.createCellStyle();
        font.setFontName(textName);
        font.setFontHeight(textSize);
        font.setBold(bold);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        if(inHeight){
            style.setVerticalAlignment(VerticalAlignment.JUSTIFY);
        }else {
            style.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        if (numberFormat >= 0) {
            style.setDataFormat((short) numberFormat);
            return style;
        }
        return style;
    }

}
