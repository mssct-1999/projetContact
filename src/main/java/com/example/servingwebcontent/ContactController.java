package com.example.servingwebcontent;

import com.example.servingwebcontent.model.ContactForm;
import com.example.servingwebcontent.model.contact.Contact;
import com.example.servingwebcontent.model.contact.Contacts;
import com.example.servingwebcontent.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContactController implements WebMvcConfigurer {

    @Autowired
    private IContactService contactService;
    public static int idContact = 0;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/listContact").setViewName("listContact");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");

    }

    @GetMapping("listContact")
    public String showListContacts(Model model) {
        Contacts contacts = contactService.findAll();
        List<Contact> contactList = contacts.getContacts();
        model.addAttribute("contacts",contactList);
        return "listContact";
    }

    @GetMapping("/formContact")
    public String showForm(@RequestParam(defaultValue = "0") int id, Model model, ContactForm personForm) {
        idContact = id;
        return "form";
    }


    @PostMapping("/formContact")
    public String submitForm (Model model, @Valid ContactForm personForm, BindingResult bindingResult) {
        if(idContact == 0) {
            contactService.addContact(personForm.getName(), personForm.getPrenom(), personForm.getAge());
        } else {
            contactService.editContact(idContact, personForm.getName(), personForm.getPrenom(), personForm.getAge());
        }
        return "redirect:/listContact";
    }

    @GetMapping("/delContact")
    public String delete(@RequestParam("id") int id, Model model) {
        contactService.deleteContact(id);
        return "redirect:/listContact";
    }

}
