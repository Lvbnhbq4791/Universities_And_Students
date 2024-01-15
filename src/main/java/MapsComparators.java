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
}



