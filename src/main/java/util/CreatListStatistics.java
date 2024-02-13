package util;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class CreatListStatistics {
    private static CreatListStatistics classCreatListStatistics;
    private List<Statistics> statisticsList;
    private Map<String, List<Student>> mapStudent;
    private int numberStudents;

    public CreatListStatistics() {

        this.statisticsList = new ArrayList<>();
    }

    public static CreatListStatistics getClassCreatListStatistics() {
        if (classCreatListStatistics == null) {
            classCreatListStatistics = new CreatListStatistics();
        }
        return classCreatListStatistics;
    }

    public List<Statistics> createListStatistics(List<Student> objectsStudent, List<University> objectsUniversity) {
        mapStudent = objectsStudent.stream()
                .collect(Collectors.groupingBy(Student::getUniversityId));
        Map<StudyProfile, List<University>> mapUniversity = objectsUniversity.stream()
                .collect(Collectors.groupingBy(University::getMainProfile));
        statisticsList = mapUniversity.entrySet().stream()
                .map(x -> new Statistics().setTrainingProfile(x.getKey())
                        .setNumbersUniversities(x.getValue().size())
                        .setNamesUniversities(stringUniversityNames(x.getValue()))
                        .setNumbersStudents(countingNumberStudents(x.getValue()))
                        .setAverageExamScore(
                                averageScoreProfile(x.getValue())))
                .collect(Collectors.toList());
        return statisticsList;
    }

    //Добавление в статистику названий Университетов через запятую
    public String stringUniversityNames(List<University> university) {
        return university.stream()
                .map(University::getFullName)
                .collect(Collectors.joining(", "));
    }

    //Добавление в статистику количества студентов по профилю
    public int countingNumberStudents(List<University> university) {
        numberStudents =  university.stream()
                .map(University::getId)
                .mapToInt(this::checkingStudentsNull).sum();
        return numberStudents;
    }

      //Проверка наличия студентов по профилю
    public int checkingStudentsNull(String key) {
        if (mapStudent.containsKey(key)) {
            return mapStudent.get(key).size();
        }
        return 0;
    }

    //Подсчет среднего балла за экзамен
      /*
      Метод averageScoreProfile который получает ID университета и передает его в метод
       averageScoreUniversity- возражающей сумму средних баллов студентов
       по 1 университету конкретного профиля обучения
       */
    public float averageScoreProfile(List<University> university) {
        double sumScore = university.stream()
                .map(University::getId)
                .mapToDouble(this::averageScoreUniversity)
                .sum();
        return getAverageScore(sumScore);
    }
    public  float averageScoreUniversity(String key){
       if(mapStudent.containsKey(key)) {
            double sumScore = mapStudent.get(key).stream()
                    .mapToDouble(x -> checkingAverageScoreNull(x.getAvgExamScore()))
                    .sum();
            return (float) sumScore;
        }
        return 0.0F;
    }
    //Проверка средней оценки на null
    public double checkingAverageScoreNull(double score){
        return Optional.ofNullable(score).orElse(0.00);
    }
    /*
    Подсчет среднего балла по профилю обучения по формуле
    (сумма средних оценок 1-го университета + .......
    сумма средних оценок n-го университета)/(количество
    студентов во всех университетах по одному профилю)
    если средняя оценка отсутствует она, считается как 0,
    но количество студентов не меняется, Если студентов по профилю нет
    то общая средняя оценка 0.
     */
    public float getAverageScore (double sumScore){
        if(sumScore !=0) {
            float averageScore = new BigDecimal(sumScore/numberStudents)
                    .setScale(2, RoundingMode.HALF_UP).floatValue();
            numberStudents = 0;
            return averageScore;
        }
        return 0.00F;
    }
}
