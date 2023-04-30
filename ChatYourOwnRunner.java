import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Set; 
import java.util.TreeSet;
import java.io.IOException;

/** This class is responsible for running the program ChatYourOwn, it does this by using a scanner to get the user's input then taking that input and giving it to the other class.
*<p>
*It is also in control of closing out of the ChatBot, by using the key word bye as a the callout word.
*<p> 
* @version ChatBot Version 1.0
*<p> 
* @author Ethan Mikel
*/
public class ChatYourOwnRunner {
/** This method is responsible for running the class ChatYourOwn it does this by using a scanner to get the user's input then taking that input and giving it to the other class.
*<p> 
* @param The parameter is String[] args which makes sure that everything that will be returned is a String.
*<p> 
*@return There is no return for this method because it uses the methods in the ChatYourOwn class.
*<p> 
*/
	public static void main(String[] args) throws IOException {
      System.out.println( "Hello World, my name is Alfred your virtual assistant.\nIf you want to learn more about me type, \"What Do You Do\" or \"Help\" hein the chat! If you would like to end our conversation just type \"Bye\" in the chat.\nChallenge of the Day, do you know where this quote is from: \"Shall we play a game?\" If so, than input the name of the movie into my movie recommendation feature.\n");
      ChatYourOwn chat = new ChatYourOwn();		
      Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println(chat.getResponse(statement));
			statement = in.nextLine();
		}
   
	}
}