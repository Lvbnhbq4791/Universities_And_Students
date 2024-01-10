import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/universityInfo.xlsx");
        ReadingFile readingFile = ReadingFile.getReadingFile();
        readingFile.fileProcessing(file);
        for (Student student :readingFile.readingSheetStudent()){
            System.out.println(student);
        }
        System.out.println("---------------------------------------------------------------");
        for (University university :readingFile.readingSheetUniversity()){
            System.out.println(university);
        }
    }
}
