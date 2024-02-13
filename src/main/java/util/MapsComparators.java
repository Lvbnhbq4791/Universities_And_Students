package util;

import comparator.*;
import enums.ValuesStatistics;
import enums.ValuesStudent;
import enums.ValuesUniversity;

import java.util.*;

public class MapsComparators {
    private Map<ValuesStudent, ComparatorStudent> mapComparatorsStudent;
    private Map<ValuesUniversity, ComparatorUniversity> mapComparatorsUniversity;
    private Map<ValuesStatistics, ComparatorStatistics> mapComparatorsStatistics;

    public MapsComparators() {
        this.mapComparatorsStudent = new HashMap<>();
        this.mapComparatorsUniversity = new HashMap<>();
        this.mapComparatorsStatistics = new HashMap<>();
    }

    public Map<ValuesStudent, ComparatorStudent> getMapComparatorsStudent() {
        mapComparatorsStudent.put(ValuesStudent.FULL_NAME, new ComporatorFullNameStudent());
        mapComparatorsStudent.put(ValuesStudent.UNIVERSITY_ID, new ComporatorUniversityIdStudent());
        mapComparatorsStudent.put(ValuesStudent.CURRENT_COURSE_NUMBER, new ComporatorCurrentCourseNumbersStudent());
        mapComparatorsStudent.put(ValuesStudent.AVG_EXAM_SCORE, new ComporatorAvgExamScoresStudent());
        return mapComparatorsStudent;
    }

    public Map<ValuesUniversity, ComparatorUniversity> getMapComparatorsUniversity() {
        mapComparatorsUniversity.put(ValuesUniversity.ID, new ComporatorIdUniversity());
        mapComparatorsUniversity.put(ValuesUniversity.FULL_NAME, new ComporatorFullNameUniversity());
        mapComparatorsUniversity.put(ValuesUniversity.SHORT_NAME, new ComporatorShortNameUniversity());
        mapComparatorsUniversity.put(ValuesUniversity.YEAR_OF_FOUNDATION, new ComporatorYearOfFoundationUniversity());
        mapComparatorsUniversity.put(ValuesUniversity.PROFILE_NAME, new ComporatorProfileNameUniversity());
        return mapComparatorsUniversity;
    }
    public Map<ValuesStatistics, ComparatorStatistics> getMapComparatorsStatistics(){
        mapComparatorsStatistics.put(ValuesStatistics.TRAINING_PROFILE, new ComparatorTrainingProfileStatistics());
        mapComparatorsStatistics.put(ValuesStatistics.AVERAGE_EXAM_SCORE, new ComparatorAverageExamScoreStatistics());
        mapComparatorsStatistics.put(ValuesStatistics.NUMBERS_STUDENTS, new ComparatorNumbersStudentsStatistics());
        mapComparatorsStatistics.put(ValuesStatistics.NUMBERS_UNIVERSITIES, new ComparatorNumberUniversitiesStatistics());
        return mapComparatorsStatistics;
    }
}



