package comparator;

import model.Statistics;

public class ComparatorAverageExamScoreStatistics extends ComparatorTrainingProfileStatistics implements ComparatorStatistics{
    @Override
    public int compare(Statistics o1, Statistics o2) {
        return Float.compare(o2.getAverageExamScore(), o1.getAverageExamScore());
    }
}
