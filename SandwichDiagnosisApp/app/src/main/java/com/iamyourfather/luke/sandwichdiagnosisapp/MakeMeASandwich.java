package com.iamyourfather.luke.sandwichdiagnosisapp;
import android.view.Menu;

import java.io.File;
import java.util.Scanner;
/*
 * This program diagnoses your sandwich cravings and provides you with a recipe
 * for the desired sandwich. The main method contains the sandwich quiz and 
 * input handling. 
 * 
 * @author Kyle Ferris, Rose Walton
 */
public class MakeMeASandwich {
	
	//used to handle quiz input
	private static Scanner elvis;

	public static void main(String[] args) {
		elvis = new Scanner(System.in);
		
		//welcome message
		System.out.print("~~~~~ Welcome to Make Me a Sandwich!!! ~~~~~"
				+ "\n\nInitiating Sandwich Craving Diagnosis... ");
		
		//reads in sandwich data from a file, creates sandwich objects, and
		//places them in an arraylist
		Menu menu = new Menu (new File("sandwiches.txt"));
		
		//starts the quiz
		initiateQuiz(menu);
				
	}
	/*
	 * Checks to make sure input is as specified and returns the received input.
	 * 
	 * @param min -minimum possible input number
	 * @param max -maximum possible input number
	 * @return String validated input value
	 */
	public static String validateInput (int min, int max) {
		
		//keeps loop running until proper input is received
		boolean inputNeeded = true;
		
		while (inputNeeded) {
			if (elvis.hasNext()) {
				String input = elvis.next();
				//checks to see if input is as desired
				if (input.equals("1") || input.equals("2"))
					return input;
				else if (max == 3 && input.equals("3"))
					return input;
			}
			elvis.nextLine();
			//input error message
			System.out.print("\n\nPlease enter an valid "
					+ "number choice (" + min + "-" + max + "): ");
		}
		
		return "error";
	}
	
	/*
	 * Contains the bulk of program functionality. Prints out the quiz questions
	 * , gets the input, gets the sandwich that best matches the input, and 
	 * prints out the sandwich diagnosis.
	 * 
	 * @param Menu menu -menu containing the sandwiches
	 */
	public static void initiateQuiz (Menu menu) {
		
		//input minimum number
		int min = 1;
		//input maximum number
		int max = 3;
		//input maximum number for yes/no and true/false questions
		int yesNoMax = 2;
		
		//passes all questions to presentQuestion and receives the responses
		String q1 = "On a scale of 1-3, how carnivorous are you feeling?"
				+ "(1 being a cow, 2 being bear, and 3 being a puma)";
		String ans1 = presentQuestion (q1, min, max);
		
		String q2 = "Are you pregnant or at risk for heart complications? (1=no"
				+ " 2=yes)";
		String ans2 = presentQuestion (q2, min, yesNoMax);
		
		String q2b = "Would you like your sandwich to be healthy? (1=no 2=yes)";
		if (presentQuestion (q2b, min, yesNoMax).equals("2"))
			ans2 = "2";
		
		String q3 = "On a scale of 1-3, how spicy would you like your sandwich?"
				+ " (1 being the least and 3 being the most)";
		String ans3 = presentQuestion (q3, min, max);
		
		String funQ1 = "Sometimes I am so immersed in nature or art that I feel"
				+ " as if my whole state of consciousness has somehow been "
				+ "temporarily changed. (1=True 2=False)";
		presentQuestion (funQ1, min, yesNoMax);
		
		String q4 = "On a scale of 1-3, how messy would you like your sandwich?"
				+ " (1 being the least and 3 being the most)";
		String ans4 = presentQuestion (q4, min, max);
		
		String funQ2 = "At times I somehow feel the presence of someone who is"
				+ " not physically there (1=True 2=False)";
		presentQuestion (funQ2, min, yesNoMax);
		
		String q5 = "On a scale of 1-3, how cheesy are you feeling? (1 being "
				+ "the least and 3 being the most)";
		String ans5 = presentQuestion (q5,min, max);
		
		String q6 = "Of these two situations I would prefer: \n(1) Being "
				+ "seasick every day for a week while on an ocean voyage"
				+ "\n(2) Having to stand on the window ledge of the 25th Floor "
				+ "of a hotel because there's a fire in my room";
		String ans6 = presentQuestion (q6, min, yesNoMax);
		
		String q6b = "Of these two situations I would prefer: \n(1) Bringing "
				+ "my whole family to the circus and then not being able to "
				+ "get in because a clerk sold me tickets for the wrong night."
				+ "\n(2) Being at the circus when two lions suddenly get loose "
				+ "down in the ring";
		String ans6b = presentQuestion (q6b, min, yesNoMax);
		String ans6c = "";
		
		//combines scores of 2 adventurous scales into a 1-3 rating
		if (ans6.equals("1") && ans6b.equals("1"))
			ans6c = "1";
		else if ((ans6.equals("1") || ans6b.equals("1")))
			ans6c = "2";
		else
			ans6c = "3";
		
		String q7 = "Are you feeling fruity? (1=no 2=yes)";
		String ans7 = presentQuestion (q7, min, yesNoMax);
		boolean fruity = true;
		
		String sandwichId = ans1 + ans3 + ans4 + ans2 + ans5 + ans6c;
		
		//non-fruity sandwich choice
		if (ans7.equals("1")) {
			fruity = false;
			//sandwich match not strong enough
			if (menu.getSandwich(sandwichId) == null)
				System.out.print("\n\nYou are not feeling the sandwich vibes"
						+ " today. Sorry, try again later.");
			else
				//sandwich diagnosis printed out
				System.out.print("\n\nYou are feeling the sandwich vibes of"
						+ " a " + menu.getSandwich(sandwichId) + ".");
		}
		//fruity sandwich choice
		else {
			//sandwich mactch not strong enough
			if (menu.getSandwich(fruity, sandwichId) == null)
				System.out.print("\n\nYou are not feeling the sandwich vibes"
						+ " today. Sorry, try again later.");
			else
				System.out.print("\n\nYou are feeling the sandwich vibes of a " 
						+ menu.getSandwich(fruity, sandwichId));
		}
		
		
	}
	
	/*
	 * Presents a question and returns a properly validated input response to
	 * the question.
	 * 
	 * @param String question -question to be printed out
	 * @param int min -min number response
	 * @param int max -max number response
	 */
	public static String presentQuestion (String question, int min, int max) {
		System.out.print("\n\n" + question + ": ");
		return validateInput(min, max);
	}
}
