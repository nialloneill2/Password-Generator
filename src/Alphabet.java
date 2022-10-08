
public class Alphabet {
 public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
 public static final String numbers = "1234567890";
 public static final String symbols = "!@#$%^&*()-_=+\\/~?";
 
 private final StringBuilder pool;
 
 public Alphabet(boolean upperIncluded, boolean lowerIncluded, boolean numbersIncluded, boolean symbolsIncluded) {
	 pool = new StringBuilder();
	 
	 if(upperIncluded) pool.append(UPPERCASE_LETTERS);
	 if (lowerIncluded) pool.append(LOWERCASE_LETTERS);
	 if (numbersIncluded) pool.append(numbers);
	 if (symbolsIncluded) pool.append(symbols);
 }
 
 public String getAlphabet() {
	 return pool.toString();
 }
}
