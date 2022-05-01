import org.junit.Test;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Tests{

    private float DELTA = 0.0001f;

    @Test
    public void testUniqueNumbers(){
        int MAX_TIMES = 100; //change this to try as many instances as you want!
        Game game = new Game();
        for(int i = 0; i < MAX_TIMES; i++){
            HashSet<Integer> ticket = game.generateLotTicket();
            Hashtable<Integer, Boolean> used = new Hashtable<>();
            for(Integer num : ticket){
                Boolean b = used.get(num);
                if(b == null){
                    b = false;
                }
                assertFalse(b);
                used.put(num, true);
            }
        }
    }

    @Test
    public void testSizeTicket(){
        Game game = new Game();
        HashSet<Integer> ticket = game.generateLotTicket();
        assertEquals(5, ticket.size());
    }

    @Test
    public void testNumMatches(){
        Game game = new Game();
        HashSet<Integer> ticket1 = new HashSet<>(), ticket2 = new HashSet<>(), ticket3 = new HashSet<>(), ticket4 = new HashSet<>(), ticket5 = new HashSet<>(),  ticket6 = new HashSet<>();

        // Ticket 1
        ticket1.add(1);
        ticket1.add(2);
        ticket1.add(17);
        ticket1.add(13);
        ticket1.add(3);

        // Ticket 2
        ticket2.add(1);
        ticket2.add(2);
        ticket2.add(17);
        ticket2.add(13);
        ticket2.add(3);

        // Ticket 3
        ticket3.add(1);
        ticket3.add(2);
        ticket3.add(18);
        ticket3.add(13);
        ticket3.add(3);

        // Ticket 4
        ticket4.add(5);
        ticket4.add(4);
        ticket4.add(9);
        ticket4.add(7);
        ticket4.add(6);

        // Ticket 5
        ticket5.add(3);
        ticket5.add(13);
        ticket5.add(17);
        ticket5.add(2);
        ticket5.add(1);

        // Ticket 6 (unexpected number of numbers)
        ticket6.add(3);
        ticket6.add(13);

        // Tests
        assertEquals(5, game.numCorrectDigits(ticket1, ticket2));
        assertEquals(4, game.numCorrectDigits(ticket1, ticket3));
        assertEquals(0, game.numCorrectDigits(ticket1, ticket4));
        assertEquals(5, game.numCorrectDigits(ticket1, ticket5)); //NOTE: this means that tickets can have different 'order' yet still be the same
        assertEquals(-1, game.numCorrectDigits(ticket1, ticket6));
    }

    @Test
    public void testMonetaryResults() {
        Game game = new Game();
        HashSet<Integer> winningTicket = game.winningLotNumber();
        HashSet<Integer> ticket1 = new HashSet<>(), ticket2 = new HashSet<>(), ticket3 = new HashSet<>(), ticket4 = new HashSet<>(), ticket5 = new HashSet<>();

        // Ticket 1
        ticket1 = (HashSet<Integer>) winningTicket.clone();
        Object[] list_numbs = ticket1.toArray();

        // Ticket 2
        ticket2 = (HashSet<Integer>) ticket1.clone();
        ticket2.remove(list_numbs[0]);
        ticket2.add(((Integer) list_numbs[0] + 1 % 42));

        // Ticket 3
        ticket3 = (HashSet<Integer>) ticket2.clone();
        ticket3.remove(list_numbs[1]);
        ticket3.add(((Integer) list_numbs[1] + 1 % 42));

        // Ticket 4
        ticket4 = (HashSet<Integer>) ticket3.clone();
        ticket4.remove(list_numbs[2]);
        ticket4.add(((Integer) list_numbs[2] + 1 % 42));

        // Ticket 5
        ticket5 = (HashSet<Integer>) ticket4.clone();
        ticket5.remove(list_numbs[3]);
        ticket5.add(((Integer) list_numbs[3] + 1 % 42));

        // Begin test cases
        assertEquals(212534.83f, game.calcWinnings(ticket1), DELTA);
        assertEquals(197.53f, game.calcWinnings(ticket2), DELTA);
        assertEquals(10.86f, game.calcWinnings(ticket3), DELTA);
        assertEquals(1f, game.calcWinnings(ticket4), DELTA);
        assertEquals(-1f, game.calcWinnings(ticket5), DELTA);

    }

}
