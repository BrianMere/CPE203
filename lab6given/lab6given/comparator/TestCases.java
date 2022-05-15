import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

import org.junit.Test;
import org.junit.Before;

public class TestCases
{
   private static final Song[] songs = new Song[] {
         new Song("Decemberists", "The Mariner's Revenge Song", 2005), //0
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005),        //1
         new Song("Avett Brothers", "Talk on Indolence", 2006),        //2
         new Song("Gerry Rafferty", "Baker Street", 1998),             //3
         new Song("City and Colour", "Sleeping Sickness", 2007),       //4
         new Song("Foo Fighters", "Baker Street", 1997),               //5
         new Song("Queen", "Bohemian Rhapsody", 1975),                 //6
         new Song("Gerry Rafferty", "Baker Street", 1978)              //7
      };

   @Test
   public void testArtistComparator()
   {
      assertTrue(new ArtistComparator().compare(songs[2], songs[1]) < 0);
      assertTrue(new ArtistComparator().compare(songs[5], songs[6]) < 0);
      assertTrue(new ArtistComparator().compare(songs[1], songs[1]) == 0);
      assertTrue(new ArtistComparator().compare(songs[3], songs[7]) == 0);
      assertTrue(new ArtistComparator().compare(songs[6], songs[2]) > 0);
      assertTrue(new ArtistComparator().compare(songs[0], songs[2]) > 0);

      // Provided example
      assertTrue(new ArtistComparator().compare(songs[0], songs[1]) < 0);
   }

   @Test
   public void testLambdaTitleComparator()
   {
      Comparator<Song> comp = (Song o1, Song o2) -> {return o1.getTitle().compareTo(o2.getTitle());};
      assertTrue(comp.compare(songs[1], songs[2]) < 0);
      assertTrue(comp.compare(songs[5], songs[6]) < 0);
      assertTrue(comp.compare(songs[1], songs[1]) == 0);
      assertTrue(comp.compare(songs[5], songs[7]) == 0);
      assertTrue(comp.compare(songs[2], songs[6]) > 0);
      assertTrue(comp.compare(songs[2], songs[1]) > 0);

      // Provided example
      assertTrue(comp.compare(songs[0], songs[1]) > 0);
   }

   @Test
   public void testYearExtractorComparator()
   {
      Comparator<Song> comp = Comparator.comparing(Song::getYear).reversed();
      assertTrue(comp.compare(songs[0], songs[3]) < 0);
      assertTrue(comp.compare(songs[5], songs[6]) < 0);
      assertTrue(comp.compare(songs[1], songs[1]) == 0);
      assertTrue(comp.compare(songs[0], songs[1]) == 0);
      assertTrue(comp.compare(songs[2], songs[4]) > 0);
      assertTrue(comp.compare(songs[0], songs[2]) > 0);

      // Provided example
      assertTrue(comp.compare(songs[1], songs[2]) > 0);
   }

   @Test
   public void testComposedComparator()
   {
      Comparator<Song> compare1 = (s1, s2)->((Integer) s1.getYear()).compareTo((Integer) s2.getYear()); // Compare in ascending year order
      Comparator<Song> compare2 = (s1, s2)->s1.getTitle().compareTo(s2.getTitle()); // Then, compare based on title in ascending order
      ComposedComparator comp = new ComposedComparator(compare1, compare2);

      assertTrue(comp.compare(songs[1], songs[0]) < 0);
      assertTrue(comp.compare(songs[5], songs[3]) < 0);
      assertTrue(comp.compare(songs[6], songs[6]) == 0);
      assertTrue(comp.compare(songs[3], songs[5]) != 0);
      assertTrue(comp.compare(songs[5], songs[7]) > 0);
      assertTrue(comp.compare(songs[0], songs[1]) > 0);
   }

   @Test
   public void testThenComparing()
   {
      Comparator<Song> comp = (s1, s2)->s1.getTitle().compareTo(s2.getTitle());
      comp = comp.thenComparing(Comparator.comparing(Song::getArtist));

      assertTrue(comp.compare(songs[3], songs[7]) == 0);
      assertTrue(comp.compare(songs[1], songs[0]) < 0);

      // Provided example
      assertTrue(comp.compare(songs[3], songs[5]) > 0);

   }

   @Test
   public void runSort()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Gerry Rafferty", "Baker Street", 1978),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005)
         );

      Comparator<Song> comp = (s1,s2)->s1.getArtist().compareTo(s2.getArtist());
      comp = comp.thenComparing((s1,s2)->s1.getTitle().compareTo(s2.getTitle()));
      comp = comp.thenComparing((s1,s2)->((Integer) s1.getYear()).compareTo((Integer) s2.getYear()));

      songList.sort(
              comp
      );

      assertEquals(songList, expectedList);
   }
}
