package com.example.meetthestreets;

import com.google.firebase.database.Exclude;

import java.util.Map;

public class Event {
    private String title;
    private String name;
    private String type;
    private String documentId;
    private int priority;
    private String description;
    private String place;
    private String address;
    private String contact;
    private String hours;
    private String image;
    //private String socialMedia;

    Map<String, Boolean> tags;

    public Event() {
        //public no-arg constructor needed
    }

    public Event(String title, String name, String type, String documentId, int priority, String description, String place, String address, String contact, String hours, String image, Map<String, Boolean> tags) {
        this.title = title;
        this.name = name;
        this.type = type;
        this.documentId = documentId;
        this.priority = priority;
        this.description = description;
        this.place = place;
        this.address = address;
        this.contact = contact;
        this.hours = hours;
        this.image = image;
        this.tags = tags;
    }



    @Exclude
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }
    public int getPriority() {
        return priority;
    }

    public Map<String, Boolean> getTags() {
        return tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
       this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}