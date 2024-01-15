import org.apache.commons.lang3.StringUtils;

public class ComporatorProfileNameUniversity implements ComparatorUniversity{
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(String.valueOf(o1.getMainProfile()), String.valueOf(o2.getMainProfile()));
    }
}
