import java.util.Comparator;

public class ArtistComparator implements Comparator<Song> {
    @Override
    public int compare(Song o1, Song o2) {
        int output = o1.getArtist().compareTo(o2.getArtist());
        return o1.getArtist().compareTo(o2.getArtist());
    }
}
