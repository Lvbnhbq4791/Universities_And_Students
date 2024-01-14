import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class MapsComparators {
    Map<ValuesStudent, ComparatorStudent> mapComparatorsStudent;
    Map<ValuesUniversity, ComparatorUniversity> mapComparatorsUniversity;

    public MapsComparators() {
        this.mapComparatorsStudent = new HashMap<>();
        this.mapComparatorsUniversity = new HashMap<>();
    }

    public Map<ValuesStudent, ComparatorStudent> getMapComparatorsStudent() {
        mapComparatorsStudent.put(ValuesStudent.FULL_NAME, (o1, o2) -> StringUtils
                .compare(o1.getFullName(), o2.getFullName()));
        mapComparatorsStudent.put(ValuesStudent.UNIVERSITY_ID, (o1, o2) -> StringUtils
                .compare(o1.getUniversityId(), o2.getUniversityId()));
        mapComparatorsStudent.put(ValuesStudent.CURRENT_COURSE_NUMBER, (o1, o2) -> Integer
                .compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber()));
        mapComparatorsStudent.put(ValuesStudent.AVG_EXAM_SCORE, (o1, o2) -> Float
                .compare(o2.getAvgExamScore(), o1.getAvgExamScore()));
        return mapComparatorsStudent;
    }

    public Map<ValuesUniversity, ComparatorUniversity> getMapComparatorsUniversity() {
        mapComparatorsUniversity.put(ValuesUniversity.ID, (o1, o2) -> StringUtils
                .compare(o1.getId(), o2.getId()));
        mapComparatorsUniversity.put(ValuesUniversity.FULL_NAME, (o1, o2) -> StringUtils
                .compare(o1.getFullName(), o2.getFullName()));
        mapComparatorsUniversity.put(ValuesUniversity.SHORT_NAME, (o1, o2) -> StringUtils
                .compare(o1.getShortName(), o2.getShortName()));
        mapComparatorsUniversity.put(ValuesUniversity.YEAR_OF_FOUNDATION, (o1, o2) -> Integer
                .compare(o1.getYearOfFoundation(), o2.getYearOfFoundation()));
        return mapComparatorsUniversity;
    }
}



