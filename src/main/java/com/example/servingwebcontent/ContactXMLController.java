package com.example.servingwebcontent;

import com.example.servingwebcontent.model.contact.Contact;
import com.example.servingwebcontent.model.contact.ContactRepository;
import com.example.servingwebcontent.model.contact.Contacts;
import com.example.servingwebcontent.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactXMLController {

    @Autowired
    private IContactService contactService;

    @GetMapping(value="/contacts", produces=MediaType.APPLICATION_XML_VALUE)
    public Contacts findContacts() {
        return contactService.findAll();
    }

    @GetMapping(value="/contacts/{contactId}", produces=MediaType.APPLICATION_XML_VALUE)
    public Contact findContact(@PathVariable Long contactId) {

        return contactService.findById(contactId);
    }
}
