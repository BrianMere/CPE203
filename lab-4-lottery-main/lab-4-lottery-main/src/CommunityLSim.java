import java.util.*;

/**
 * A class that represents the community and simulates
 * the running of the lottery.
 */
public final class CommunityLSim {

    ArrayList<CommunityMember> communityMembers;
    Random random = new Random();
    //you will need to add more instance variables

    /**
     * Creates a new Community with the specified number of people
     * @param numP The number of people in the community
     */
    public CommunityLSim( int numP) {
        //create the players
        this.communityMembers = new ArrayList<>();

        for (int i = 0; i < numP; i++) {
            if (i < numP /2.0)
                this.communityMembers.add(new CommunityMember(CMemberKind.POORLY_PAID, (float)(99+Math.random())));
            else
                this.communityMembers.add(new CommunityMember(CMemberKind.WELL_PAID, (float)(100.1+Math.random())));
        }

    }

    public int getSize() {
        return this.communityMembers.size();
    }

    public CommunityMember getPlayer(int i) {
        return this.communityMembers.get(i);
    }

    /**
     * Give each community member some pocket change.
     * Give POORLY_PAID community members 0.03f, and give
     * WELL_PAID community members 0.1f.
     */
    public void addPocketChange() {
        for(CommunityMember member : communityMembers){
            if(member.getKind() == CMemberKind.POORLY_PAID){
                member.addMoney(0.03f);
            }
            else if(member.getKind() == CMemberKind.WELL_PAID){
                member.addMoney(0.1f);
            }
        }
    }

    /**
     * Generates a list of community members who will play this game this time.
     * @return An ArrayList of CommunityMembers who will play
     *
     */
    private ArrayList<CommunityMember> reDoWhoPlays() {
        ArrayList<CommunityMember> players = new ArrayList<>();
        int numP = communityMembers.size();
        float RATE_POOR_PLAYING = 0.6f;
        float RATE_RICH_PLAYING = 0.4f;
        ArrayList<Integer> indices_P = randomUniqIndx((int)(RATE_POOR_PLAYING * (float)numP/2.0f), 0, numP/2);
        ArrayList<Integer> indices_R = randomUniqIndx((int)(RATE_RICH_PLAYING * (float)numP/2.0f), numP/2, numP);
        for(int i : indices_P){
            players.add(communityMembers.get(i));
        }
        for(int i : indices_R){
            players.add(communityMembers.get(i));
        }
        return players;
    }

    /* generate some random indices for who might play the lottery
        in a given range of indices */

    /**
     * Generate a number of random indices within an interval
     * @param numI The number of random unique indices to generate
     * @param startRange The lower bound of the interval, inclusive
     * @param endRange The upper bound of the interval, exclusive
     * @return The list of indices given the above conditions. In ArrayList<Integer> format
     */
    public ArrayList<Integer> randomUniqIndx(int numI, int startRange, int endRange) {
        ArrayList<Integer> indices = new ArrayList<>();
        Random random = new Random();
        int possible;
        for(int i = 0; i < numI; i++){
            do { // Keep trying to generate an acceptable index
                possible = random.nextInt(endRange - startRange) + startRange;
            } while (indices.contains((Integer)possible) && indices.size() != 0);
            indices.add(possible);
        }
        return indices;
    }

    public void simulateYears(int numYears) {
        // Simulate the lottery (see steps below)
        for (int year=0; year < numYears; year++) {

            // 1. Add pocket change for all community members, whether or not they're playing.
            addPocketChange();

            // 2. Re-compute the players who are playing the lottery in the current year.
            ArrayList<CommunityMember> players = reDoWhoPlays();

            // 3. Simulate the lottery for those players.
            Game game = new Game(); // By default a new winning lottery ticket is made on construction;
            for(CommunityMember member : players){

                member.playRandom(); // Generate a random lottery ticket
                float winnings = game.calcWinnings(member.getTicket()); // Calculate the winnings from the ticket
                member.addMoney(winnings); // Add money to the member's account

                // 3.5. Scholarship part
                float PROB_P_GET = 0.3f;
                float PROB_R_GET = 1f - PROB_P_GET; // Ignore. Not used.
                if(winnings == -1f){ // Communal 'scholarship' part (only do if winnings == -1f)
                    Random rand = new Random();
                    boolean isPoorRecipient = (rand.nextFloat(0f, 1f) < PROB_P_GET);
                    int numP = communityMembers.size();
                    int index;
                    if(isPoorRecipient){
                        index = randomUniqIndx(1, 0, numP/2).get(0);
                    }
                    else{
                        index = randomUniqIndx(1, numP/2, numP).get(0);
                    }
                    CommunityMember scholarshipWinner = communityMembers.get(index);
                    scholarshipWinner.addMoney(1f);
                }
            }

            // 4. Update everyone's money for that year.
            for (CommunityMember cm : this.communityMembers) {
                cm.updateMoneyEachYear();
            }

            // 5. Print statements
            int MAX = 100000000;
            System.out.println("After year " + year);
            CommunityMember largest = new CommunityMember(CMemberKind.POORLY_PAID, -MAX), smallest = new CommunityMember(CMemberKind.WELL_PAID, MAX);
            // Shouldn't matter what the kind is regardless, but needed to give one and gave a random one
            for(CommunityMember member : communityMembers){
                if(largest == null || largest.getMoney() < member.getMoney()){
                    largest = member;
                }
            }
            for(CommunityMember member : communityMembers){
                if(smallest == null || smallest.getMoney() > member.getMoney()){
                    smallest = member;
                }
            }
            System.out.println("The person with the most money has: " + largest.getMoney());
            System.out.println("The person with the least money has: " + smallest.getMoney());
        }
    }

}
