package encoding;
//HW_21 IlyaL
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseSecretTest {
	BaseSecret bs = new BaseSecret();
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testToBinaryString() {
		assertEquals("100", BaseSecret.toBinaryString(4));
	}

	@Test
	void testToDecimalString() {
		assertEquals("1234", BaseSecret.toDecimalString(1234));
	}

	@Test
	void testParseIntBinary() {
		assertEquals(4, BaseSecret.parseIntBinary("100"));
	}

	@Test
	void testParseIntDecimal() {
		assertEquals(1234, BaseSecret.parseIntDecimal("1234"));
	}

	@Test
	void testToSecretString() {
		String secret = ".-";
		int validCode = bs.setSecret(secret);
		if (validCode<0) System.out.println("input string isnt valid. Make defailt decimal cinctructor, code="+validCode);
				
		assertEquals("-..", bs.toSecretString(4));
		
	}

	@Test
	void testMatches() {
		String secret = "()";
		int validCode =	bs.setSecret(secret);
		if (validCode<0) System.out.println("input string isnt valid. Make defailt decimal cinctructor, code="+validCode);
		
		assertTrue(bs.matches(")((", "4") );
	}

}
