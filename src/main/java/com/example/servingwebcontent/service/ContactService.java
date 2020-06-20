package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.contact.Contact;
import com.example.servingwebcontent.model.contact.ContactRepository;
import com.example.servingwebcontent.model.contact.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService {
    
    @Autowired
    private ContactRepository repository;

    @Override
    public Contacts findAll() {

        List<Contact> contacts = (List<Contact>) repository.findAll();
        Contacts mycontacts = new Contacts();
        mycontacts.setContacts(contacts);
        return mycontacts;
    }

    @Override
    public Contact findById(Long id) {
        return repository.findById(id).orElse(new Contact());
    }


    @Override
    public void addContact(String nom, String prenom, int age) {
        Contact contact = new Contact((long) 0, nom, prenom, age);
        repository.save(contact);
    }

    @Override
    public void editContact(int id, String nom, String prenom, int age) {
        Contact contact = new Contact((long) id, nom, prenom, age);
        repository.save(contact);
    }

    @Override
    public void deleteContact(int id) {
        repository.deleteById((long) id);
    }
}
