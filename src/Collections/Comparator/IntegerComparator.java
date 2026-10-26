package Collections.Comparator;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {
    private final boolean isAscending;

    IntegerComparator() {
        this(true);
    }
    IntegerComparator(boolean isAscending) {
        this.isAscending = isAscending;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 > o2) return (isAscending ? 1 : -1);
        if(o1 < o2) return (isAscending ? -1 : 1);
        return 0;
    }
}
