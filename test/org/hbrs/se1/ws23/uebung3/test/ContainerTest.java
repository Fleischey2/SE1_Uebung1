package org.hbrs.se1.ws23.uebung3.test;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung3.persistence.Container;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
    Container c = Container.getInstance();


    @Test
    void noStrategyFromOutside() {

        assertEquals(null, c.pss);

    }
    @Test
    void useStrategyMongoDB() {

        c.pss = new PersistenceStrategyMongoDB<>();
        assertThrows(UnsupportedOperationException.class, () -> c.load());
        assertThrows(UnsupportedOperationException.class, () -> c.store());

    }

    @Test
    void testLocationOfFiles() throws PersistenceException, ContainerException {

        PersistenceStrategyStream ps = new PersistenceStrategyStream<>();
        ps.setLocation("C:\\Users\\Niklas Gieshoff\\Documents\\test.txt");
        c.pss = ps;
        assertThrows(FileNotFoundException.class, () -> c.load());


    }

    @Test
    void roundTripTest() throws ContainerException, PersistenceException, IOException, ClassNotFoundException {
        c.pss = new PersistenceStrategyStream<>();
        c.addMember(new ConcreteMember(420));
        assertEquals(1, c.size());
        c.store();

        assertEquals("420", c.deleteMember(420));

        assertEquals(0, c.size());

        c.load();
        assertEquals(1, c.size());

    }

}
