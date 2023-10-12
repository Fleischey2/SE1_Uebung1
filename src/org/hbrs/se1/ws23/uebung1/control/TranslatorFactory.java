package org.hbrs.se1.ws23.uebung1.control;



public class TranslatorFactory {

    public static Translator buildTranslator(String type) {

        if(type.equalsIgnoreCase("germanTranslator")) {
            return new GermanTranslator();
        } else {
            return null;
        }

    }

}
