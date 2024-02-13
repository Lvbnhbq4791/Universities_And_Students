package comparator;

import model.Statistics;

public class ComparatorNumbersStudentsStatistics extends ComparatorTrainingProfileStatistics implements ComparatorStatistics{
    @Override
    public int compare(Statistics o1, Statistics o2) {
        return Integer.compare(o1.getNumbersStudents(), o2.getNumbersStudents());
    }
}
