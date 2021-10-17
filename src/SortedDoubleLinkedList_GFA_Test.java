
import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_GFA_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator = new StringComparator();

	@Before
	public void setUp() {
		sortedLinkedString = new SortedDoubleLinkedList<>(comparator);
	}

	@After
	public void tearDown() {
		sortedLinkedString = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
		} catch (UnsupportedOperationException e) {
			assertEquals(e.getMessage(), "Invalid operation for sorted list");
		}
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
	}

}