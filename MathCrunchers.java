import java.util.Random;
import java.util.Scanner;

/* Copyright Ryan McNeely 2013
 * All original code. "Math Crunchers" is a name of a game I played when I was a young child. If rights are reserved on this name,
 * please contact me at ryanm3001@gmail.com
 * 
 * MathCrunchers is a math game that covers addition, subtraction, multiplication and division. It's intended for
 * girls and boys of primary school age. As the user progresses to higher levels, the problems get more difficult. Throughout the game, 
 * the user is consistently provided with 2 kinds of feedback: 1) Congratulatory statements when she get's a problem right and 2) Encouraging 
 * statements when she makes a mistake. To keep the game not-boring, both types of statements are implemented with Java Random api, which 
 * provides the user with different statements at random (see methods congratulatePerProblem() and encouragePerProblem() below).
 * 
 * Future plans include using Javascript to implement this as web app. 
 * Original? No. This has been done a thousand ways, a thousand times. 
 * An opportunity to change 1 child's life forever? Yes.
 * 
 * It will be made available free of charge to all.
 */

public class MathCrunchers {
	
	int problemsPerLevel;
	int levelTotal;
	int currentLevel = 0;
	
	int randomCeilingX;					// Plugs into the Random object in increaseDifficulty() Random object
	int randomCeilingY;         			// "Cieling 10" generates an int 0-10. "Cieling 20" generates an int 0-20.
	
	public MathCrunchers(int problems, int levelTotal){
		this.problemsPerLevel = problems;
		this.levelTotal = levelTotal;
		System.out.println("\nThere are " + this.levelTotal + " levels with " + this.problemsPerLevel + " problems per level.");
	}
	
	public void increaseDifficulty(int levelNum){	
		if(levelNum == 1){						// Level 2: X base 20 (outputs 0-20), Y base 10
			randomCeilingX = 10;					// Level 3: X base 30, Y base 10
			randomCeilingY = 10;
		}										// Level 4: X base 40, Y base 10
		
		else if(levelNum <= 4){				    // Level 5: X base 20, Y base 30
			randomCeilingX += 10;					// Level 6: X base 20, Y base 50
		}									
		else if(levelNum <= 6){					// Level 7: X base 40, Y base 60
			randomCeilingX += 10;					// Level 8: X base 60, Y base 70
			randomCeilingY += 10;                  // Level 9: X base 80, Y base 80

		}										
		else if(levelNum == 10){                // Level 10: X base 100, Y base 100 
			randomCeilingX += 20;
			randomCeilingY += 20;
		} 
		else if(levelNum > 10){
			System.out.println("This program is not supposed to go beyond 10 levels. " +
					"Ask your teacher to reset the game to 10 levels or less.");
		}
	}	

	public void iterateProblemSet(int levelNum){
		Random rand = new Random(); 
		Scanner scan = new Scanner(System.in);
		
		increaseDifficulty(levelNum);		    // returns randomBaseX
		
		System.out.println("X: " + randomCeilingX + ", Y: " + randomCeilingY);	

		for(int problemNum = 1; problemNum <= problemsPerLevel; problemNum++){
			
			int x = rand.nextInt(randomCeilingX);               // add handling to prevent duplicate problems( 8+3 and 3+8 are duplicates).
			int y = rand.nextInt(randomCeilingY);
						
			System.out.println("\nProblem #" + problemNum);
			
			System.out.println("How much is "+ x + " plus " + y + "?");
			int input = scan.nextInt();                      // user's input from command line
			
			
			if(problemNum < problemsPerLevel){
				while(input != (x + y)){                     // what if user enters 10 incorrect answers?
					encouragePerProblem();
					input = scan.nextInt();	
				}	
				congratulatePerProblem();                    // go to next problem	
				
				// Insert 3 second wait here
			
			}
			else if(problemNum == problemsPerLevel){
				while(input != (x + y)){                     // what if user enters 10 incorrect answers?
					encouragePerProblem();
					input = scan.nextInt();
				}
			}	
		}
	}
	
	
	public void iterateLevels(){
		for(int levelNum = 1; levelNum <= levelTotal; levelNum++){
			
			System.out.println("\nYou're on Level " + levelNum +".");
			iterateProblemSet(levelNum);
		
			if(levelNum < levelTotal){
				System.out.println("\nYou did it! You beat Level " + levelNum + ". Continue to the next level!");
				
				// Insert 3 second wait here
			}
			else if(levelNum == levelTotal){
				System.out.println("Congratulations! You beat MathCrunchers Addition! Next, try 'MathCrunchers Subtraction'");
			}
		}
	}
	
	
	/* Encourages user for each problem answered incorrectly. 
	 * Random object generates an int 0-4 (inclusive). That int plugs into the switch 
	 * statement, which prints 1 of 5 encouraging messages to user.*/
	public static void encouragePerProblem(){

		Random rand = new Random();

		switch(rand.nextInt(4)){
			case 0:
				System.out.println("No worries. Try again.");
				break;
			case 1:
				System.out.println("You can do it! Try again.");				
				break;
			case 2:
				System.out.println("You got this. Try again.");				
				break;		
			case 3:
				System.out.println("Stop, breathe, think. You got this. Try again.");				
				break;
			case 4:
				System.out.println("You can do this. Try again.");
				break;
		}		
	}
	
	
	/* Congratulates user for each problem answered correctly. 
	 * Random object generates an int 0-4 (inclusive). That int plugs into the switch 
	 * statement, which prints 1 of 5 congratulatory messages to the user.
	 * Note: Congratulations for the entire level is handled at end of iterateProblemSet()*/
	public static void congratulatePerProblem(){
		
		Random rand = new Random();

		switch(rand.nextInt(4)){
			case 0:
				System.out.println("Great job! Keep going.");
				break;
			case 1:
				System.out.println("Pssh. You got this. Next.");				
				break;
			case 2:
				System.out.println("Nice.");				
				break;		
			case 3:
				System.out.println("Well done. Keep it up!");				
				break;
			case 4:
				System.out.println("Woohoo!");
				break;
		}		
		
	}
	
	
	public static void main(String[]args){
		
		// Creates new instance of MathCrunchers game with 5 problems per level, and 5 levels
		MathCrunchers game1 = new MathCrunchers(3, 10);
		// iterateLevels() makes use of all other methods in MathCrunchers class
		game1.iterateLevels();
	}	
}
