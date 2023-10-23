package org.hbrs.se1.ws23.uebung2.test;
import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ContainerTest {

    Container container = new Container();
    ConcreteMember memberOne = new ConcreteMember(1);
    ConcreteMember memberTwo = new ConcreteMember(2);

    @BeforeEach
    void beforeTests() throws ContainerException {
        container.addMember(memberTwo);
    }

    @Test
    void testSize() {
        assertEquals(1, container.size());
    }

    @Test
    void positiveTestAdding() throws ContainerException {
        assertDoesNotThrow(() -> container.addMember(memberOne));
    }

    @Test
    void secondTestSize() throws ContainerException {
        container.addMember(memberOne);
        assertEquals(2, container.size());
    }

    @Test
    void positiveTestRemove() throws ContainerException {
        container.addMember(memberOne);
        String removedId = container.deleteMember(1);
        assertEquals("1", removedId);
    }

    @Test
    void thirdTestSize() {
        assertNotEquals(0, container.size());
    }

    @Test
    void negativeTestAdding() throws ContainerException {
        assertThrows(ContainerException.class, () -> container.addMember(memberTwo));
    }

    @Test
    void secondPositiveTestRemove() {
        String removedId = container.deleteMember(2);
        assertEquals("2", removedId);
    }

    @Test
    void negativeTestRemove() {
        String removedMessage = container.deleteMember(1);
        assertEquals(removedMessage, "Member-Objekt mit dieser ID nicht in der Liste");
    }

    @Test
    void testIsInList() {
        assertEquals(true, container.isInList(2));
    }

    @Test
    void secondTestIsInList() {
        assertEquals(false, container.isInList(1));
    }







}
