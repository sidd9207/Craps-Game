import java.util.*;

public class Craps {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		
		int balance = 100;
		int wager;
		
		System.out.println("Initial balance: " + balance);
		
		while(balance > 0) {
			wager = balance + 1;
			
			while((wager > balance) || (wager < 0)) {
				System.out.println("How much would you like to wager?: ");
				
				wager = reader.nextInt();
				if((wager > balance) || (wager < 0)) {
					System.out.println("Invalid wager. Please enter a number between 0 and " + balance);
				}
			}
			
			System.out.println("Would you like to play?");
			String userChoice = reader.next();
			
			loop1: switch(userChoice) {
				case "yes":
				case "YES":
				case "Yes":
				{
					System.out.println("Commencing first roll");
					
					int firstRoll = 0;
					int point = 0;
					
					for(int i = 0; i < 2; i++) {
						firstRoll += (int)(Math.random() * 6) + 1;
					}
					System.out.println("First roll is: " + firstRoll);
					if((firstRoll == 2) || (firstRoll == 3) || (firstRoll == 12)) {
						System.out.println("You lose. Your balance will be reduced by" + wager);
						balance -= wager;
						break loop1;
					}else if((firstRoll == 7) || (firstRoll == 11)) {
						System.out.println("You win! Your balance will be increased by " + wager);
						balance += wager;
						break loop1;
					}else {
						point = firstRoll;
						System.out.println("Point will be set as:  " + firstRoll);
						System.out.println("Moving on to next roll");
					}
					
					int rollNumber = 2;
					boolean breakLoop = true;
					
					while(breakLoop) {
						int roll = 0;
						for(int i = 0; i < 2; i++) {
							roll += (int)(Math.random() * 6) + 1;
						}
						System.out.println("Roll number " + rollNumber + " is: " + roll);
						
						if(roll == 7) {
							System.out.println("You lose. Your balance will be reduced by " + wager);
							balance -= wager;
							breakLoop = false;
						}else if(roll == point) {
							System.out.println("You win! Your balance will be increased by " + wager);
							balance += wager;
							breakLoop = false;
						}else {
							System.out.println("The game goes on! Moving on to next roll");
							rollNumber++;
						}
					}
					break;
				}
				case "no":
				case "NO":
				case "No":
				{
					System.out.println("Thank you for playing. Your final balance was: " + balance);
					return;
				}
				default:
				{
					System.out.println("Invalid answer. Please answer with Yes or No.");
				}
			}
		}
		System.out.println("Your balance is too low. Thank you for playing");
		reader.close();
		return;
	}

}
