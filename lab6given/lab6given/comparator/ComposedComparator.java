import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComposedComparator implements Comparator<Song> {

    private List<Comparator<Song>> comparators;

    public ComposedComparator(Comparator<Song> c1, Comparator<Song> c2){
        this.comparators = new ArrayList<Comparator<Song>>();
        comparators.add(c1);
        comparators.add(c2);
    }

    @Override
    public int compare(Song o1, Song o2) {
        int result = comparators.get(0).compare(o1, o2);
        if(result == 0){
            return comparators.get(1).compare(o1, o2);
        }
        return result;
    }
}
