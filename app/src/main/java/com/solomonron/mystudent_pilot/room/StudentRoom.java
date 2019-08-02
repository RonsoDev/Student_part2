package com.solomonron.mystudent_pilot.room;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class StudentRoom implements Parcelable {

    @PrimaryKey
    final private int id;

    @ColumnInfo (name = "first_name")
    private String firstName;

    @ColumnInfo (name = "last_name")
    private String lastName;

    @ColumnInfo (name = "kita")
    private String kita;

    @ColumnInfo (name = "school")
    private String school;

    @ColumnInfo (name = "kindergarden")
    private String kindergarden;

    @ColumnInfo (name = "city")
    private String city;

    @ColumnInfo( name = "is_selected")
    private boolean isSelected = false;

 /*   public StudentRoom(String city) {
        this.city = city;
    }*/

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public StudentRoom(int id, String firstName, String lastName, String kita, String school, String kindergarden, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.kita = kita;
        this.school = school;
        this.kindergarden = kindergarden;
        this.city = city;
    }

  /*  public StudentRoom(int id, String firstName, String lastName, String kita, String school, String kindergarden, String city, boolean isSelected) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.kita = kita;
        this.school = school;
        this.kindergarden = kindergarden;
        this.city = city;
        this.isSelected = isSelected;
    }*/

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

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

    public String getKita() {
        return kita;
    }

    public void setKita(String kita) {
        this.kita = kita;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getKindergarden() {
        return kindergarden;
    }

    public void setKindergarden(String kindergarden) {
        this.kindergarden = kindergarden;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public StudentRoom(Parcel in) {
        this.id = in.readInt();
        this.city = in.readString();
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public StudentRoom createFromParcel(Parcel in) {
            return new StudentRoom(in);
        }

        public StudentRoom[] newArray(int size) {
            return new StudentRoom[size];
        }
    };
}
