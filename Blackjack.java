import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Time to Play Black Jack!\n");
        

        int playerHand = 0;
        int dealerHand = 0;

        playerHand = decisionPlayer();
        dealerHand = decisionCPU();


        isGameOver(playerHand, dealerHand);

    }

    //Draw a card
    public static int drawCard (){
        int draw = (int) (Math.random()*14) + 1;
        switch (draw) {
            case 12, 13, 14 -> draw = 10;
        }
        int lastCard = draw;

        return lastCard;
    }

    //Prompts user to draw another card or not
    public static String getUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want another card?\nY? or N?");
        String c = input.next();
        return c;
    }

    //get two cards, if getUserInput = Y, drawcard again, else return
    public static int decisionPlayer() {
        int end = 0;
        for (int i = 0; i < 2; i++) {
            end += drawCard();
        }
        System.out.println("Your hand total is: " + end);


        String i;
        do {
            i = getUserInput();
            if (i.equals("Y")) {
                end += drawCard();
            }
            System.out.println("Your new hand is: " + end);
        } while (i.equals("Y"));

        return end;
    }

    public static int decisionCPU(){
        int end = 0;
        // draws card
        for (int i = 0; i < 2; i++){
            end += drawCard();
        }
        // if the sum is less than 16 then CPU draws again
        while (end <= 16){
            end += drawCard();
        }
        return end;
    }

    public static void isGameOver(int playerHand, int dealerHand){
        //If player bust
        System.out.println("\nThe player's hand is " + playerHand + "!");
        System.out.println("The dealer's hand is " + dealerHand + "!\n");

        //Else if CPU bust
        if (dealerHand > 21 && playerHand > 21) {
            System.out.println("Draw!");
        } else if (dealerHand == playerHand) {
            System.out.println("Draw!");
        } else if (dealerHand > 21 && playerHand <= 21) {
            System.out.println("Player Wins!");
        } else if (playerHand > 21 && dealerHand <= 21) {
            System.out.println("Dealer Wins!");
        } else if (playerHand > dealerHand) {
            System.out.println("Player Wins!");
        } else {
            System.out.println("Dealer Wins!");
        }

    }
}