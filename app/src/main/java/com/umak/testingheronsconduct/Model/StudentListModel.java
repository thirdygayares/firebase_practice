package com.umak.testingheronsconduct.Model;

public class StudentListModel {
    String id;
    String image;
    String name;
    String college;
    String email;

    public StudentListModel() {
    }


    public StudentListModel(String id, String image, String name, String college, String email) {

        this.id = id;
        this.image = image;
        this.name = name;
        this.college = college;
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public String getCollege() {
        return college;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
