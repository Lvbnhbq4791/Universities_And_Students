package util;

import comparator.ComparatorStatistics;
import comparator.ComparatorStudent;
import comparator.ComparatorUniversity;
import enums.ValuesStatistics;
import enums.ValuesStudent;
import enums.ValuesUniversity;

import java.util.Map;

public class TypeComporator {
    private TypeComporator() {
    }
    public static ComparatorStudent getComparatorStudent(Map<ValuesStudent, ComparatorStudent> mapStudent, ValuesStudent valueStudent){
       return mapStudent.get(valueStudent);
    }
    public static ComparatorUniversity getComparatorUniversity(Map<ValuesUniversity, ComparatorUniversity> mapUniversity, ValuesUniversity valueUniversity){
        return mapUniversity.get(valueUniversity);
    }
    public static ComparatorStatistics getComparatorStatistics (Map<ValuesStatistics, ComparatorStatistics> mapStatistics,ValuesStatistics valuesStatistics){
        return mapStatistics.get(valuesStatistics);
    }
}
