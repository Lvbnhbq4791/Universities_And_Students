import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/universityInfo.xlsx");
        ReadingFile classReadingFile = ReadingFile.getClassReadingFile();
        classReadingFile.readingFile(file);
        Map<ValuesStudent, ComparatorStudent> mapStudent = new MapsComparators().getMapComparatorsStudent();
        classReadingFile.readingSheetStudent().stream()
                .sorted(TypeComporator.getComparatorStudent(mapStudent, ValuesStudent.FULL_NAME))
                .forEach(System.out::println);
        Map<ValuesUniversity, ComparatorUniversity> mapUniversity = new MapsComparators().getMapComparatorsUniversity();
        classReadingFile.readingSheetUniversity().stream()
                .sorted(TypeComporator.getComparatorUniversity(mapUniversity, ValuesUniversity.PROFILE_NAME))
                .forEach(System.out::println);
    }
}
