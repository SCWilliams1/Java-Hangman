//Solomon Williams
//1-30-2019
//Hangman
import java.util.Random;
import java.util.Scanner;
public class Hangman
{
	private String [] word_list  = new String[15];
    public Hangman(){}
    
    public void gameinit()
    {
        //create the loop and calculations to update all needed private instance variables    
    	word_list[0] = "anarchy";
    	word_list[1] = "logic";
    	word_list[2] = "ceremony";
    	word_list[3] = "cordial";
    	word_list[4] = "archaic";
    	word_list[5] = "nitrogen";
    	word_list[6] = "fortitude";
    	word_list[7] = "calamari";
    	word_list[8] = "obscenity";
    	word_list[9] = "cynic";
    	word_list[10] = "cartilage";
    	word_list[11] = "vespidae";
    	word_list[12] = "history";
    	word_list[13] = "powerful";
    	word_list[14] = "lexicon";
    	
    }
    
    //Word parsing
    public String get_random_word(){
        Random rnd = new Random();
    	int rn = rnd.nextInt(15);
    	while(word_list[rn] == "") {//viable word check
    		rn = rnd.nextInt(15);
    	}
    	String r = word_list[rn];
    	word_list[rn] = "";//delete word
    	
    	return r;
    }
    public String get_word_stripped(String a) {
    	String v = a.replaceAll("\\p{P}","").toLowerCase().substring(0,1);
    	return v;
    }  
    public String[] string_to_array(String s) {
    	String[] a = new String[s.length()];
    	for(int i = 0; i < s.length(); i++) {
    			a[i] = String.valueOf(s.charAt(i));
    	}
    	return a;
    }
    
    //display methods
    public void print_display(String[] s) {
    	for(int i = 0; i < s.length;i++) {
    		System.out.print(s[i]);
    	}
    	System.out.println("");
    }
    public String[] disp_init(String[] s) {
    	for(int i = 0; i < s.length;i++) {
    		s[i] = "*";
    	}
    	return s;
    }
    
    //Game Logic methods    
    public boolean game_parse(String question, String t, String[] disp) { 
    	boolean flag = false;
    	String[] answer = string_to_array(t);//to not affect the original array    	
    	for(int i = 0; i < answer.length;i++) {
    		if(answer[i].equals(question)){
    			disp[i] = question;//update display
    			flag = true;
    		}
    	}
    	
    	return flag;
    }
    
    public boolean win_condition(String[] disp) { 
    	for(int i = 0; i < disp.length;i++) {
    		if(disp[i] == "*"){return false;}
    	}
    	return true;
    }
}