import comparator.ComparatorStatistics;
import comparator.ComparatorStudent;
import comparator.ComparatorUniversity;
import enums.ValuesStatistics;
import enums.ValuesStudent;
import enums.ValuesUniversity;
import model.Statistics;
import model.Student;
import model.University;
import reading.ReadingFile;
import recording.XlsWriter;
import util.CreatListStatistics;
import util.JsonUtil;
import util.MapsComparators;
import util.TypeComporator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/universityInfo.xlsx");
        ReadingFile classReadingFile = ReadingFile.getClassReadingFile();
        classReadingFile.readingFile(file);
        JsonUtil classJsonUtil = JsonUtil.getClassJsonUtil();
        //Применение Comparator к коллекции объектов класса Student
        Map<ValuesStudent, ComparatorStudent> mapStudent = new MapsComparators().getMapComparatorsStudent();
        List<Student> objectsStudent = classReadingFile.readingSheetStudent().stream()
                .sorted(TypeComporator.getComparatorStudent(mapStudent, ValuesStudent.FULL_NAME))
                .toList();
        //Сериализация коллекции объектов класса Student
        String jsonListStudent = classJsonUtil.serializationListStudent(objectsStudent);
        //Вывод получившихся JSON-строк в консоль
        System.out.println(jsonListStudent);
        List<Student> newObjectsStudent = classJsonUtil.deserializationListStudent(jsonListStudent);
        /*
        Сравнение количества элементов в исходной
        и в десериализованной коллекциях
        */
        if(objectsStudent.size() == newObjectsStudent.size()){
            System.out.println("Размеры списков равны");
        }
        //сериализация отдельных объектов класса Student
        streamStudent(objectsStudent,classJsonUtil);
        //--------------------------------------------
        //Применение Comparator к коллекции объектов класса University
        Map<ValuesUniversity, ComparatorUniversity> mapUniversity = new MapsComparators().getMapComparatorsUniversity();
        List<University> objectsUniversity = classReadingFile.readingSheetUniversity().stream()
                .sorted(TypeComporator.getComparatorUniversity(mapUniversity, ValuesUniversity.PROFILE_NAME))
                .toList();
        //Сериализация коллекции объектов класса University
        String jsonListUniversity = classJsonUtil.serializationListUniversity(objectsUniversity);
        //Вывод получившихся JSON-строк в консоль
        System.out.println(jsonListUniversity);
        /*
        Сравнение количества элементов в исходной
        и в десериализованной коллекциях
        */
        List<University> newObjectsUniversity = classJsonUtil.deserializationListUniversity(jsonListUniversity);
        if(objectsUniversity.size() == newObjectsUniversity.size()){
            System.out.println("Размеры списков равны");
       }
        //сериализация отдельных объектов класса University
        streamUniversity(objectsUniversity,classJsonUtil);
        //------------------------------------------------------
        //Создание коллекции объектов класса Statistics
        CreatListStatistics creatListStatistics = CreatListStatistics.getClassCreatListStatistics();
        Map<ValuesStatistics, ComparatorStatistics> mapStatistics = new MapsComparators().getMapComparatorsStatistics();
        List<Statistics> statisticsList = creatListStatistics.createListStatistics(objectsStudent, objectsUniversity).stream()
                .sorted(TypeComporator.getComparatorStatistics(mapStatistics,ValuesStatistics.TRAINING_PROFILE))
                .toList();
        // Запись объектов класса Statistics в Excel
          //Коллекция названий заголовков таблицы
        List<String> tableHeaders = new ArrayList<>();
        tableHeaders.add("профиль обучения");
        tableHeaders.add("средний балл за экзамен");
        tableHeaders.add("количество студентов");
        tableHeaders.add("количество университетов");
        tableHeaders.add("названия университетов");
          //Реализация записи объектов класса Statistics в Excel
        File fileWriter = new File("src/main/resources/statisticsInfo.xlsx");
        XlsWriter xlsWriter = XlsWriter.getClassXlsWriter();
             //Назначение шрифта и его размера
        xlsWriter.setTextName("Calibri").setTextSize(11);
             //Вызов метода записи объектов класса Statistics в Excel
        xlsWriter.generationExcel(statisticsList,fileWriter,tableHeaders);
    }
    //Метод сериализации отдельных объектов класса Student
    public static void streamStudent(List<Student> objectsStudent,JsonUtil classJsonUtil){
        objectsStudent.stream()
                .limit(3)
                .map(classJsonUtil::serializationObjectStudent)
                .peek(System.out::println)
                .map(classJsonUtil::deserializationObjectStudent)
                .forEach(System.out::println);
    }
    //Метод сериализации отдельных объектов класса University
    public static void streamUniversity(List<University> objectsUniversity,JsonUtil classJsonUtil){
        objectsUniversity.stream()
                .limit(3)
                .map(classJsonUtil::serializationObjectUniversity)
                .peek(System.out::println)
                .map(classJsonUtil::deserializationObjectUniversity)
                .forEach(System.out::println);
    }
}
