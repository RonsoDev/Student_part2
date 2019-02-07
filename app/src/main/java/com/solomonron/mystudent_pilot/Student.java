package com.solomonron.mystudent_pilot;

import android.widget.ImageView;
import android.widget.TextView;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String red;
    private String green;
    private String editComment;

    public Student(int id, String firstName, String lastName, String red, String green, String editComment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.red = red;
        this.green = green;
        this.editComment = editComment;
    }

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getGreen() {
        return green;
    }

    public void setGreen(String green) {
        this.green = green;
    }

    public String getEditComment() {
        return editComment;
    }

    public void setEditComment(String editComment) {
        this.editComment = editComment;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", red='" + red + '\'' +
                ", green='" + green + '\'' +
                ", editComment='" + editComment + '\'' +
                '}';
    }
}
