
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_GFA_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;

	@Before
	public void setUp() {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
	}

	@After
	public void tearDown() {
		linkedString = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(1, linkedString.getSize());
	}
}