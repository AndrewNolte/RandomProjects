import java.io.File;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//eta oin shr dlu cmf wyp vbg kjq xz
public class Letter_Frequency_Cryptogrophy {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		boolean isDone = false;
		int x = 25;
		char[] lettersInABC = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
							   'n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] lettersInAscending = {'z','x','q','j','k','g','b','v','p','y','w','f','m',
				   			   'c','u','l','d','r','h','s','n','i','o','a','t','e'};
		char[] lineLettersInAscending = new char[25];
		int[] letterCount = new int[25];
		
		
		//File file = new File(system.in);
		Scanner sc; 
		try{			
		sc = new Scanner(new File("Cry.txt"));
		}
		catch(Exception e){
			System.out.println("error");
			sc = new Scanner(System.in);
		}
		

		//record all of the data from the file into letterCount
		while(isDone == false){
			
			if (sc.hasNextLine() == true){
				//form the line
				String originalLine = sc.nextLine();
				originalLine = originalLine.toLowerCase();
				char[] letterArray = originalLine.toCharArray();				
				
				//record how many occurrences of each letter there are
				for(int i = 0; i < originalLine.length(); i++){
					letterCount[Arrays.binarySearch(lettersInABC, letterArray[i])]++;					
				}
				
			}
			else{
				isDone = true;
			}
		} 
		//System.out.println(letterCount);
		
		//now set what original letters equal what final letters.
		int[] letterCountInOrder = letterCount;
		Arrays.sort(letterCountInOrder);
		
		for (int k = letterCountInOrder.length; k > -1; k--){
				lineLettersInAscending[k] = lettersInABC[Arrays.binarySearch
				              (letterCount, letterCountInOrder[x])];
				x--;
		}
		
		
		//print out line by line
		isDone = false;
		while(isDone == false){
			
			if (sc.hasNextLine() == true){
				//form the line
				String originalLine = sc.nextLine();
				originalLine.toLowerCase();
				char[] letterArray = originalLine.toCharArray();				
				
				//record how many occurrences of each letter there are
				for(int i = 0; i < originalLine.length(); i++){
					
					letterArray[i] = lettersInAscending[Arrays.binarySearch
					            (lineLettersInAscending, letterArray[i])];

				}
				System.out.println(letterArray);
			}
			else{
				isDone = true;
			}
		


		}

	}

}
