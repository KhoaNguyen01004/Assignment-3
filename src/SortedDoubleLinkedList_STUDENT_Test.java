
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Student> sortedLinkedStudent;
	StringComparator comparator;
	DoubleComparator comparatorD;
	StudentComparator comparatorStudent;

	public final Student a = new Student("Kevin", "123", 90);
	public final Student b = new Student("Tom", "312", 80);
	public final Student c = new Student("Ted", "345", 70);
	public final Student d = new Student("Subaru", "578", 60);
	public final Student e = new Student("Jerry", "430", 50);
	public final Student f = new Student("Thomas", "576", 40);
	// alphabetic order: e f a c b d

	@Before
	public void setUp() {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<>(comparator);

		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<>(comparatorD);

		comparatorStudent = new StudentComparator();
		sortedLinkedStudent = new SortedDoubleLinkedList<>(comparatorStudent);

	}

	@After
	public void tearDown() {
		comparator = null;
		comparatorD = null;
		comparatorStudent = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedStudent = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		} catch (UnsupportedOperationException err) {
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		} catch (Exception err) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		} catch (UnsupportedOperationException err) {
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		} catch (Exception err) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedStudent.add(a);
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(c);
		sortedLinkedStudent.add(d);
		ListIterator<Student> iterator = sortedLinkedStudent.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}

	@Test
	public void testIteratorSuccessfulStudentPrevious() {
		sortedLinkedStudent.add(e);
		sortedLinkedStudent.add(c);
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(d);

		ListIterator<Student> iterator = sortedLinkedStudent.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(b, iterator.previous());
		assertEquals(c, iterator.previous());
		assertEquals(d, iterator.previous());
	}

	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(6));
		sortedLinkedDouble.add(new Double(1));
		sortedLinkedDouble.add(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(1), iterator.next());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(6), iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(10));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasPrevious());

		assertEquals(new Double(8), iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}

	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedStudent.add(e);
		sortedLinkedStudent.add(c);
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(d);
		ListIterator<Student> iterator = sortedLinkedStudent.iterator();

		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		try {
			// no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException", false);
		} catch (NoSuchElementException err) {
			assertTrue("Successfully threw a NoSuchElementException", true);
		} catch (Exception err) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}

	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedStudent.add(e);
		sortedLinkedStudent.add(c);
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(d);
		ListIterator<Student> iterator = sortedLinkedStudent.iterator();

		try {
			// remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException", false);
		} catch (UnsupportedOperationException err) {
			assertTrue("Successfully threw a UnsupportedOperationException", true);
		} catch (Exception err) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddStudent() {
		// alphabetic order: e f a c b d
		sortedLinkedStudent.add(a);
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(c);
		assertEquals(a, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		sortedLinkedStudent.add(d);
		sortedLinkedStudent.add(e);
		assertEquals(e, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		// deletes Elephant from linked list
		assertEquals(b, sortedLinkedStudent.retrieveLastElement());
		assertEquals(c, sortedLinkedStudent.getLast());
	}

	@Test
	public void testRemoveFirstStudent() {
		// alphabetic order: e f a c b d
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(c);
		assertEquals(c, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		sortedLinkedStudent.add(a);
		assertEquals(a, sortedLinkedStudent.getFirst());
		// remove the first
		sortedLinkedStudent.remove(a, comparatorStudent);
		assertEquals(c, sortedLinkedStudent.getFirst());
	}

	@Test
	public void testRemoveEndStudent() {
		// alphabetic order: e f a c b d
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(f);
		assertEquals(f, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		sortedLinkedStudent.add(d);
		assertEquals(b, sortedLinkedStudent.getLast());
		// remove from the end of the list
		sortedLinkedStudent.remove(d, comparatorStudent);
		assertEquals(b, sortedLinkedStudent.getLast());
	}

	@Test
	public void testRemoveMiddleStudent() {
		// alphabetic order: e f a c b d
		sortedLinkedStudent.add(a);
		sortedLinkedStudent.add(b);
		assertEquals(a, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		sortedLinkedStudent.add(f);
		assertEquals(a, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		assertEquals(3, sortedLinkedStudent.getSize());
		// remove from middle of list
		sortedLinkedStudent.remove(a, comparatorStudent);
		assertEquals(f, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		assertEquals(2, sortedLinkedStudent.getSize());
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}

	}

	private class DoubleComparator implements Comparator<Double> {

		@Override
		public int compare(Double arg0, Double arg1) {
			return arg0.compareTo(arg1);
		}

	}

	private class StudentComparator implements Comparator<Student> {

		@Override
        public int compare(Student o1, Student o2) {
            return o1.toString().compareTo(o2.toString());
        }
	}

	private class Student {
        String name;
        String studentID;
        int grade;

        public Student(String name, String id, int grade) {
            this.name = name;
            this.studentID = id;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public String getStudentID() {
            return studentID;
        }

        public int getGrade() {
            return grade;
        }

        public String toString() {
            return (getName() + " " + getStudentID() + " " + getGrade());
        }
	}
}