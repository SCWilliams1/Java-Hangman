/*
Solomon Williams
1-30-2019
Hangman
*/
import java.util.Scanner;
public class HangmanTester
{
    public static void main(String [] args)
    {
    	//Would you like to play a game
    	String reset = "y";
    	int word_slots = 15;
    	
    	//Create Game
    	Hangman game = new Hangman();
    	Scanner input = new Scanner(System.in);
        game.gameinit();    	
    	
    	while(reset.equals("y") || word_slots == 0){
    		
    		//Reset
	    	int tr = 7;//tries
	    	
	        //set word
	        String rnd = game.get_random_word();
	        String [] display = new String [rnd.length()];//setting the star
	        display = game.disp_init(display);
	        word_slots--;//decrement word use
	        
	        //while
	        while(tr > 0) {
		        //User Input
	        	game.print_display(display);
		        System.out.print("Guess: ");
		        String str = game.get_word_stripped(input.next());
		        
		        //Parse guess
		        if(game.game_parse(str, rnd, display)) {
		        	System.out.print("\nCorrect! ");
		        	if(game.win_condition(display)) {
		        		System.out.print(rnd + "!");
		        		tr = -4;
		        	}else{
		        		System.out.print("Keep going!\n\n");
		        	}
		        }else{
		        	tr--;
		        	System.out.println("Incorrect - Tries left: " + Integer.toString(tr) + "\n");	
		        }
	        }
	        
	        //win condition
	        System.out.print("\n");
		    if(tr == 0) {
		        System.out.print("You Lost, ");
		    }else{
		    	System.out.print("You Win, ");
		    }
		    
		    //Game Over
		    if(word_slots != 0) {
			    System.out.print("Try Again (y/n)? ");
			    Scanner restart = new Scanner(System.in); 
			    reset = restart.next().replaceAll("\\p{P}","").toLowerCase().substring(0,1);
		    }else {
		    	System.out.print("No more words!");
		    }
		}
    	
    	//End Game
    }
}