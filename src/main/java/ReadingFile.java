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
    private static ReadingFile classReadingFile;
    private List<Student> listStudents;
    private List<University> listUniversities;
    private XSSFSheet sheetStudents;
    private XSSFSheet sheetUniversities;

    private ReadingFile() {
        this.listStudents = new ArrayList<>();
        this.listUniversities = new ArrayList<>();
    }

    public static ReadingFile getClassReadingFile() {
        if (classReadingFile == null) {
            classReadingFile = new ReadingFile();
        }
        return classReadingFile;
    }

    public void readingFile(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);
            sheetStudents = workbook.getSheet("Студенты");
            sheetUniversities = workbook.getSheet("Университеты");
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
                listStudents.add(student);
            }
        } else {
            System.out.println("Лист пустой или отсутствует");
        }
        return listStudents;
    }

    public List<University> readingSheetUniversity() {
        if (sheetUniversities != null) {
            Iterator<Row> iter = sheetUniversities.iterator();
            iter.next();
            while (iter.hasNext()) {
                XSSFRow row = (XSSFRow) iter.next();
                University university = new University()
                        .setId(row.getCell(0).getStringCellValue())
                        .setFullName(row.getCell(1).getStringCellValue())
                        .setShortName(row.getCell(2).getStringCellValue())
                        .setYearOfFoundation((int) row.getCell(3).getNumericCellValue())
                        .setMainProfile(StudyProfile.valueOf(row.getCell(4).getStringCellValue()));
                listUniversities.add(university);
            }
        } else {
            System.out.println("Лист пустой или отсутствует");
        }
        return listUniversities;
    }
}
