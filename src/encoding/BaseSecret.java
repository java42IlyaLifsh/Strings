package encoding;
//HW_21 
public class BaseSecret {
	private String secret;
public void setSecret(String secret) {
		this.secret = secret;
		
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
public String toSecretString(int num) {
	//TODO
	return "";
}
public boolean matches(String code, String decString) {
	//TODO
	return false;
}


}
