package com.solomonron.mystudent_pilot;

import android.os.Parcel;
import android.os.Parcelable;

public class Kita implements Parcelable {

    private int id;
    private String firstName;

    private String lastName;
    private String kita;
    private String school;
    private String kindergarden;
    private String city;

    private boolean isSelected = false;





    public Kita(String city) {
        this.city = city;
    }



    public Kita(int id, String firstName, String lastName, String kita, String school, String kindergarden, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.kita = kita;
        this.school = school;
        this.kindergarden = kindergarden;
        this.city = city;
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

    public static Creator getCREATOR() {
        return CREATOR;
    }

    public Kita() {

    }

    public Kita(int id, String city) {
        this.id = id;
        this.city = city;

    }

    public Kita(int id) {
        this.id = id;
    }

    public Kita(int id, boolean isSelected, String city) {
        this.id = id;
        this.isSelected = isSelected;
        this.city = city;
    }



    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    //מכאן משתמשים באינטרפייס PARCELABLE על מנת להעביר אריי ליסטים לאקטיבי חדש באינטנט

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(this.id);
        dest.writeString(this.city);


    }

    public Kita(Parcel in) {
        this.id = in.readInt();
        this.city = in.readString();
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Kita createFromParcel(Parcel in) {
            return new Kita(in);
        }

        public Kita[] newArray(int size) {
            return new Kita[size];
        }
    };
}
