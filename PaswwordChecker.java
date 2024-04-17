package application;

import java.util.Scanner;

public class PaswwordChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		Scanner scan = new Scanner (System.in);
		System.out.println("There are rules you must follow for determining the password strengthen : \n "
				          +"The password must contain :\n "
				          +"1- UpperCase and LowerCase Letters \n"
				          +" 2- Numbers \n"
				          +" 3- Specila Characters \n "
				          +"4- The Length of the password is at least 8 digits \n");  // the rules that the 
		                                                   // user must follow when entering the password 
		
		System.out.println("Enter password to check if it is Strong, Weak or medium: ");
		String password   = scan.nextLine();   
		
	
		String CheckPassword = passwordStrengthChecker(password);
		System.out.println("The password is " + CheckPassword); // printing the result 
		
	}
	
	// a method for calculating the variance 
	public static double calculateVariance(String  password) {
	    int n = password.length();   // the password length 
	       
	    double sum = 0;
	    for (int i = 0; i < n; i++) {   // to find the summation for the numbers 
	        sum += password.charAt(i); 
	        System.out.println(password.charAt(i));
	    }
	    System.out.println(sum);
	    
	    
	    double mean = sum / n;  // calculate the mean 

	    // Calculate variance
	    double variance = 0;
	    for (int i = 0; i < n; i++) {   // for loop for calculating the variance that is the value - mean 
	    	                                                  // to the power 2 
	        variance += Math.pow(password.charAt(i) - mean, 2);
	    }
	    variance /= n;     // deviding the varince to the length of the password 

	    return variance;
	}
	
	// a method for calculating the entropy 
	public static double calculateEntrophy(String password) {
		int charSize = 256;	  // the asci codes fro the Upper + lower letters + numbers + special character 
		int n = password.length();
		double combinations = Math.pow(charSize, n);  // calculat the total number of combinations 
		double entropy = Math.log(combinations)/Math.log(2); // the formula for finding the entropy
		return entropy;
	}
	
	public static String passwordStrengthChecker (String password ) {  // a method that checks if the password 
		int length = password.length();                             // is weak,strong,medium
		boolean upperCase =! password.equals(password.toUpperCase()); // to check if its containing at least one  upperCase
		boolean lowerCase = !password.equals(password.toLowerCase()); //to check if its containing at least one  lowerCase
		boolean numbers = password.matches(".*\\d.*"); // for digits 
		boolean specialCharacter =  password.matches(".*[^A-Za-z0-9]*"); // for special characters 
		
		double variance = calculateVariance(password);   // calling the methods for variance and entropy
		double entropy = calculateEntrophy(password);
		
		System.out.println("The Entropy is: " + entropy);
		System.out.println("The Variance is: " + variance);
		
		// if statements to do the checking 
		if (!upperCase || !lowerCase || !numbers || !specialCharacter || length <8 || ( entropy <50) || (variance <50))  {		
			return "Weak, invalid password; your password must have a varity of upper,lower letter,numbers,specilaChar....";		
		}
		else if (upperCase && lowerCase && numbers && specialCharacter && length>=8 && (entropy > 50 ) && (variance > 50 )) {
			return "Strong";
		}
		else {
			return "Medium";
		}
		
		
	
	}
}
