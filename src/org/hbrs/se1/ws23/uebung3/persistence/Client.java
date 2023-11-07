package org.hbrs.se1.ws23.uebung3.persistence;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.ContainerException;

public class Client {

    public static void main(String[] args) {

        Container container = Container.getInstance();
        PersistenceStrategyStream pss = new PersistenceStrategyStream<>();
        pss.setLocation("C:\\");
        container.pss = pss;
        try {
            container.addMember(new ConcreteMember(1));
            container.addMember(new ConcreteMember(2));
            container.addMember(new ConcreteMember(3));
        } catch(ContainerException ce) {

        }

        new MemberView().dump(container.getCurrentList());

    }
}
