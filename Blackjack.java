//This program allows the user to play black jack against the computer.
import java.util.Scanner;
// This is a change for lab 6
public class Blackjack {

    public static String getUserCardName (int userCardGenerated) { // this method changes the random generated
        String userCardName;                                       // number to the name of the card
        switch (userCardGenerated) {
            case 1:
                userCardName = "ACE";
                break;
            case 2:
                userCardName = "2";
                break;
            case 3:
                userCardName = "3";
                break;
            case 4:
                userCardName = "4";
                break;
            case 5:
                userCardName = "5";
                break;
            case 6:
                userCardName = "6";
                break;
            case 7:
                userCardName = "7";
                break;
            case 8:
                userCardName = "8";
                break;
            case 9:
                userCardName = "9";
                break;
            case 10:
                userCardName = "10";
                break;
            case 11:
                userCardName = "JACK";
                break;
            case 12:
                userCardName = "QUEEN";
                break;
            case 13:
                userCardName = "KING";
                break;
            default:
                userCardName = "Invalid";
                break;
        }
        return userCardName;
    }
    public static int getUserCardValue (int userCardGenerated) { // this method assigns the value of the card based
        int userCardValue;                                       // on the random generated number
        switch (userCardGenerated) {
            case 11:
            case 12:
            case 13:
                userCardValue = 10;
                break;
            default:
                userCardValue = userCardGenerated;
                break;
        }
        return userCardValue;
    }

    public static void main(String [] args) {
        int gameNum = 1; // START GAME #
        int numOfGames = 0; // number of games played
        int userCardGenerated; // number that was generated using the random number generator for user's card
        String userCardName; // name of the card that is displayed
        int userCardValue; // value of the user's card
        int userHand; // value of the user's hand
        int menuOption = 1; // option that the user selects
        int computerHand;
        int numUserWins = 0; // number of the user's wins
        int numComputerWins = 0; // number of the computer's wins
        int numOfTies = 0; // number of ties
        double percentageOfWins;

        Scanner keyboard = new Scanner(System.in);
        P1Random rng = new P1Random();

        while (menuOption != 4) { // this while loop starts a new game and deals a card to the user
            System.out.println("START GAME #" + gameNum + "\n");
            userCardGenerated = rng.nextInt(13) + 1; // generates a random number 1-13
            userCardName = getUserCardName(userCardGenerated);
            System.out.println("Your card is a " + userCardName + "!");

            userHand = 0;
            userCardValue = getUserCardValue(userCardGenerated);
            userHand = userHand + userCardValue;
            System.out.println("Your hand is: " + userHand);

            while (menuOption != 4) {                          // this while loop prints the menu
                System.out.println("\n1. Get another card");   // after the operations in the selected
                System.out.println("2. Hold hand");            // menu option are complete
                System.out.println("3. Print statistics");
                System.out.println("4. Exit\n");
                System.out.print("Choose an option: ");
                menuOption = keyboard.nextInt();

                if (menuOption == 1) { // this if statement deals the user another card
                    userCardGenerated = rng.nextInt(13) + 1; // generates a random number 1-13
                    userCardName = getUserCardName(userCardGenerated);
                    System.out.println("\nYour card is a " + userCardName + "!");

                    userCardValue = getUserCardValue(userCardGenerated);
                    userHand = userHand + userCardValue;
                    System.out.println("Your hand is: " + userHand);

                    if (userHand == 21) { // if the user has a hand of 21, the user wins
                        System.out.println("\nBLACKJACK! You win!\n");
                        numUserWins++;
                        break;
                    }
                    else if (userHand > 21) { // if the user has a hand higher than 21, the dealer wins
                        System.out.println("\nYou exceeded 21! You lose.\n");
                        numComputerWins++;
                        break;
                    }
                }

                else if (menuOption == 2) {                     // this if statement holds the users card and
                    computerHand = rng.nextInt(11) + 16;   // generates a hand for the dealer
                    System.out.println("\nDealer's hand: " + computerHand);
                    System.out.println("Your hand is: " + userHand);
                    if (computerHand == 21) { // if the computer has a hand of 21, the dealer wins
                        System.out.println("\nDealer wins!\n");
                        numComputerWins++;
                        break;
                    }
                    else if (computerHand > 21) { // if the computer has a hand higher than 21, the user wins
                        System.out.println("\nYou win!\n");
                        numUserWins++;
                        break;
                    }
                    else if (computerHand > userHand) {          // if the computer has a higher hand than the user,
                        System.out.println("\nDealer wins!\n"); // the dealer wins
                        numComputerWins++;
                        break;
                    }
                    else if (computerHand < userHand) {     // if the user has a higher hand than the computer,
                        System.out.println("\nYou win!\n"); // the user wins
                        numUserWins++;
                        break;
                    }
                    else { // if the user and the computer have the same hand, it's a tie
                        System.out.println("\nIt's a tie! No one wins!\n");
                        numOfTies++;
                        break;
                    }
                }
                else if (menuOption == 3) { // displays the statistics of the game
                    System.out.println("\nNumber of Player wins: " + numUserWins);
                    System.out.println("Number of Dealer wins: " + numComputerWins);
                    System.out.println("Number of tie games: " + numOfTies);
                    System.out.println("Total # of games played is: " + numOfGames);
                    percentageOfWins = (Math.round(((double) numUserWins / numOfGames) * 1000.0) / 10.0);
                    System.out.println("Percentage of Player wins: " + percentageOfWins + "%\n");
                }
                else if (menuOption > 4 || menuOption < 1) { // lets the user know they made an invalid input
                    System.out.println("\nInvalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.\n");
                }
            }
            gameNum++;
            numOfGames++;
        }
    }
}