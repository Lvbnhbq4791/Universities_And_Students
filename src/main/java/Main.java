import comparator.ComparatorStudent;
import comparator.ComparatorUniversity;
import enums.ValuesStudent;
import enums.ValuesUniversity;
import objects.Student;
import objects.University;
import reader.ReadingFile;
import util.JsonUtil;
import util.MapsComparators;
import util.TypeComporator;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/universityInfo.xlsx");
        ReadingFile classReadingFile = ReadingFile.getClassReadingFile();
        classReadingFile.readingFile(file);
        JsonUtil classJsonUtil = JsonUtil.getClassJsonUtil();
    //код для object Student
        Map<ValuesStudent, ComparatorStudent> mapStudent = new MapsComparators().getMapComparatorsStudent();
        List<Student> objectsStudent = classReadingFile.readingSheetStudent().stream()
                .sorted(TypeComporator.getComparatorStudent(mapStudent, ValuesStudent.FULL_NAME))
                .toList();
        String jsonListStudent = classJsonUtil.serializationListStudent(objectsStudent);
        System.out.println(jsonListStudent);
        List<Student> newObjectsStudent = classJsonUtil.deserializationListStudent(jsonListStudent);
        if(objectsStudent.size() == newObjectsStudent.size()){
            System.out.println("Размеры списков равны");
            streamStudent(objectsStudent,classJsonUtil);
        }
    //код для object University
        Map<ValuesUniversity, ComparatorUniversity> mapUniversity = new MapsComparators().getMapComparatorsUniversity();
        List<University> objectsUniversity = classReadingFile.readingSheetUniversity().stream()
                .sorted(TypeComporator.getComparatorUniversity(mapUniversity, ValuesUniversity.PROFILE_NAME))
                .toList();
        String jsonListUniversity = classJsonUtil.serializationListUniversity(objectsUniversity);
        System.out.println(jsonListUniversity);
        List<University> newObjectsUniversity = classJsonUtil.deserializationListUniversity(jsonListUniversity);
        if(objectsUniversity.size() == newObjectsUniversity.size()){
            System.out.println("Размеры списков равны");
            streamUniversity(objectsUniversity,classJsonUtil);
        }
    }
    public static void streamStudent(List<Student> objectsStudent,JsonUtil classJsonUtil){
        objectsStudent.stream()
                .limit(3)
                .map(classJsonUtil::serializationObjectStudent)
                .peek(System.out::println)
                .map(classJsonUtil::deserializationObjectStudent)
                .forEach(System.out::println);
    }
    public static void streamUniversity(List<University> objectsUniversity,JsonUtil classJsonUtil){
        objectsUniversity.stream()
                .limit(3)
                .map(classJsonUtil::serializationObjectUniversity)
                .peek(System.out::println)
                .map(classJsonUtil::deserializationObjectUniversity)
                .forEach(System.out::println);
    }
}
