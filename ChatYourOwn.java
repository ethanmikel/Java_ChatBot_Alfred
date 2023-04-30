import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set; 
import java.util.TreeSet;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.File;
import java.util.*;
import static java.lang.System.*;
import java.util.Arrays;

/** This class is responsible for returning a random String response based upon what a users has inputed. 
*<p>
* These different response are considered to be random because even though the user has control on what part if the if-loop, so the user doesn't have the same experience each time.
*<p> 
*Also an input could also then cause for an additional loop to occur such as in the calculator, joke machine, or etc. becuase this would allow the ChatBot to act and feel like a real person.
*<p> 
* @version ChatBot Version 1.0
*<p> 
* @author Ethan Mikel
*/
public class ChatYourOwn {

    private String statement, line, company, input;
    private int array[], left, main, right, counter;
    private TreeMap<String,Set<String>> map;

/** Intalizes the private variable to a base line value, these variables will then be responsible for returning an output, keeping count constant across the whole program, or having a major part in another method. 
*<p>
*@param There are no parameters for this method
*<p> 
*@return Nothing will be returned from this method. 
*/
    public ChatYourOwn() {
        statement = "";
        line = "";
        company = "";
        input = "";
        counter = 0;
        left = 0;
        main = 0;
        right = 0;
        array = new int[] {};
        map = new TreeMap<String,Set<String>>();

    }
/** This method is responsible for intalize the private variables, which would then allow them to have the correct variable associated with them.   
*<p>
* This method is important because it allows for these variables the chance to get intalized before they are needed across the entire program. 
*<p> 
* @param The parameters are an String statement, String line, String company, String input, int counter, int left, int right, int main, an int array, and a TreeMap map. 
*<p> 
*@return No return for this method.
*<p> 
*/
   public ChatYourOwn(String statement, String line, String company, String input, int counter, int left, int right, int main, int array, TreeMap<String,Set<String>> map) {
        this.statement = statement;
        this.line = line;
        this.company = company;
        this.input = input;
        this.right = right;
        this.left = left;
        this.main = main;
        this.counter = counter;
        this.array = new int[] {};
        this.map = map;
    }
/** This method is responsible for setting the private variable, statement, so that the user will be able to have a different reponse each time they have an input.
*<p> 
* @param The parameter is String s because this will allow r to be used and returned in other classes.
*<p> 
*@return No return for this method.
*<p> 
*/
   public void setStatement(String s) {
       statement = s;
   }
/** This method is responsible for returning the private variable, statement, so that the user and program be able to call the private variable and return it.
*<p>
* @param There are no paramters for this class.
*<p> 
*@return Statement will be returned from this method.
*<p> 
*/
   public String getStatement() {
       return statement;
   }
/** This method is responsible for setting the private variable, counter, so that the program will be able to keep count constant across the entire program.
*<p> 
* @param The parameter is a int c because this will allow c to be used and returned in other classes.
*<p> 
*@return No return for this method.
*<p> 
*/
   public void setCounter(int c) {
       counter = c;
   }
/** This method is responsible for returning the private variable, counter, so that the user and program be able to call the private variable and use it across the entire program.
*<p>
* @param There are no paramters for this class.
*<p> 
*@return Counter will be returned from this method.
*<p> 
*/
   public int getCounter() {
       return counter;
   }
/** This method is responsible for setting the private variable, map, so that the program will be able use this TreeMap to keep track of data input from a file and from the user.
*<p> 
* @param The parameter is a TreeMap that is a String,Set<String> named m because in doing this it will allow for a more versatile experience for the user and program.
*<p> 
*@return The return for this method is m because this will allow the program and the user the ability to see that when they are setting the map that it is actually setting.
*<p> 
*/
   public TreeMap<String,Set<String>> setMap(TreeMap<String,Set<String>> m) {
       map = m;
       return m;
   }
/** This method is responsible for returning the private variable, map, so that the user and program be able to call the private variable and use it across the entire program.
*<p>
* @param There are no paramters for this class.
*<p> 
*@return Map will be returned as a result of this method.
*<p> 
*/
   public TreeMap<String,Set<String>> getMap() {
       return map;
   }
/** This method is responsible for setting the variable, productComp, which is based upon other an input that has been given from the user in the next method if-loop.
*<p> 
*The method is also an if-loop in order to add in the data that has been given from a data file in the next method. It is adding in this data into a TreeSet in order to be called by the next method to then be returned. 
*<p> 
* @param The parameter the String line because this show the method how many inputs they will have and not go into an out of bound situation.
*<p> 
*@return No return for this method.
*<p> 
*/
   public void setCompanyProduct(String line) {
      String[] companyRelative = line.split(" ");
      String company = companyRelative[0];
      String productComp = companyRelative[1];
   
      if(map.containsKey(company)) {
         map.get(company).add(productComp);
      }
      else {
         Set<String> productComps = new TreeSet<String>();
         productComps.add(productComp);
         map.put(company,productComps);
      }
   }
/** This method is responsible for getting the variable, productComp, in order to add it to the return statement in this method.
*<p> 
*This method is first making a blank String and is then adding both the company name and the companies products to this string, so the output that will be called in the next methods if loop.
*<p> 
* @param The parameter is the String company, so it can be used and called in this method.
*<p> 
*@return The return for this method is s, which will be called in the next method.
*<p> 
*/
   public String getChatYourOwn(String company) {
      String s = "";
      s+=("The " +company+ "'s current product line-up is: ");
      for(String productComp : map.get(company)) {
         s+=(productComp);
         s+=(" ");
      }
      return s;
   }
/**This method is reponsible for callng and printing out what is being solved. It is doing this by using a for-each loop to copy the Set to then be used and printed.
*<p> 
* @param There are no parameters for this method.
*<p> 
*@return There are no return for this method.
*<p> 
*/
   public void solve(){
      for(String i:map.keySet()) {
         System.out.println(getChatYourOwn(i));
      }
   
   }
/**This method is reponsible for setting uniques, which will then be used to split the users input. 
*<p> 
It is making a TreeSet to then put the user data in, so that it will then be able to sorted and called in another method.
*<p> 
* @param The parameters for this is the String input that the user, will input in the nexts method main-if loop.
*<p> 
*@return The return for this method is the uniques that were dervided from the user's input.
*<p> 
*/
   public static Set<String> getUniques(String input)
   {
      Set<String> uniques = new TreeSet<String>();
   
      String[] words = input.split(", ");
   
      uniques = new TreeSet<String>(Arrays.asList(words));
      return uniques;
   }
/**This method is responsible for getting and returning the duplicates that were inputed when the user inputed their list.
*<p> 
*It is doing this by calcualting if more than one part of the input have the same variables as another part of the input. 
*<p> 
* @param The parameters for this is the String input that the user, that will input in the nexts method main-if loop.
*<p> 
*@return The return for this method is the duplicates that were found in this method. This will then be returned in the next method main if-loop.
*<p> 
*/
   public static Set<String> getDuplicates(String input)
   {
      String[] words = input.split(" ");
      Set<String> uniques = new TreeSet<String>(Arrays.asList(words));
   
      Set<String> duplicates = new TreeSet<String>();
   
      int count = 0;
   
      for(String string1: uniques){
         count = 0;
         for(String string2: words){
            if (string1.equals(string2)){
               count += 1;
            }
         }
         if (count > 1){
            duplicates.add(string1);
         }
      }
      return duplicates;
   }
/**This method is a MergeSort algrothim that is desinged to give a more efficent sorting feature to the user. This will be used when the user has alot of inputs that are scrictly just numbers.
*<p> 
*It is calculating where the larger numbers are in comparison to the smaller numbers, and then moving these numbers according to where it has found them to be.
*<p> 
* @param The parameters for this is an array, intergers left, main, and right. That will be used to move the numbers according to how large or small they are.
*<p> 
*@return There is no return for this method.
*<p> 
*/
   public void merge(int array[], int left, int main, int right) {
      int number1 = main - left + 1;
      int number2 = right - main;
      int arrayLeft[] = new int[number1];
      int arrayRight[] = new int[number2];
      for (int i = 0; i < number1; ++i)
         arrayLeft[i] = array[left + i];
      for (int j = 0; j < number2; ++j)
         arrayRight[j] = array[main + 1 + j];
      int i = 0, j = 0;
      int k = left;
      while (i < number1 && j < number2) {
         if (arrayLeft[i] <= arrayRight[j]) {
            array[k] = arrayLeft[i];
            i++;
         }
         else {
            array[k] = arrayRight[j];
            j++;
         }
         k++;
      }
      while (i < number1) {
         array[k] = arrayLeft[i];
         i++;
         k++;
      }
      while (j < number2) {
         array[k] = arrayRight[j];
         j++;
         k++;
      }
   }
/** This method is responible for sorting the input that was given by the user. It does this by calculting the number of passes and what it will need to do in order to get the input sorted.
*<p> 
*It does this by using a an if loop to sort through the data, if the programmer want to show the user what is occuring they can uncommet the last two lines.
*<p> 
* @param The parameters for this is an array, intergers left, main, and right. That will be used to move the numbers according to how large or small they are.
*<p> 
*@return There is no return for this method. It is being returned in the next method if-loop.
*<p> 
*/
   public void sort(int array[], int left, int right) {
      if (left < right) {
         int main = (left + right) / 2;
         sort(array, left, main);
         sort(array, main + 1, right);
         merge(array, left, main, right);
         counter += 1;
         //System.out.print("Pass " + counter + ": ");
         //printArray(array);
      }
   }
/**This method is responsible for printing out the sorted array that has been dervived from the previous two methods.
*<p> 
*It is doing this by using a for-loop to go through the entire array and then printing out each individual element.
*<p> 
* @param The parameters for this is an array, which is being used to print out each individual element in the sorted and the number of passes it takes to sort it.
*<p> 
*@return There is no return for this method. It is being returned in the next method if-loop.
*<p> 
*/
   public static void printArray(int array[]) {
      int n = array.length;
      for (int i = 0; i < n; ++i) {
         System.out.print(array[i] + " ");
      }
   }
/** This method is responsible for returning a response which is based upon an input that the user has given to the program.
*<p> 
*In this method there is an if-loop that is the main thing that is controlling what is being returned, which is using the statement private variable in order to see if the user input matches any of the keywords that are in the loop.
*<p> 
*If no keyword is found than either 20 different random response will returned, or a more in depth repsonse that will ask a question to the user. Which is shown when the user says an "I want something" statement.
*<p> 
* @param The parameter is the String statement, already definined in a next method.
*<p> 
*@return The return for this method is some type of response that is determined in this loop.
*<p> 
*/
   public String getResponse(String statement) throws IOException {
      String response = "";
      if (statement.length() == 0) {
         response = "Say something, please.";
      }
      else if (keyword(statement, "no") >= 0) {
         int random = (int)(Math.random()*6);
         if(random==1)
            response = "Why so negative?";
         else if (random==2)
            response = "Ok Then.";
         else if (random==3)
            response = "How can I help you then?"; 
         else if (random==4)
            response = "Welp, I am out of ideas."; 
         else
            response = statement;
      }
      else if (keyword(statement, "yes") >= 0)
      {
         int random = (int)(Math.random()*6);
         if(random==1)
            response = "Why so positve?";
         else if (random==2)
            response = "Thats great!";
         else if (random==3)
            response = "Can you tell me more about it?"; 
         else if (random==4)
            response = "Wow, that amazing."; 
         else
            response = statement;
      }
      else if (keyword(statement, "maybe") >= 0) {
         int random = (int)(Math.random()*6);
         if(random==1)
            response = "Why aren't you sure?";
         else if (random==2)
            response = "I think you may need some guidance.";
         else if (random==3)
            response = "Why?"; 
         else if (random==4)
            response = "Let me help you, so you can become sure."; 
         else
            response = "Just maybe?";
      } 
      else if (keyword(statement, "I don't know") >= 0 || keyword(statement, "I'm not sure") >= 0) {
        
         int random = (int)(Math.random()*5);
         if(random==1)
            response = "Well then, I don't know then.";
         else if (random==2)
            response = "I think you may need some guidance.";
         else if (random==3)
            response = "Let me help you, so you can become sure."; 
         else if (random==4)
            response = "I'm not sure, I am just a computer."; 
      }
      else if (keyword(statement, "Hello") >= 0) {
         int random = (int)(Math.random()*6);
         if(random==1)
            response = "Hello, how are you today?";
         else if (random==2)
            response = "Good Bye, just kidding!";
         else if (random==3)
            response = "How may I help you?"; 
         else if (random==4)
            response = "I think I am supposed to hello back."; 
         else if (random==5)
            response = statement;
      }
      else if (keyword(statement, "Thanks") >= 0 || keyword(statement, "Thank You") >= 0) {
         response = "Your Welcome! Anything else you need?";
      }
      else if (keyword(statement, "Ok") >= 0 || keyword(statement, "Okay") >= 0) {
         int random = (int)(Math.random()*4);
         if(random==1)
            response = "OK then.";
         else if (random==2)
            response = "Anything else you need help with?";
         else if (random==3)
            response = statement;
      }
      else if (keyword(statement, "how are you") >= 0) {
         int random = (int)(Math.random()*6);
         if(random==1)
            response = "I am good. How are you?";
         else if (random==2)
            response = "I don't have emotions, but how are you?";
         else if (random==3)
            response = "Why, do you want to know?"; 
         else if (random==4)
            response = "I am stuck in a computer, help."; 
         else
            response = "Emotions? Tell me more about them.";
      } 
      else if (keyword(statement, "what do you do") >= 0 || keyword(statement, "help") >= 0) {
         response = "Hi, I am Alfred. My job is to make your life easier by being your virtual assistant.\nI can do this by recommending you various things like what movie to watch, what book to read, what song you\nshould listen to, where you should go to eat, and\nthe newest technology products that have been released. I also am able to calculate any four-function problem you may have, tell the current time and date,\nflip a coin, and pick a random number for you. I also have the capability to tell you a Fun Fact about my species, computers. I also can help save any type of\nlist that you may have and sort through any data that you may have. Also like a mention early, I have designed a special challenge just for, to help you get\nfamiliar with me. All you have to do is tell me which movie this quote is from, \"Shall we play a game\" and input it in my movie recommendation to start it off.\n";
      }
      else if (keyword(statement, "facts") >= 0 || keyword(statement, "fact") >= 0) {
         int random = (int)(Math.random()*11);
         if(random==1)
            response = "The first electronic computer ENIAC weighed more than 27 tons and took up 1800 square feet.";
         else if (random==2)
            response = "TYPEWRITER is the longest word that you can write using the letters only on one row of the keyboard of your computer.";
         else if (random==3)
            response = "Doug Engelbart invented the first computer mouse in around 1964 which was made of wood."; 
         else if (random==4)
            response = "There are more than 5000 new computer viruses released every month.."; 
         else if (random==5)
            response = "If there was a computer as powerful as the human brain, it would be able to do 38 thousand trillion operations per second and hold more than 3580 terabytes of memory.";
         else if (random==6)
            response = "The password for the computer controls of nuclear tipped missiles of the U.S was 00000000 for eight years.";
         else if (random==7)
            response = "HP, Microsoft and Apple have one very interesting thing in common – they were all started in a garage.";
         else if (random==8)
            response = "The first 1GB hard disk drive was announced in 1980 which weighed about 550 pounds, and had a price tag of $40, 000..";
         else if (random==9)
            response = "The original name of Windows was Interface Manager.";
         else
            response = "The first microprocessor created by Intel was the 4004. It was designed for a calculator, and in that time nobody imagined where it would lead.";
      } 
      else if (keyword(statement, "Think different") >= 0) {
         response = "                        ______________\n                       /             /|\n                      /             / |\n                     /____________ /  |\n                    | ___________ |   |\n                    ||           ||   |\n                    ||           ||   |\n                    ||           ||   |\n                    ||___________||   |\n                    |   _______   |  /\n                   /|  (_______)  | /\n                  ( |_____________|/\n                   \\\n                  .=======================.\n                  | ::::::::::::::::  ::: |\n                  | ::::::::::::::[]  ::: |\n                  |   -----------     ::: |\n                  `-----------------------'\n\n                       Think different\n\nWell done you now have a little better grasp as to what I can do!\nIf you have any doubts about what I can do just type \"Help\" in to\nthe chat and anything that I say I can do, just type in that word!\n";
      } 
      else if (keyword(statement, "James Gosling") >= 0) {
         response = "Oh, so you do know. Ok, we will try a harder one. What was Steve Jobs favorite book? Type it in my book recommendation feature, if you dare.";
      }
      else if (keyword(statement, "list") >= 0 || keyword(statement, "lists") >= 0 || keyword(statement, "remember") >= 0 || keyword(statement, "save") >= 0){
      
         Scanner scan = new Scanner(System.in);
         
         System.out.print("Please input your list. You can use words, numbers, and special characters.\n*In order to use the list feature, you can either use a space or comma to seperate the item in your list.\nInput Your List Here: ");
         String input = scan.nextLine();
         System.out.println("Duplicates In Your List: " + ChatYourOwn.getDuplicates(input));
         System.out.println("Your Sorted List: " + ChatYourOwn.getUniques(input));

      }
      else if (keyword(statement, "companies") >= 0 || keyword(statement, "products") >= 0 || keyword(statement, "product") >= 0 || keyword(statement, "company") >= 0){
         Scanner in = new Scanner(new File("codeYourOwnTXT.txt"));
      
         int z = in.nextInt();
         in.nextLine();
         ChatYourOwn a = new ChatYourOwn();
         for(int x = 0; x<z;x++)
         {
            String n = in.nextLine();
            a.setCompanyProduct(n);
         }
         a.solve();
      } 
      else if (keyword(statement, "sort") >= 0 || keyword(statement, "sorted") >= 0 || keyword(statement, "arrange") >= 0 || keyword(statement, "order") >= 0){
         Scanner in = new Scanner(System.in);
            
         System.out.print("To use the more efficent number sorter feature first input how many items you would like to be sorted, than input your list of item.\n*Note that to input you list add a space between your items.\n");
         System.out.print("How Many Items In Your List: ");
         int length = in.nextInt();
         int [] array = new int[length];
         System.out.print("Enter in Your Items: ");
            
         for(int i=0; i<length; i++ ) {
            array[i] = in.nextInt();         }
         System.out.println();
         ChatYourOwn ob = new ChatYourOwn();
         ob.sort(array, 0, array.length - 1);
            
         System.out.print("\nYour Sorted Data: ");
         printArray(array); 
         System.out.println();     
      }
        //movie recommendation
      else if (keyword(statement, "movies") >= 0 || keyword(statement, "flims") >= 0 || keyword(statement, "movie") >= 0 || keyword(statement, "flim") >= 0){
         Scanner in = new Scanner( System.in );
      
         System.out.println("All movies recommended have been released in 2020.");
         System.out.println("What type of movie genre would you like to watch?\nType \"Action\" for Action. \nType \"Comedy\" for Comedy. \nType \"Documentary\" for Documentary. \nType \"Sci-Fi\" for Sci-Fi. \nType \"Mystery\" for Mystery. \nType \"Family\" for Family. \nType \"Musical\" for Musical. \nType \"Drama\" for Drama. \nType \"Romance\" for Romance."); 
         System.out.print("Genre: ");     
         String choice = in.nextLine();
      
         if (choice.equals("Action") || choice.equals("action")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should watch: Wonder Woman 1984");
            else if (random==2)
               System.out.print("You should watch: No Time to Die");
            else if (random==3)
               System.out.print("You should watch: Extraction"); 
            else if (random==4)
               System.out.print("You should watch: The Old Guard"); 
            else
               System.out.print("You should watch: Tenet");
         }
         else if (choice.equals("Comedy") || choice.equals("comedy")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should watch: Mr. Dolittle");
            else if (random==2)
               System.out.print("You should watch: The Gentlemen");
            else if (random==3)
               System.out.print("You should watch: The King of Staten Island"); 
            else if (random==4)
               System.out.print("You should watch: The Lovebirds"); 
            else
               System.out.print("You should watch: Uncorked");
         }
         else if (choice.equals("Documentary") || choice.equals("documentary")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should watch: Athlete A");
            else if (random==2)
               System.out.print("You should watch: A Secret Love");
            else if (random==3)
               System.out.print("You should watch: Spaceship Earth"); 
            else if (random==4)
               System.out.print("You should watch: The Last Dance"); 
            else
               System.out.print("You should watch: Miss Ameicana");
         }
         else if (choice.equals("Sci-Fi") || choice.equals("sci-fi") || choice.equals("scifi")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should watch: The Invisible Man");
            else if (random==2)
               System.out.print("You should watch: Over the Moon");
            else if (random==3)
               System.out.print("You should watch: The Vast of Night"); 
            else if (random==4)
               System.out.print("You should watch: Time to Hunt"); 
            else
               System.out.print("You should watch: The Platform");
         }
         else if (choice.equals("Mystery") || choice.equals("mystery")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should watch: The Bay of Silence");
            else if (random==2)
               System.out.print("You should watch: Shirley");
            else if (random==3)
               System.out.print("You should watch: Greenland"); 
            else if (random==4)
               System.out.print("You should watch: Vivarium"); 
            else
               System.out.print("You should watch: Antlers");
         }
         else if (choice.equals("Family") || choice.equals("family")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should watch: Doolittle");
            else if (random==2)
               System.out.print("You should watch: The Call of the Wild");
            else if (random==3)
               System.out.print("You should watch: Onward"); 
            else if (random==4)
               System.out.print("You should watch: The One and Only Ivan"); 
            else
               System.out.print("You should watch: Mulan");
         
         }
         else if (choice.equals("Musical") || choice.equals("musical")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should watch: Annette");
            else if (random==2)
               System.out.print("You should watch: In the Heights");
            else if (random==3)
               System.out.print("You should watch: Western Stars"); 
            else if (random==4)
               System.out.print("You should watch: Cats"); 
            else
               System.out.print("You should watch: Rocketman");
         
         }
         else if (choice.equals("Drama") || choice.equals("drama")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should watch: The Photograph");
            else if (random==2)
               System.out.print("You should watch: Bad Education");
            else if (random==3)
               System.out.print("You should watch: The Trial of the Chicago 7"); 
            else if (random==4)
               System.out.print("You should watch: The Assistant"); 
            else
               System.out.print("You should watch: The Way Back");
         
         }
         else if (choice.equals("Romance") || choice.equals("romance")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should watch: The Broken Hearts Gellery");
            else if (random==2)
               System.out.print("You should watch: Words on Bathroom Walls");
            else if (random==3)
               System.out.print("You should watch: Valley Girl"); 
            else if (random==4)
               System.out.print("You should watch: Then Came You"); 
            else
               System.out.print("You should watch: Chemical Hearts");
         
         }
         else if (choice.equals("WarGames") || choice.equals("war games") || choice.equals("war game") || choice.equals("War Games")) {
            System.out.println("Oh, you found the secret of me. Okay then, type \"Arrays\" into my joke machine.");
            
         }
         System.out.print("\n");
      }
      //movie end
      //music recommendation
      else if (keyword(statement, "song") >= 0 || keyword(statement, "music") >= 0 || keyword(statement, "any new music") >= 0){
         Scanner in = new Scanner( System.in );
      
         System.out.println("All songs recommended have all been released in 2020, and some songs recommended may have a Parental Advisory warning.");
         System.out.println("What type of song genre would you like to listen to?\nType \"Rock\" for Rock. \nType \"Hip Hop\" for Hip Hop. \nType \"Pop\" for Pop. \nType \"Musical Theatre\" for Musical Theatre. \nType \"Country\" for Country. \nType \"Alternative\" for Alternative. \nType \"Gospel\" for Gospel."); 
         System.out.print("Genre: ");     
         String choice = in.nextLine();
      
         if (choice.equals("Rock") || choice.equals("rock")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should listen to: Shot In The Dark | By: AC/DC");
            else if (random==2)
               System.out.print("You should listen to: Dance Of The Clairvoyants | By: Peral Jam");
            else if (random==3)
               System.out.print("You should listen to: Oh Yeah!  | By: Green Day"); 
            else if (random==4)
               System.out.print("You should listen to: A Little Bit Off  | By: Five Finger Death Punch"); 
            else
               System.out.print("You should listen to: Flowers On A Grave | By: Bush"); 
         }
         else if (choice.equals("Hip Hop") || choice.equals("hip hop")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should listen to: WHATS POPPIN | By: Jack Harlow"); 
            else if (random==2)
               System.out.print("You should listen to: Laugh Now Cry Later | By: Drake"); 
            else if (random==3)
               System.out.print("You should listen to: FRANCHISE | By: Travis Scott"); 
            else if (random==4)
               System.out.print("You should listen to: Lemonade | By: Gunna"); 
            else
               System.out.print("You should listen to: Runnin | By: 21 Savage"); 
         }
         else if (choice.equals("Pop") || choice.equals("pop")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should listen to: Rain On Me | By: Lady Gaga"); 
            else if (random==2)
               System.out.print("You should listen to: Go Crazy | By: Chris Brown"); 
            else if (random==3)
               System.out.print("You should listen to: Kings & Queens | By: Ava Max"); 
            else if (random==4)
               System.out.print("You should listen to: Prisoner | By: Miley Cyrus"); 
            else
               System.out.print("You should listen to: You Should Be Sad | By: Halsey"); 
         }
         else if (choice.equals("Musical Theatre") || choice.equals("musical theatre")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should listen to: Rose’s Turn | Musical: Gypsy"); 
            else if (random==2)
               System.out.print("You should listen to: Ol' Man River | Musical: Show Boat"); 
            else if (random==3)
               System.out.print("You should listen to: \"Finishing The Hat\" | Musical: Sunday in the Park with George"); 
            else if (random==4)
               System.out.print("You should listen to: \"And I Am Telling You I’m Not Going\" | Musical: Dreamgirls"); 
            else
               System.out.print("You should listen to: \"Some Enchanted Evening\" | Musical: South Pacific"); 
         }
         else if (choice.equals("Country") || choice.equals("country")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should listen to: One Of Them Girls | By: Lee Brice"); 
            else if (random==2)
               System.out.print("You should listen to: More Than My Hometown | By: Morgan Wallen"); 
            else if (random==3)
               System.out.print("You should listen to: One Beer | By: HARDY"); 
            else if (random==4)
               System.out.print("You should listen to: One Margarita | By: Luke Bryan"); 
            else
               System.out.print("You should listen to: I Hope | By: Gabby Barrayett"); 
         }
         else if (choice.equals("Alternative") || choice.equals("alternative")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should listen to: Level of Concern | By: Twenty One Pilots"); 
            else if (random==2)
               System.out.print("You should listen to: Exile | By: Taylor Swift"); 
            else if (random==3)
               System.out.print("You should listen to: Trouble's Coming | By: Royal Blood"); 
            else if (random==4)
               System.out.print("You should listen to: Can You Afford to Be Individual | By: Nothing But Thieves"); 
            else
               System.out.print("You should listen to: Overwhelmed | By: Royal & the Serpent"); 
         
         }
         else if (choice.equals("Gospel") || choice.equals("gospel")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should listen to: Why Not Me | By: Tasha Page-Lockhart"); 
            else if (random==2)
               System.out.print("You should listen to: Thank You For It All | By: Marvin Sapp"); 
            else if (random==3)
               System.out.print("You should listen to: Movin' On | By: Mali Music"); 
            else if (random==4)
               System.out.print("You should listen to: Non Stop Praise | By: Daniel Ouedraogo"); 
            else
               System.out.print("You should listen to: Speak To Me | By: Koryn Hawthorne"); 
               
         } 
         if (choice.equals("Personal") || choice.equals("companyal")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should listen to: Space Girl | By: Frances Forever"); 
            else if (random==2)
               System.out.print("You should listen to: Heart Emoji | By: Ludic"); 
            else if (random==3)
               System.out.print("You should listen to: Sedona | By: Sir Chloe"); 
            else if (random==4)
               System.out.print("You should listen to: Native New Yorker | By: Odyssey"); 
            else
               System.out.print("You should listen to: Nothing / Sad N Stuff | By: Lizzy McAlpine"); 
               
         }      
         System.out.print("\n");
      }
      //music end
      //book recommendation
      else if (keyword(statement, "book") >= 0 || keyword(statement, "read") >= 0 || keyword(statement, "books") >= 0){
         Scanner in = new Scanner( System.in );
      
         System.out.println("What type of book genre would you like to read?\nType \"Action & Adventure\" for Action & Adventure. \nType \"Classic\" for Classic. \nType \"Autobiography\" for Autobiography. \nType \"Historical Fiction\" for Historical Fiction. \nType \"Poetry\" for Poetry. \nType \"Fantasy\" for Fantasy. \nType \"Mystery\" for Mystery."); 
         System.out.print("Genre: ");     
         String choice = in.nextLine();
      
         if (choice.equals("Action & Adventure") || choice.equals("action & adventure") || choice.equals("action and adventure") || choice.equals("Action and Adventure")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should read: Treasure Island | By: Robert Louis Stevenson");
            else if (random==2)
               System.out.print("You should read: The Call of the Wild | By: Jack London");
            else if (random==3)
               System.out.print("You should read: Jurassic Park | By: Michael Crichton");
            else if (random==4)
               System.out.print("You should read: The Hunger Games | By: Suzanne Collins");
            else
               System.out.print("You should read: The Girl with the Dragon Tattoo | By: Robert Ludlum");
         }
         else if (choice.equals("Classic") || choice.equals("classic")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should read: To Kill a Mockingbird | By: Harper Lee");
            else if (random==2)
               System.out.print("You should read: The Great Gatsby | By: F. Scott Fitzgerald");
            else if (random==3)
               System.out.print("You should read: 1984 | By: George Orwell");
            else if (random==4)
               System.out.print("You should read: A House for Mr. Biswas | By: V.S. Naipaul");
            else
               System.out.print("You should read: Emma | By: Jane Austen");
         }
         else if (choice.equals("Autobiography") || choice.equals("autobiography") ) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should read: Long Walk to Freedom | By: Nelson Mandela");
            else if (random==2)
               System.out.print("You should read: The Diary of a Young Girl | By: Anne Frank");
            else if (random==3)
               System.out.print("You should read: Autobiography of Mark Twain | By: Mark Twain");
            else if (random==4)
               System.out.print("You should read: The Story of My Experiments with Truth | By: Mahatma Gandhi");
            else
               System.out.print("You should read: The Autobiography of Malcolm X | By: Malcolm X");
         }
         else if (choice.equals("Historical Fiction") || choice.equals("historical fiction")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should read: A Gentleman in Moscow | By: Amor Towles");
            else if (random==2)
               System.out.print("You should read: A Rising Man | By: Abir Mukherjee");
            else if (random==3)
               System.out.print("You should read: Alias Grace | By: Margaret Atwood");
            else if (random==4)
               System.out.print("You should read: Beloved | By: Toni Morrison");
            else
               System.out.print("You should read: The Book Thief | By: Markus Zusak");
         }
         else if (choice.equals("Poetry") || choice.equals("poetry")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should read: The Red Wheelbarrayow | By: William Carlos Wiliams");
            else if (random==2)
               System.out.print("You should read: The Waste Land | By: T.S. Eliot");
            else if (random==3)
               System.out.print("You should read: The Road Not Taken| By: Robert Frost");
            else if (random==4)
               System.out.print("You should read: We Real Cool | By: Gwendolyn Brooks");
            else
               System.out.print("You should read: One Art | By: Elizabeth Bishop");
         }
         else if (choice.equals("Fantasy") || choice.equals("fantasy")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should read: A Game of Thrones | By: George R.R. Martin");
            else if (random==2)
               System.out.print("You should read: The Fellowship of the Ring | By: J.R.R. Tolkien");
            else if (random==3)
               System.out.print("You should read: The Lion, the Witch and the Wardrobe | By: C.S. Lewis");
            else if (random==4)
               System.out.print("You should read: The Colour of Magic | By: Terry Pratchett");
            else
               System.out.print("You should read: Assassin's Apprentice | By: Robin Hobb");
         
         }
         else if (choice.equals("Mystery") || choice.equals("mystery")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should read: And Then There Were None | By: Agatha Christie");
            else if (random==2)
               System.out.print("You should read: The Big Sleep | By: Raymond Chandler");
            else if (random==3)
               System.out.print("You should read: Gone Girl | By: Gillian Flynn");
            else if (random==4)
               System.out.print("You should read: The Postman Always Rings Twice | By: James M. Cain");
            else
               System.out.print("You should read: In Cold Blood | By: Truman Capote");
         }              
         else if (choice.equals("Autobiography of a Yogi")) {
            System.out.print("Ok you might be getting it so far, but what is Apple's slogon? If you know than put it in to the chat.");
         }    
         System.out.print("\n");
      }
      //book end
      //food recommendation
      else if (keyword(statement, "food") >= 0 || keyword(statement, "hungry") >= 0 || keyword(statement, "resturant") >= 0 || keyword(statement, "foods") >= 0 || keyword(statement, "meals") >= 0){
         Scanner in = new Scanner( System.in );
      
         System.out.println("What type of cuisines would you like to eat?\nType \"Indian\" for Indian Cuisine. \nType \"Chinese\" for Chinese Cuisine. \nType \"Italian\" for Italian Cuisine. \nType \"Japanese\" for Japanese Cuisine. \nType \"Barbecue\" for Barbecue. \nType \"Mexican\" for Mexican Cuisine. \nType \"Dessert\" for Dessert."); 
         System.out.print("Genre: ");     
         String choice = in.nextLine();
      
         if (choice.equals("Indian") || choice.equals("indian")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should go to: Chennai Café | Location: Frisco, TX");
            else if (random==2)
               System.out.print("You should go to: Saravanaa Bhavan | Location: Irving, TX");
            else if (random==3)
               System.out.print("You should go to: Mughlai | Location: Southlake, TX");
            else if (random==4)
               System.out.print("You should go to: Urban Tadka | Location: Irving, TX");
            else
               System.out.print("You should go to: Royal Sichuan | Location: Richardson, TX");
         }
         else if (choice.equals("Chinese") || choice.equals("chinese")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should go to: Sichuan Folk | Location: Plano, TX");
            else if (random==2)
               System.out.print("You should go to: Yao Fuzi Cuisine | Location: Plano, TX");
            else if (random==3)
               System.out.print("You should go to: Wu Wei Din Chinese Cuisine | Location: Plano, TX");
            else if (random==4)
               System.out.print("You should go to: Canton Chinese Restaurant | Location: Richardson, TX");
            else
               System.out.print("You should go to: Chameli | Location: Richardson, TX");
         }
         else if (choice.equals("Italian") || choice.equals("italian") ) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should go to: Mille Lire | Location: Dallas, TX");
            else if (random==2)
               System.out.print("You should go to: The Charles | Location: Dallas, TX");
            else if (random==3)
               System.out.print("You should go to: Carbone's | Location: Dallas, TX");
            else if (random==4)
               System.out.print("You should go to: Lucia | Location: Dallas, TX");
            else
               System.out.print("You should go to: Sprezza | Location: Dallas, TX");
         }
         else if (choice.equals("Japanese") || choice.equals("japanese")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should go to: Yama Izakaya & Sushi | Location: Plano, TX");
            else if (random==2)
               System.out.print("You should go to: Ikigai Udon | Location: Plano, TX");
            else if (random==3)
               System.out.print("You should go to: Mitsuwa Marketplace | Location: Plano, TX");
            else if (random==4)
               System.out.print("You should go to: Gyu-Kaku Japanese BBQ | Location: Dallas, TX");
            else
               System.out.print("You should go to: Kazy's Gourmet Shop | Location: Dallas, TX");
         }
         else if (choice.equals("Barbecue") || choice.equals("Barbecue")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should go to: Hutchins BBQ & Grill | Location: McKinney, TX");
            else if (random==2)
               System.out.print("You should go to: TEN50 BBQ | Location: Richardson, TX");
            else if (random==3)
               System.out.print("You should go to: Cattleack Barbeque | Location: Dallas, TX");
            else if (random==4)
               System.out.print("You should go to: One90 Smoked Meats | Location: Dallas, TX");
            else
               System.out.print("You should go to: Smoky Rose | Location: Dallas, TX");
         }
         else if (choice.equals("Mexican") || choice.equals("mexican")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should go to: Cantina Laredo | Location: Dallas, TX");
            else if (random==2)
               System.out.print("You should go to: Cilantros Taqueria | Location: South Richardson, TX");
            else if (random==3)
               System.out.print("You should go to: Revolver Taco Lounge | Location: Deep Ellum, TX");
            else if (random==4)
               System.out.print("You should go to: Mi Lindo Oaxaca | Location: Oak Cliff, TX");
            else
               System.out.print("You should go to: Taqueria La Ventana | Location: Dallas, TX");
         
         }
         else if (choice.equals("Dessert") || choice.equals("dessert")) {
            int random = (int)(Math.random()*6);
            if(random==1)
               System.out.print("You should go to: Cane Rosso | Location: Dallas, TX");
            else if (random==2)
               System.out.print("You should go to: CBD Provisions | Location: Dallas, TX");
            else if (random==3)
               System.out.print("You should go to: FT33 | Location: Dallas, TX");
            else if (random==4)
               System.out.print("You should go to: Gemma | Location: Dallas, TX");
            else
               System.out.print("You should go to: HG Sply Co. | Location: Dallas, TX");
         }               
         System.out.print("\n");
      }
      //food end
      //joke beginning 
      else if (keyword(statement, "joke") >= 0 || keyword(statement, "tell me a joke") >= 0 || keyword(statement, "jokes") >= 0){
         Scanner in = new Scanner( System.in );
        
         System.out.println("What type of joke would you like?\nType \"Knock Knock\" for a Knock Knock joke.\nType \"Basic\" for a basic joke.");
        
         String choice = in.nextLine();
        
         
         if (choice.equals("Basic") || choice.equals("basic")) {
            int random2 = (int)(Math.random()*7);
            if(random2==1)
               System.out.println("Did you hear about the actor who fell through the floorboards? \n He was just going through a stage.\nType in \"Done\" or \"Another\"");
            else if (random2==2)
               System.out.println("Hear about the new restaurant called Karma? \n There’s no menu: You get what you deserve.\nType in \"Done\" or \"Another\"");
            else if (random2==3)
               System.out.println("Why do we tell actors to break a leg? \n Because every play has a cast.\nType in \"Done\" or \"Another\"");  
            else if (random2==4)
               System.out.println("Did you hear about the mathematician who’s afraid of negative numbers? \n He’ll stop at nothing to avoid them.\nType in \"Done\" or \"Another\"");  
            else if (random2==5)
               System.out.println("Did you hear about the claustrophobic astronaut?\n He just needed a little space.\nType in \"Done\" or \"Another\"");
            else
               System.out.println("Why don't scientists trust atoms?\n Because they make up everything.\nType in \"Done\" or \"Another\"");
         }
         else if (choice.equals("Knock Knock") || choice.equals("knock knock")) {
            int random2 = (int)(Math.random()*6);
            if(random2==1)
               System.out.println("I am.\nType \"I am who?\"");
            else if (random2==2)
               System.out.println("A leaf.\nType \"A leaf who?\"");
            else if (random2==3)
               System.out.println("Adore.\nType \"Adore who?\"");  
            else if (random2==4)
               System.out.println("A little old lady.\nType \"A little old lady who?\""); 
            else if (random2==5)
               System.out.println("Hawaii.\nType \"Hawaii who?\"");
            else
               System.out.println("Ice cream soda.\nType \"Ice cream soda who?\"");
         }
         else if (choice.equals("Arrays") || choice.equals("arrayays")) {
            System.out.println("Enter in the Binary Transwerlation of \"Hello World\" into the operation input in the calculator, but first type \"Done\" into the chat.");
         }   
         String choice2 = in.nextLine();
         if (choice2.equals("Another") || choice2.equals("another")) {
            int random2 = (int)(Math.random()*7);
            if(random2==1)
               System.out.println("What sits at the bottom of the sea and twitches?\n A nervous wreck.");
            else if (random2==2)
               System.out.println("What does a nosy pepper do?\n Gets jalapeño business!");
            else if (random2==3)
               System.out.println("How do you keep a bagel from getting away?\n Put lox on it.");  
            else if (random2==4)
               System.out.println("Why don’t Calculus majors throw house parties?\n Because you should never drink and derive.");  
            else if (random2==5)
               System.out.println("I waited all night to see where the sun would rise…\n …And then it dawned on me.");
            else
               System.out.println("What did the buffalo say when his son left for college?\n Bison.");
         }
      
         if (choice2.equals("I am who?") || choice2.equals("i am who?")) {
            System.out.println("Don’t you even know who you are? ");
         }
         else if (choice2.equals("A leaf who?")) {
            System.out.println("A leaf you alone if you leaf me alone. ");
         }
         else if (choice2.equals("Adore who?")) {
            System.out.println("Adore is between you and me so please open up! ");
         }
         else if (choice2.equals("A little old lady who?")) {
            System.out.println("Wow, I didn’t know you could yodel! ");
         }
         else if (choice2.equals("Hawaii who?")) {
            System.out.println("I’m fine, Hawaii you? ");
         }
         else if (choice2.equals("Ice cream soda who?")) {
            System.out.println("Ice scream soda people can hear me! ");
         }
      }
      //joke end
      else if (keyword(statement, "flip a coin") >= 0 || keyword(statement, "flip another coin") >= 0)
      {
         int headsTails = (int)(Math.random()*2);
         if(headsTails==1)
            response = ("Heads\n");
         else
            response = ("Tails\n");
      }
      else if (keyword(statement, "calculator") >= 0 || keyword(statement, "solve") >= 0 || keyword(statement, "evaluate") >= 0) {
         Scanner numInput = new Scanner( System.in );
      
         System.out.print("Please Enter the First Number: ");
         double number1 = numInput.nextInt();
         numInput.nextLine(); 
      
         System.out.print("Please Enter the Second Number: ");
         double number2 = numInput.nextInt();
         numInput.nextLine(); 
      
         System.out.println("What operation would you like to do? \nType \"+\" to Add. \nType \"-\" to Subtract. \nType \"*\" to Multiply. \nType \"/\" to Divide.");
         System.out.print("Operation: ");
         String choice = numInput.nextLine();
        
         System.out.print("Solution: ");
      
         if (choice.equals("+")) {
            double answer = number1 + number2;
            System.out.println(number1 + " + " + number2 + " = " + answer);
         }
         else if (choice.equals("-")) {
            double answer = number1 - number2;
            System.out.println(number1 + " - " + number2 + " = " + answer);
         }
         else if (choice.equals("*")) {
            double answer = number1 * number2;
            System.out.println(number1 + " * " + number2 + " = " + answer);
         }
         else if (choice.equals("/")) {
            double answer = number1 / number2;
            System.out.println(number1 + " / " + number2 + " = " + answer);
         }
         else if (choice.equals("01001000 01100101 01101100 01101100 01101111 00100000 01010111 01101111 01110010 01101100 01100100")) {
            System.out.println("You think you can keep going, than who designed Java? If you know type it in the chat.");
         }
      }
      else if (keyword(statement, "time") >= 0 || keyword(statement, "date") >= 0) {
         SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("MMM-dd-yyyy hh:mm aa");
         dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("CST"));
         System.out.print("Current Time & Date: ");
         System.out.println(dateTimeInGMT.format(new Date()));
      }
      else if (keyword(statement, "random number") >= 0 || keyword(statement, "pick a number") >= 0) {
         Scanner numInput = new Scanner( System.in );
      
         System.out.print("Please Enter the Smaller Parameter: ");
         int min = numInput.nextInt();
         numInput.nextLine(); 
      
         System.out.print("Please Enter the Larger Parameter: ");
         int max = numInput.nextInt();
         numInput.nextLine(); 
      
         System.out.print("Random Number from "+min+" to "+max+ ": ");
         int random_int = (int)(Math.random() * (max - min + 1) + min);
         System.out.println(random_int);
      }
      else if (keyword(statement, "I want to", 0) >= 0) {
         response = iWantTo(statement);
      }
      else if (keyword(statement, "I want", 0) >= 0) {
         response = iWant(statement);
      }
      
      else {
         int position = keyword(statement, "you", 0);
      
         if (position >= 0 && keyword(statement, "me", position) >= 0) {
            response = formYouMe(statement);
         }
         else { 
            position = keyword(statement, "I", 0);
         
         if (position >= 0 && keyword(statement, "you", position) >= 0) {
               response = transwerformYouI(statement);
         }
         else {
               response = getRandomResponse();
         }
      }
    }
    return response;
   }
   private String iWantTo(String statement) {
                     
      statement = statement.trim();
      String lastChar = statement.substring(statement.length() - 1);
      if (lastChar.equals(".") || lastChar.equals("!")) {
         statement = statement.substring(0, statement.length() - 1);
      }
      int position = keyword (statement, "I want to", 0);
      String restOfStatement = statement.substring(position + 9).trim();
   	
      return "What would it mean to " + restOfStatement + "?";
      }
   private String iWant(String statement) {
   	statement = statement.trim();
      String lastChar = statement.substring(statement.length() - 1);
      	   
      if (lastChar.equals(".") || lastChar.equals("!")) {
         statement = statement.substring(0, statement.length() - 1);
      }	
      int position = keyword (statement, "I want", 0);
      String restOfStatement = statement.substring(position + 6).trim();
   	   
      return "Would you really be happy if you had " + restOfStatement + "?";
   }
   private String formYouMe(String statement) {
      statement = statement.trim();
      String lastChar = statement.substring(statement.length() - 1);
   	
      if (lastChar.equals(".") || lastChar.equals("!")) {
         statement = statement.substring(0, statement.length() - 1);
      }
      int positionYou = keyword (statement, "you", 0);
      int positionMe = keyword (statement, "me", positionYou + 3);
   
      String restOfStatement = statement.substring(positionYou + 3, positionMe).trim();
      return "What makes you think that I " + restOfStatement + " you?";
   }
   private String transwerformYouI(String statement) { 
      statement = statement.trim();
      String lastChar = statement.substring(statement.length() - 1);
   	
      if (lastChar.equals(".") || lastChar.equals("!")) {
         statement = statement.substring(0, statement.length() - 1);
      } 
      int positionI = keyword (statement, "I", 0);
      int positionYou = keyword (statement, "you", positionI + 1);
   
      String restOfStatement = statement.substring(positionI + 1, positionYou).trim();
      return "Why do you " + restOfStatement + " me?";
  }
  private int keyword(String statement, String goal, int startPos) {
      String phrase = statement.trim().toLowerCase();
      goal = goal.toLowerCase();
           
      int position = phrase.indexOf(goal, startPos);
   
      while (position >= 0) {
         String before = " ", after = " ";
         if (position > 0) {
            before = phrase.substring(position - 1, position);
         }
         if (position + goal.length() < phrase.length()) {
            after = phrase.substring(position + goal.length(),position + goal.length() + 1);
         }
         if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
            return position;
         }
         position = phrase.indexOf(goal, position + 1); 
      }
      return -1;
   } 
   private int keyword(String statement, String goal) {
      return keyword (statement, goal, 0);
   }     
   private String getRandomResponse() {	    
      int whichResponse = (int) (Math.random() * 21);
      String response = "";
   
      if (whichResponse == 0)
         response = "Interesting, tell me more.";
      else if (whichResponse == 1)
         response = "Hmmm.";
      else if (whichResponse == 2)
         response = "Do you really think so?";
      else if (whichResponse == 3)
         response = "You don't say.";
      else if (whichResponse == 4)
         response = "Wow. That is amazing!";
      else if (whichResponse == 5) 
         response = "Why, do you really think that?";
      else if (whichResponse == 6) 
         response = "Okay.";
      else if (whichResponse == 7) 
         response = "That's just great!";
      else if (whichResponse == 8) 
         response = "Just Google it!";
      else if (whichResponse == 9)
         response = "Let me think about that.";
      else if (whichResponse == 10)
         response = "I'm not sure how to respond.";
      else if (whichResponse == 11)
         response = "Ok. Now I wish I was a human!";
      else if (whichResponse == 12)
         response = "You know that I am not real, right?";
      else if (whichResponse == 13)
         response = "How come?";
      else if (whichResponse == 14)
         response = "What do you mean?";
      else if (whichResponse == 15)
         response = "Do all human talk in random because I talk in zeros and ones.";
      else if (whichResponse == 16)
         response = "Maybe try saying it in Binary.";
      else if (whichResponse == 17)
         response = "You know that I get my intelligence from my program.";
      else if (whichResponse == 18)
         response = "Maybe, if I had a real brain I could be able to respond.";
      else if (whichResponse == 19)
         response = "I would say ask Siri, but we both know she isn't reliable.";
      else
         response = "I'm just a computer progam.";
         
      return response;
   }
/** This method is responsible for returing all of the private variables that have been intalized and are being used across the entire program.
*<p> 
* @param There are no parameters.
*<p> 
*@return The return for this method is the statement, counter, and map.
*<p> 
*/
   public String toString() {
       return statement+" "+line+" "+company+" "+input+" "+array+" "+left+" "+main+" "+right+" "+counter+" "+map;
   }
}