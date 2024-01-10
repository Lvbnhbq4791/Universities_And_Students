import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadingFile {
    private static ReadingFile readingFile;
    private final List<Student> studentsList;
    private final List<University> universityList;
    private XSSFSheet sheetStudents;
    private XSSFSheet sheetUniversity;

    private ReadingFile() {
        this.studentsList = new ArrayList<>();
        this.universityList = new ArrayList<>();
    }

    public static ReadingFile getReadingFile() {
        if (readingFile == null) {
            readingFile = new ReadingFile();
        }
        return readingFile;
    }

    public void fileProcessing(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 1000);
            XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);
            sheetStudents = workbook.getSheet("Студенты");
            sheetUniversity = workbook.getSheet("Университеты");
        } catch (Exception e) {
            System.out.println("Файл не найден");
        }
    }

    public List<Student> readingSheetStudent() {
        if (sheetStudents != null) {
            Iterator<Row> iter = sheetStudents.iterator();
            iter.next();
            while (iter.hasNext()) {
                XSSFRow row = (XSSFRow) iter.next();
                Student student = new Student()
                        .setFullName(row.getCell(1).getStringCellValue())
                        .setUniversityId(row.getCell(0).getStringCellValue())
                        .setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue())
                        .setAvgExamScore((float) row.getCell(3).getNumericCellValue());
                studentsList.add(student);
            }
        } else {
            System.out.println("Лист пустой или отсутствует");
        }
        return studentsList;
    }

    public List<University> readingSheetUniversity() {
        if (sheetUniversity != null) {
            Iterator<Row> iter = sheetUniversity.iterator();
            iter.next();
            while (iter.hasNext()) {
                XSSFRow row = (XSSFRow) iter.next();
                University university = new University()
                        .setId(row.getCell(0).getStringCellValue())
                        .setFullName(row.getCell(1).getStringCellValue())
                        .setShortName(row.getCell(2).getStringCellValue())
                        .setYearOfFoundation((int) row.getCell(3).getNumericCellValue())
                        .setMainProfile(StudyProfile.valueOf(row.getCell(4).getStringCellValue()));
                universityList.add(university);
            }
        } else {
            System.out.println("Лист пустой или отсутствует");
        }
        return universityList;
    }
}
