package org.hbrs.se1.ws23.uebung3.persistence;

import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Container {

    private ArrayList<Member> members;
    private static Container INSTANCE;

    public PersistenceStrategy<Member> pss;

    private Container() {

        members = new ArrayList<>();
    }

    public void store() throws PersistenceException {

        try {
            pss.save(members);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMember(Member member) throws ContainerException {
        int id = member.getID();
        if(isInList(id)) {
            throw new ContainerException("Das Member-Objekt mit der ID [" +
                    id +
                    "] ist bereits vorhanden!");
        } else {
            members.add(member);
        }

    }

    public void load() throws PersistenceException, IOException, ClassNotFoundException {


            members = (ArrayList<Member>) pss.load();

    }

    public static Container getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Container();
        }

        return INSTANCE;
    }

    public boolean isInList(int id) {

        for(int i = 0; i < members.size(); i++) {
            if(id == members.get(i).getID()) {

                return true;

            }
        }

        return false;

    }

    public String deleteMember(int id) {

        for(int i = 0; i < members.size(); i++) {
            if(id == members.get(i).getID()) {
                members.remove(i);
                return Integer.toString(id);
            }
        }

        return "Member-Objekt mit dieser ID nicht in der Liste";

    }

    public List<Member> getCurrentList() {
        return members;
    }
    public int size() {
        return members.size();
    }

}
