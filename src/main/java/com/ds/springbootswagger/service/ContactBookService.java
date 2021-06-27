package com.ds.springbootswagger.service;


import com.ds.springbootswagger.bean.ContactBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ContactBookService {
    private final ConcurrentHashMap<Integer, ContactBean> contacts = new ConcurrentHashMap<>();
    Random rand = new Random();
    static final int MAX = 9999999;
    static final int MIN = 1000000;

    @PostConstruct
    public void generateContacts() {


        for (int i = 1; i <= 100; i++) {
            StringBuilder tpNumber = new StringBuilder();
            if (i % 3 == 0) {
                tpNumber.append("071");
            } else if (i % 3 == 1) {
                tpNumber.append("077");
            } else {
                tpNumber.append("075");
            }

            String padded = Integer.toString(this.rand.nextInt(MAX + 1 - MIN) + MIN);
            tpNumber.append(padded);
            contacts.put(i, new ContactBean(i, "userName" + i, tpNumber.toString()));
        }
    }


    public ContactBean getById(int id) {
        return contacts.get(id);
    }

    public List<ContactBean> getAllContacts() {
        return new ArrayList<>(contacts.values());
    }

    public ContactBean addContact(ContactBean contact) {
        contacts.put(contact.getId(), contact);
        return contact;
    }
}
