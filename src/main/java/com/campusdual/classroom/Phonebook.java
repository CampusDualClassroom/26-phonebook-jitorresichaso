package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    private Map<String, Contact> data = new HashMap<>();

    public Map<String, Contact> getData() {
        return data;
    }

    public void addContact(Contact c) {
        this.data.put(c.getCode(), c);
    }

    public void deleteContact(String code) {
        this.data.remove(code);
    }

    public void showPhonebook() {
        for (Contact c : data.values()) {
            c.showContactDetails();
        }
    }
}
