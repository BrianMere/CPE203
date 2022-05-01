import java.util.HashSet;
import java.util.Random;

public class Game {
    private HashSet<Integer> winningTicket;

    public Game(){
        winningLotNumber();
    }
    /**
     * Generate a random lottery ticket with numbers in [1,42] with 5 total numbers.
     * @return
     */
    public HashSet<Integer> generateLotTicket(){
        Random rand = new Random();
        int NUMBERS_ON_TICKET = 5;
        int MAX_NUM = 42;
        HashSet<Integer> ticket = new HashSet<>();
        do {
            int new_num = (int)rand.nextInt(MAX_NUM - 1) + 1;
            if (!ticket.contains(new_num)) { // if the number isn't in the ticket
                ticket.add(new_num); // will autobox implicitly
            }
        }while (ticket.size() < NUMBERS_ON_TICKET);

        return ticket;
    }

    /**
     * Generates a lottery ticket and stores it in the game's data. Returns it for the purposes of tests
     * @return The new winning lottery ticket
     * NOTE: normally I'd make this private, but for the purposes of testing it's better to make this public
     */
    public HashSet<Integer> winningLotNumber(){
        this.winningTicket = generateLotTicket();
        return this.winningTicket;
    }

    /** Compares two lottery tickets for how similar (# same numbers) they are. Builds in logic to handle tickets with different sized amounts of numbers.
     *
     * @param ticket1 A ticket to be compared
     * @param ticket2 A ticket to be compared
     * @return The number (int) of digits that are the same between the two tickets. Returns code 0f if the tickets have different lengths (don't have the same amount of numbers)
     */
    public int numCorrectDigits(HashSet<Integer> ticket1, HashSet<Integer> ticket2) {

        int numMatches = 0;
        if(ticket1.size() != ticket2.size()){ // Catch case, which shouldn't come up for normal usage. Would break the game if people could put in 42 numbers to get the winning numbers...
            return -1;
        }
        for(Integer num : ticket1){
            if(ticket2.contains(num)){
                numMatches++;
            }
        }
        return numMatches;
    }

    public float calcWinnings(HashSet<Integer> ticket){
        int numCorrect = numCorrectDigits(ticket, winningTicket);
        switch (numCorrect){
            case 0, 1:
                return -1f;
            case 2:
                return 1f;
            case 3:
                return 10.86f;
            case 4:
                return 197.53f;
            case 5:
                return 212534.83f;
            default:
                System.out.print("Cannot handle this many correct numbers, or the input ticket format is of the wrong size");
                return 0f;
        }
    }
}
