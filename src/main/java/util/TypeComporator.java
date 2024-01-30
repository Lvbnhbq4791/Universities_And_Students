package util;

import comparator.ComparatorStudent;
import comparator.ComparatorUniversity;
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
}
