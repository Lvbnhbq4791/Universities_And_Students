package comparator;

import model.Statistics;

public class ComparatorNumberUniversitiesStatistics extends ComparatorTrainingProfileStatistics implements ComparatorStatistics{
    @Override
    public int compare(Statistics o1, Statistics o2) {
        return Integer.compare(o1.getNumbersUniversities(), o2.getNumbersStudents());
    }
}
