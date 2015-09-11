package ba.bitcamp.lectures.testing.calc;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	Calculator calc = new Calculator();
	
	@Test
	public void testAdd() {
		Number r = calc.add(1, 2);
		assertEquals(3, r.intValue());
	}
	
	@Test
	public void testAddDouble() {
		Number r = calc.add(1.5, 2.3);
		assertEquals(3.8, r.doubleValue(), 0.00001);
	}
	
	@Test
	public void testAddNegative() {
		Number r = calc.add(1, -2);
		assertEquals(-1, r.intValue());
	}

	@Test
	public void testAddNaN() {
		Number r = calc.add(1, Double.NaN);
		assertEquals(Double.NaN, r);
	}
	
	@Test
	public void testAddNull() {
		assertEquals(Double.NaN, calc.add(1, null));
		assertEquals(Double.NaN, calc.add(null, 1));
		assertEquals(Double.NaN, calc.add(null, null));
	}
	
	@Test
	public void testOverflowl() {
		assertEquals(Double.NaN, calc.add(1, Integer.MAX_VALUE));
		assertEquals(Double.NaN, calc.add(-1, Integer.MIN_VALUE));
		assertEquals(Double.NaN, calc.add(-2, Integer.MIN_VALUE + 1));

		assertNotEquals(Double.NaN, calc.add(1, (double)Integer.MAX_VALUE));
	}
}
