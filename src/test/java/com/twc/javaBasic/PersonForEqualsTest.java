package com.twc.javaBasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonForEqualsTest {

    @Test
    public void test1Constructor() {
        assertThrows(IllegalArgumentException.class, () -> new PersonForEquals(null, (short) 2000));
    }

    @Test
    public void test2Constructor() {
        assertThrows(IllegalArgumentException.class, () -> new PersonForEquals("Name", (short) 1899));
        assertThrows(IllegalArgumentException.class, () -> new PersonForEquals("Name", (short) 2020));
    }

    @Test
    public void test1Equals() {
        PersonForEquals person = new PersonForEquals("Name", (short) 2005);
        assertTrue(person.equals(person));
    }

    @Test
    public void test2Equals() {
        PersonForEquals person = new PersonForEquals("Name", (short) 2005);
        assertFalse(person.equals(null));
    }

    @Test
    public void test3Equals() {
        PersonForEquals person = new PersonForEquals("Name", (short) 2005);
        assertFalse(person.equals("String"));
    }

    @Test
    public void test4Equals() {
        PersonForEquals person1 = new PersonForEquals("Name", (short) 2005);
        PersonForEquals person2 = new PersonForEquals("Name", (short) 2005);
        PersonForEquals person3 = new PersonForEquals("Name", (short) 2006);
        PersonForEquals person4 = new PersonForEquals("Name1", (short) 2005);
        assertTrue(person1.equals(person2));
        assertTrue(person2.equals(person1));
        assertFalse(person1.equals(person3));
        assertFalse(person1.equals(person4));
    }

    @Test
    public void testHashCode() {
        PersonForEquals person1 = new PersonForEquals("Name", (short) 2005);
        PersonForEquals person2 = new PersonForEquals("Name", (short) 2005);
        PersonForEquals person3 = new PersonForEquals("Name", (short) 2006);
        PersonForEquals person4 = new PersonForEquals("Name1", (short) 2005);
        assertEquals(person1.hashCode(), person2.hashCode());
        assertNotEquals(person1.hashCode(), person3.hashCode());
        assertNotEquals(person1.hashCode(), person4.hashCode());
    }
}
