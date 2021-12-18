package encoding;

import java.util.HashSet;

//HW_21 IlyaL
public class BaseSecret {
	private String secret;

public BaseSecret() {
	secret = "0123456789"; //if secret noncorrect make decimal default constructor
	
}
	
public int setSecret(String secret) {
	int validCode = secretValidationCode(secret);
	if (validCode==0) this.secret = secret; //validCode<0 if in string secret was noncorrect
	
	return validCode;	
	}

public static String toBinaryString(int num) {
	StringBuilder builder = new StringBuilder();
	do {
		int rem = num % 2;
		builder.insert(0, rem);
		num = num / 2;
		
	}while(num != 0);
	return builder.toString();
}
public static String toDecimalString(int num) {
	StringBuilder builder = new StringBuilder();
	do {
		int rem = num % 10;
		builder.insert(0, rem);
		num = num / 10;
		
	}while(num != 0);
	return builder.toString();
}

public static String toBaseString(int num, int base) {
	StringBuilder builder = new StringBuilder();

	do {
		int rem = num % base;
		builder.insert(0, rem);
		num = num / base;
		
	}while(num != 0);
	return builder.toString();
}

public static int parseIntBase(String baseString, int base) {
	int res = 0;
	int length = baseString.length();
	for (int i = 0; i < length; i++) {
		res = res * base + (baseString.charAt(i) - '0');
//		res = res+(int)Math.pow(base, lenght-i-1)*(baseStr.charAt(i)-'0');
	}
	return res;
}

public static int parseIntBinary(String binaryStr) {
	int res = 0;
	int length = binaryStr.length();
	for (int i = 0; i < length; i++) {
		res = res * 2 + (binaryStr.charAt(i) - '0');
	}
	return res;
}
public static int parseIntDecimal(String decString) {
	int res = 0;
	int length = decString.length();
	for (int i = 0; i < length; i++) {
		res = res * 10 + (decString.charAt(i) - '0');
	}
	return res;
}

private int secretValidationCode (String secret) {
	if (secret.length()<=1) return -1000; // string secret too short
	
	HashSet<Character> set = new HashSet<Character>();
	for (Character ch: secret.toCharArray()) {
		set.add(ch);
	}
	return set.size() - secret.length(); //"-" if was non uniquess symbols in secret string
	
	
}

public String toSecretString(int num) {
	String baseString = toBaseString(num, secret.length());
	char[] charArray = baseString.toCharArray();
	StringBuilder builder = new StringBuilder();
	for (char ch: charArray) builder.append(secret.charAt(ch-'0'));
		
	return builder.toString();
}
public boolean matches(String code, String decString) {
	
	return code.equals(toSecretString(parseIntBase(decString, secret.length())));
}

 
}
