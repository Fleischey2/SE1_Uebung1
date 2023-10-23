package org.hbrs.se1.ws23.uebung2;

import java.util.ArrayList;

public class Container {

    private ArrayList<Member> members;


    public Container() {

        members = new ArrayList<>();

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

    public void dump() {


        for(int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i).toString());
        }

    }

    public int size() {
        return members.size();
    }

}
