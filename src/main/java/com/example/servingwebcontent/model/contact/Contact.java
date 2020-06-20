package com.example.servingwebcontent.model.contact;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="contacts")
@JacksonXmlRootElement(localName = "Contact")
public class Contact implements Serializable {
    private static final long serialVersionUID = 21L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;
    @JacksonXmlProperty
    private String nom;
    @JacksonXmlProperty
    private String pnom;
    @JacksonXmlProperty
    private int age;

    public Contact() {}
    public Contact(Long id, String nom, String pnom, int age) {
        this.id = id;
        this.nom = nom;
        this.pnom = pnom;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPnom() {
        return pnom;
    }

    public void setPnom(String pnom) {
        this.pnom = pnom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "Contact[id=%d, nom='%s', prenom='%s', age='%s']",
                id, nom, pnom, age);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.nom);
        hash = 37 * hash + Objects.hashCode(this.pnom);
        hash = 37 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.pnom, other.pnom)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}

