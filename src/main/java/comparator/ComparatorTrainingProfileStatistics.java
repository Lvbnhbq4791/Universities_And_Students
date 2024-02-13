package comparator;

import model.Statistics;
import model.University;
import org.apache.commons.lang3.StringUtils;

public class ComparatorTrainingProfileStatistics implements ComparatorStatistics{
    @Override
    public int compare(Statistics o1, Statistics o2) {
        return StringUtils.compare(String.valueOf(o1.getTrainingProfile()), String.valueOf(o2.getTrainingProfile()));
    }
}
