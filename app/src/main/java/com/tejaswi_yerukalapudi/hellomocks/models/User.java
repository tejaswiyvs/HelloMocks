package com.tejaswi_yerukalapudi.hellomocks.models;

import java.util.List;

/**
 * Created by Teja on 7/9/15.
 */
public class User {
    private Person person;
    private List<Person> children;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }
}
