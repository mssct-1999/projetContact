package com.example.servingwebcontent.model.contact;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="adressePostale")
@JacksonXmlRootElement(localName = "AdressePostale")
public class AdressePostale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;
    private String libelleAdresse;
    @ManyToMany
    List<Contact> habitants = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelleAdresse() {
        return libelleAdresse;
    }

    public void setLibelleAdresse(String libelleAdresse) {
        this.libelleAdresse = libelleAdresse;
    }
}
