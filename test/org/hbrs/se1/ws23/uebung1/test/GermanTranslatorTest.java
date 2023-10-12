package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @Test
    void aPositiveTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(1);
        assertEquals(value, "eins");
    }

    @Test
    void aSecondPositiveTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(11);
        assertEquals(value, "Uebersetzung der Zahl 11 nicht moeglich [1.0]");
    }
    
    @Test
    void aNegativeTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(2);
        assertNotEquals(value, "eins");
    }

    @Test
    void aSecondNegativeTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(11);
        assertNotEquals(value, "elf");
    }
}