package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.contact.Contact;
import com.example.servingwebcontent.model.contact.Contacts;

public interface IContactService {
    Contacts findAll();
    Contact findById(Long id);
    void addContact(String nom, String prenom, int age);
    void editContact(int id, String nom, String prenom, int age);
    void deleteContact(int id);
}