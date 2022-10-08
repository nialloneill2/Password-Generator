import java.util.Objects;
import java.util.Scanner;

public class Generator {
	Alphabet alphabet;
    public static Scanner keyboard;
    public Generator(Scanner sc) {
    	keyboard = sc;
    }
    
    public Generator(boolean includeUpper, boolean includeLower, boolean includeNum, boolean includeSym) {
    	alphabet = new Alphabet(includeUpper, includeLower, includeNum, includeSym);
    }
    public void myLoop() {
    	System.out.println("Welcome to my password generator");
    	printMenu();
    	
    	String option = "-1";
    	
    	while(!option.equals("4")) {
    		option = keyboard.next();
    		
    		switch (option) {
    		case "1" -> {
    			requestPassword();
    			printMenu();
    		}
    		case "2" -> {
    			checkPassword();
    			printMenu();
    		}
    		case "3" -> {
    			printInfo();
    			printMenu();
    		}
    		case "4" -> printExitMessage();
    		default -> {
    			System.out.println();
    			System.out.println("Select one of the options");
    			printMenu();
    		  }
    		}
    	}
    }
    private void printMenu() {
    	System.out.println();
    	System.out.println("1 - Password Generator");
    	System.out.println("2 - Password Strength Checker");
    	System.out.println("3 - Information");
    	System.out.println("4 - Exit");
    	System.out.print("Choice:");
    }
    private void requestPassword() {
    	boolean includeUpper = false;
    	boolean includeLower = false;
    	boolean includeNumber = false;
    	boolean includeSymbol = false;
    	
    	boolean correctParameters = false;
    	
    	System.out.println();
    	System.out.println("Welcome to the password generator, enter Yes or No to the following questions \n");
    	
    	do {
    		System.out.println("Do you want lowercase letters to be used?");
    		String input = keyboard.nextLine();    		
    		if(isInclude(input)) includeLower = true;
    		
    		System.out.println("Do you want uppercase letters to be used?");
    		input = keyboard.nextLine();
    		if(isInclude(input)) includeUpper = true;
    		
    		System.out.println("Do you want numbers to be used?");
    		input = keyboard.nextLine();
    		if(isInclude(input)) includeNumber = true;
    		
    		System.out.println("Do you want symbols to be used?");
    		input = keyboard.nextLine();
    		if(isInclude(input)) includeSymbol = true;
    		
    		if (!includeUpper && !includeLower && !includeNumber && !includeSymbol) {
    			System.out.println("You have not selected any characters for your password.");
    			correctParameters = true;
    		}
    		
    		System.out.println("Enter the length of your password");
    		int length = keyboard.nextInt();
    		
    		final Generator generator = new Generator(includeUpper, includeLower, includeNumber, includeSymbol);
    		final password pass = generator.generatePassword(length);
    		
    		System.out.println("Your password is " + pass);
    		
    	} while (correctParameters);
    }
    private void checkPassword() {
    	String inp;
    	final Scanner input = new Scanner(System.in);
    	System.out.print("\nEnter your password:");
    	inp = input.nextLine();
    	
    	final password p = new password(inp);
    	
    	System.out.println(p.calculateStrengthScore());
    	
    	input.close();
    }
    private password generatePassword(int length) {
    	final StringBuilder pw = new StringBuilder("");
    	
    	final int alphabetLength = alphabet.getAlphabet().length();
    	
    	int max = alphabetLength - 1;
    	int min = 0;
    	int range = max - min + 1;
    	
    	for (int i = 0; i < length; i++) {
    		int index = (int) (Math.random() * range) + min;
    		pw.append(alphabet.getAlphabet().charAt(index));
    	}
    	return new password(pw.toString());
    }
    private boolean isInclude(String input) {
    	if (input.equalsIgnoreCase("yes")) {
    		return true;
    	}
    	else {
    		if (!input.equalsIgnoreCase("no")) {
    			passwordRequestError();
    		}
    		return false;
    	}
    }
    private void passwordRequestError() {
    	System.out.println("You have entered incorrect information");
    }
    private void printInfo() {
    	System.out.println();
    	System.out.println("Use a password of minimum length 8 characters");
    	System.out.println("Include a variety of different symbols, numbers and upper/lowercase letters");
    	System.out.println("Don't use the same password that you may have used elsewhere");
    	System.out.println("Include at least one special character");
    	
    }
    private void printExitMessage() {
    	System.out.println("Goodbye.");
    }
}
