import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * CountSubstrings class tests the difference between the execution time between 
 * an ArrayList and a LinkedList.
 * 
 * @author Kashish Saxena
 * @version February 14, 2020
 */
public class CountSubstrings
{
    public static void main(String[] args) throws FileNotFoundException {
	Scanner scanner = new Scanner(System. in);     
	
	// Prompt for a text file input
	System.out.print("Enter the path for the input file: ");
	String inputFile = scanner.nextLine();
	Scanner sin = new Scanner (new File(inputFile));  
	
	// Prompt for a pattern input
	System.out.print("Enter pattern to look for: ");
	String pattern = scanner.nextLine();      
	
	// Converting pattern into an arraylist of characters
	ArrayList<Character> ptn = new ArrayList<Character>();
	ptn = convertStringToArraylist(pattern);     
	
	String str;
	int count = 0;
	long start = System.currentTimeMillis();
	ArrayList<Character> arr = new ArrayList<Character>();
	while (sin.hasNext()){
	    str = sin.next();
	    arr = convertStringToArraylist(str);
	    int found = findBrute(arr,ptn);
	    if (found != -1)
		count++;
	}
	sin.close();        
	long end = System.currentTimeMillis();
	long diff = end -start;
	System.out.println("Using ArrayList: "+count+ " matches, derived in " + diff + " milliseconds.");
	
	Scanner lin = new Scanner(new File(inputFile));       
	
	// Converting pattern into an Linkedlist of characters
	LinkedList<Character> ptn2 = new LinkedList<Character>();
	ptn2 = convertStringToLinkedlist(pattern);
	
	String str2;
	int count1 = 0;
	start = System.currentTimeMillis();
	LinkedList<Character> link = new LinkedList<Character>();
	while (lin.hasNext()){
	    str2 = lin.next();
	    link = convertStringToLinkedlist(str2);
	    int found = findBrute(link,ptn2);
	    if(found!=-1)
		count1++;
	}
	lin.close();
	end = System.currentTimeMillis();
	diff = end -start;
	System.out.println("Using LinkedList: "+count1+ " matches, derived in " + diff + " milliseconds.");
    }
    
    /**
     *  findBrute returns the lowest index at which substring pattern begins in text (or
     *  else -1). 
     *  
     *  @param text List<Character> A list of characters of a text
     *  @param pattern List<Character> A list of characters of a pattern to find in a text
     *  
     *  @return int the lowest index at which the pattern occurs in a text
     */
    private static int findBrute (List <Character> text, List <Character> pattern) 
    {
	int n = text.size ();
	int m = pattern.size ();
	for (int i = 0 ; i <= n - m ; i++)
	{ // try every starting index
	    // within text
	    int k = 0; // k is index into pattern
	    while (k < m && text.get (i + k) == pattern.get (k))
	    // kth character of pattern matches
		k++;
	    if (k == m)
	    { // if we reach the end of the pattern,
		return i; // substring text[i..i+m-1] is a match
	    }
	}
	return -1;
    }
    
    /**
     *  convertStringToArraylist converts a string into an ArrayList.
     *  
     *  @param str String input to the method 
     *  
     *  @return ArrayList<Character> an ArrayList of characters
     */
    public static ArrayList<Character> convertStringToArraylist(String str) {
	ArrayList<Character> charList = new ArrayList<Character>();      
	for(int i = 0; i<str.length();i++){
	    charList.add(str.charAt(i));
	}
	return charList;
    }

    /**
     *  convertStringToLinkedlist converts a string into a LinkedList.
     *  
     *  @param str String input to the method 
     *  
     *  @return LinkedList<Character> a LinkedList of characters
     */
    public static LinkedList<Character> convertStringToLinkedlist(String str) {
	LinkedList<Character> charList = new LinkedList<Character>();      
	for(int i = 0; i<str.length();i++){
	    charList.add(str.charAt(i));
	}
	return charList;
    }
}
