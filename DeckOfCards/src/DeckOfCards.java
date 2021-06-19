import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DeckOfCards {
    public static void main(String[] args) {
        String[][] cardCombo = new String[4][13];
        String[][] player = new String[4][9];
        Set<String> cards = new HashSet();
        int k = 0, l = 0, m = 0, o = 0, num = 1;

        String[] suits = {"Diamond", "Heart", "Spades", "Club"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack" , "Queen", "King", "Ace"};

        //Create combination of cards
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cardCombo[i][j] = suits[i] + rank[j];
            }
        }

        //Distribute 9 cards each to 4 people
        while (num <= 36) {
            int randomSuit = (int) Math.floor(Math.random()*10)%4;
            int randomRank = (int) Math.floor(Math.random()*100)%13;

            //Avoid duplicacy of cards using Set<> concept
            if (cards.add(cardCombo[randomSuit][randomRank])) {
                int option = num % 4;
                switch (option){
                    case 0:
                        player[option][k++] = cardCombo[randomSuit][randomRank];
                        break;
                    case 1:
                        player[option][l++] = cardCombo[randomSuit][randomRank];
                        break;
                    case 2:
                        player[option][m++] = cardCombo[randomSuit][randomRank];
                        break;
                    case 3:
                        player[option][o++] = cardCombo[randomSuit][randomRank];
                        break;
                }
                num++;
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.print("Player " + (i+1) + " : ");
            for (int j=0; j < 9; j++) {
                System.out.print(player[i][j] + " ");
            }
            System.out.println();
        }
    }
}
