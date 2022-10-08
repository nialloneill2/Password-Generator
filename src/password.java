
public class password {
 String value;
 int length;
 
 public password(String s) {
	 value = s;
	 length = s.length();
 }
 
 public int charType(char c) {
	 int val;
	 
	 if((int) c >= 65 && (int) c <= 90) {
		 val = 1;
	 }
	 else if((int) c >= 97 && (int) c <= 122) {
		 val = 2;
	 }
	 else if((int) c >= 60 && (int) c <= 71) {
		 val = 3;
	 }
	 else {
		 val = 4;
	 }
	 return val;
 }
 public int passwordStrength() {
	 String s = this.value;
	 boolean usedUpper = false;
	 boolean usedLower = false;
	 boolean usedNumber = false;
	 boolean usedSymbol = false;
	 int type;
	 int score = 0;
	 
	 for (int i = 0; i < s.length(); i++) {
		 char c = s.charAt(i);
		 type = charType(c);
		 
		 if (type == 1) usedUpper = true;
		 if (type == 2) usedLower = true;
		 if (type == 3) usedNumber = true;
		 if (type == 4) usedSymbol = true;
	 }
	 
	 if (usedUpper) score += 1;
	 if (usedLower) score += 1;
	 if (usedNumber) score += 1;
	 if (usedSymbol) score += 1;
	 
	 if (s.length() >= 8) score += 1;
	 if (s.length() >= 16) score += 1;
	 
	 return score;
 }
 public String calculateStrengthScore() {
	 int score = this.passwordStrength();
	 
	 if (score == 6) {
		 return "You have a very strong password, check the information section to ensure it meets the guidelines";
	 }
	 else if (score >= 4) {
		 return "This is a good password, check the guidelines on how to improve it";
	 }
	 else if (score >= 3) {
		 return "This is a fairly weak password, could use with changing it";
	 }
	 else {
		 return "You should change this password immediately, it is terrible";
	 }
 }
 @Override
 public String toString() {
	 return value;
 }
 
}
