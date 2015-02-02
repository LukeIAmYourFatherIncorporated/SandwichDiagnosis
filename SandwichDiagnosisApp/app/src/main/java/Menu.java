import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/* 
 * Menu object that reads in sandwich data from a file and places the 
 * information into a list.
 * 
 * @author Kyle Ferris, Rose Walton
 */
public class Menu {
	//stores all the sandwich objects
	private static ArrayList<Sandwich> sandwiches;
	
	/*
	 * Reads in sandwich data from a file of the format
	 * Sandwich ID#
	 * Sandwich Name
	 * Sandwich Recipe URL
	 */
	public Menu (File file) {
		sandwiches = new ArrayList<Sandwich>();
		try {
			Scanner fileIn = new Scanner(file);
			boolean moreSandwiches = true;
			
			while (moreSandwiches) {
				String id = fileIn.nextLine();
				String name = fileIn.nextLine();
				String uRL = fileIn.nextLine();
				Sandwich sandwich = new Sandwich(id, name, uRL);
				sandwiches.add(sandwich);
				if (!fileIn.hasNextInt())
					moreSandwiches = false;
			}
		} catch (FileNotFoundException e) {
			System.out.print(e);
		}
	}
	/*
	 * Compares quiz result to sandwich database to get closest match.
	 */
	public Sandwich getSandwich(String id) {
		int maxMatchCount = 0;
		int sandwichIndex = -1;
		
		for (int i = 0; i < sandwiches.size(); i ++) {
			
			String tempId = sandwiches.get(i).getId(); 
			int matchCount = 0;
			if(id.charAt(0) == tempId.charAt(0)) {
				for (int j = 1; j < id.length(); j ++) {
					if (id.charAt(j) == tempId.charAt(j))
						matchCount ++;
				}
				if (matchCount > maxMatchCount) {
					maxMatchCount = matchCount;
					if (maxMatchCount >= 3)
						sandwichIndex = i;
				}
			}
				
		}
		if (sandwichIndex == -1)
			return null;
		
		return sandwiches.get(sandwichIndex);
	}
	
	/*
	 * Compares quiz result to sandwich database to get closest match for 
	 * fruity sandwiches.
	 */
	public Sandwich getSandwich(boolean fruity, String id) {
		ArrayList<Sandwich> fruitySandwiches = new ArrayList<Sandwich>();
		fruitySandwiches.add(sandwiches.get(5));
		fruitySandwiches.add(sandwiches.get(6));
		fruitySandwiches.add(sandwiches.get(7));
		fruitySandwiches.add(sandwiches.get(9));
		fruitySandwiches.add(sandwiches.get(11));
		
		int maxMatchCount = 0;
		int sandwichIndex = -1;
		
		for (int i = 0; i < fruitySandwiches.size(); i ++) {
			
			String tempId = fruitySandwiches.get(i).getId(); 
			int matchCount = 0;
			
			if(id.charAt(0) == tempId.charAt(0)) {
				for (int j = 1; j < id.length(); j ++) {
					if (id.charAt(j) == tempId.charAt(j))
						matchCount ++;
				}
				if (matchCount > maxMatchCount) {
					maxMatchCount = matchCount;
					sandwichIndex = i;
				}
			}
				
		}
		if (sandwichIndex == -1)
			return null;
		
		return fruitySandwiches.get(sandwichIndex);
	}
	
}
