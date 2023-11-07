package org.hbrs.se1.ws23.uebung3.persistence;

import org.hbrs.se1.ws23.uebung2.Member;

import java.util.List;

public class MemberView {

    public void dump (List<Member> liste) {

        for(int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(i).toString());
        }

    }
}
