package comparator;

import objects.Student;

public class ComporatorCurrentCourseNumbersStudent implements ComparatorStudent{
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
