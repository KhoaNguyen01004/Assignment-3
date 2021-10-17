//package _solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_STUDENT_Test {
    BasicDoubleLinkedList<String> linkedString;
    BasicDoubleLinkedList<Double> linkedDouble;
    BasicDoubleLinkedList<Student> studentLinkedList;
    StringComparator comparator;
    DoubleComparator comparatorD;
    StudentComparator studentComparator;

    public Student a = new Student("Kevin", "123", 90);
    public Student b = new Student("Tom", "312", 80);
    public Student c = new Student("Ted", "345", 70);
    public Student d = new Student("Subaru", "578", 60);
    public Student e = new Student("Jerry", "430", 50);
    public Student f = new Student("Thomas", "576", 40);

    @Before
    public void setUp() {
        linkedString = new BasicDoubleLinkedList<>();
        linkedString.addToEnd("Hello");
        linkedString.addToEnd("World");
        comparator = new StringComparator();

        linkedDouble = new BasicDoubleLinkedList<>();
        linkedDouble.addToEnd(15.0);
        linkedDouble.addToEnd(100.0);
        comparatorD = new DoubleComparator();

        studentLinkedList = new BasicDoubleLinkedList<>();
        studentLinkedList.addToEnd(b);
        studentLinkedList.addToEnd(c);
        studentComparator = new StudentComparator();
    }

    @After
    public void tearDown() {
        linkedString = null;
        linkedDouble = null;
        studentLinkedList = null;
        comparatorD = null;
        comparator = null;
    }

    @Test
    public void testGetSize() {
        assertEquals(2, linkedString.getSize());
        assertEquals(2, linkedDouble.getSize());
        assertEquals(2, studentLinkedList.getSize());
    }

    @Test
    public void testAddToEnd() {
        assertEquals("World", linkedString.getLast());
        linkedString.addToEnd("End");
        assertEquals("End", linkedString.getLast());

        assertEquals(c, studentLinkedList.getLast());
        studentLinkedList.addToEnd(d);
        assertEquals(d, studentLinkedList.getLast());
    }

    @Test
    public void testAddToFront() {
        assertEquals("Hello", linkedString.getFirst());
        linkedString.addToFront("Begin");
        assertEquals("Begin", linkedString.getFirst());

        assertEquals(b, studentLinkedList.getFirst());
        studentLinkedList.addToFront(a);
        assertEquals(a, studentLinkedList.getFirst());
    }

    @Test
    public void testGetFirst() {
        assertEquals("Hello", linkedString.getFirst());
        linkedString.addToFront("New");
        assertEquals("New", linkedString.getFirst());

        assertEquals(b, studentLinkedList.getFirst());
        studentLinkedList.addToFront(a);
        assertEquals(a, studentLinkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals("World", linkedString.getLast());
        linkedString.addToEnd("New");
        assertEquals("New", linkedString.getLast());

        assertEquals(c, studentLinkedList.getLast());
        studentLinkedList.addToEnd(d);
        assertEquals(d, studentLinkedList.getLast());
    }

    @Test
    public void testToArrayList() {
        ArrayList<Student> list;
        studentLinkedList.addToFront(a);
        studentLinkedList.addToEnd(d);
        list = studentLinkedList.toArrayList();
        assertEquals(a, list.get(0));
        assertEquals(b, list.get(1));
        assertEquals(c, list.get(2));
        assertEquals(d, list.get(3));
    }

    @Test
    public void testIteratorSuccessfulNext() {
        linkedString.addToFront("Begin");
        linkedString.addToEnd("End");
        ListIterator<String> iterator = linkedString.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("Begin", iterator.next());
        assertEquals("Hello", iterator.next());
        assertEquals("World", iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals("End", iterator.next());

        studentLinkedList.addToFront(a);
        studentLinkedList.addToEnd(d);
        ListIterator<Student> iteratorCar = studentLinkedList.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(d, iteratorCar.next());
    }

    @Test
    public void testIteratorSuccessfulPrevious() {
        studentLinkedList.addToFront(a);
        studentLinkedList.addToEnd(d);
        ListIterator<Student> iteratorCar = studentLinkedList.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(d, iteratorCar.next());
        assertEquals(true, iteratorCar.hasPrevious());
        assertEquals(d, iteratorCar.previous());
        assertEquals(c, iteratorCar.previous());
        assertEquals(b, iteratorCar.previous());
        assertEquals(a, iteratorCar.previous());
    }

    @Test
    public void testIteratorNoSuchElementExceptionNext() {
        studentLinkedList.addToFront(a);
        studentLinkedList.addToEnd(d);
        ListIterator<Student> iteratorCar = studentLinkedList.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(d, iteratorCar.next());

        try {
            // no more elements in list
            iteratorCar.next();
            assertTrue("Did not throw a NoSuchElementException", false);
        } catch (NoSuchElementException err) {
            assertTrue("Successfully threw a NoSuchElementException", true);
        } catch (Exception err) {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }

    }

    @Test
    public void testIteratorNoSuchElementExceptionPrevious() {
        studentLinkedList.addToFront(a);
        studentLinkedList.addToEnd(d);
        ListIterator<Student> iteratorCar = studentLinkedList.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(d, iteratorCar.next());
        assertEquals(true, iteratorCar.hasPrevious());
        assertEquals(d, iteratorCar.previous());
        assertEquals(c, iteratorCar.previous());
        assertEquals(b, iteratorCar.previous());
        assertEquals(a, iteratorCar.previous());

        try {
            // no more elements in list
            iteratorCar.previous();
            assertTrue("Did not throw a NoSuchElementException", false);
        } catch (NoSuchElementException err) {
            assertTrue("Successfully threw a NoSuchElementException", true);
        } catch (Exception err) {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }

    }

    @Test
    public void testIteratorUnsupportedOperationException() {
        studentLinkedList.addToFront(a);
        studentLinkedList.addToEnd(d);
        ListIterator<Student> studentIterator = studentLinkedList.iterator();
        assertEquals(true, studentIterator.hasNext());
        assertEquals(a, studentIterator.next());
        assertEquals(b, studentIterator.next());
        assertEquals(c, studentIterator.next());
        assertEquals(true, studentIterator.hasNext());
        assertEquals(d, studentIterator.next());

        try {
            // remove is not supported for the iterator
            studentIterator.remove();
            assertTrue("Did not throw a UnsupportedOperationException", false);
        } catch (UnsupportedOperationException err) {
            assertTrue("Successfully threw a UnsupportedOperationException", true);
        } catch (Exception err) {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }

    }

    @Test
    public void testRemove() {
        // remove the first
        assertEquals(b, studentLinkedList.getFirst());
        assertEquals(c, studentLinkedList.getLast());
        studentLinkedList.addToFront(a);
        assertEquals(a, studentLinkedList.getFirst());
        studentLinkedList.remove(a, studentComparator);
        assertEquals(b, studentLinkedList.getFirst());
        // remove from the end of the list
        studentLinkedList.addToEnd(d);
        assertEquals(d, studentLinkedList.getLast());
        studentLinkedList.remove(d, studentComparator);
        assertEquals(c, studentLinkedList.getLast());
        // remove from middle of list
        studentLinkedList.addToFront(a);
        assertEquals(a, studentLinkedList.getFirst());
        assertEquals(c, studentLinkedList.getLast());
        studentLinkedList.remove(b, studentComparator);
        assertEquals(a, studentLinkedList.getFirst());
        assertEquals(c, studentLinkedList.getLast());

    }

    @Test
    public void testRetrieveFirstElement() {
        assertEquals(b, studentLinkedList.getFirst());
        studentLinkedList.addToFront(a);
        assertEquals(a, studentLinkedList.getFirst());
        assertEquals(a, studentLinkedList.retrieveFirstElement());
        assertEquals(b, studentLinkedList.getFirst());
        assertEquals(b, studentLinkedList.retrieveFirstElement());
        assertEquals(c, studentLinkedList.getFirst());

        assertEquals("Hello", linkedString.getFirst());
        linkedString.addToFront("New");
        assertEquals("New", linkedString.getFirst());
        assertEquals("New", linkedString.retrieveFirstElement());
        assertEquals("Hello", linkedString.getFirst());
        assertEquals("Hello", linkedString.retrieveFirstElement());
        assertEquals("World", linkedString.getFirst());

    }

    @Test
    public void testRetrieveLastElement() {
        assertEquals(c, studentLinkedList.getLast());
        studentLinkedList.addToEnd(d);
        assertEquals(d, studentLinkedList.getLast());
        assertEquals(d, studentLinkedList.retrieveLastElement());
        assertEquals(c, studentLinkedList.getLast());

        assertEquals("World", linkedString.getLast());
        linkedString.addToEnd("New");
        assertEquals("New", linkedString.getLast());
        assertEquals("New", linkedString.retrieveLastElement());
        assertEquals("World", linkedString.getLast());
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