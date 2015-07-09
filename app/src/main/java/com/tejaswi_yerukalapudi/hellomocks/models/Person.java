package com.tejaswi_yerukalapudi.hellomocks.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by teja on 7/9/15.
 */
public class Person implements Parcelable {
    private String personId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public Person() {

    }

    public Person(Parcel in) {
        this.personId = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.dateOfBirth = new Date(in.readLong());
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.personId);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeLong(this.dateOfBirth.getTime());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }
        public Person [] newArray(int size) {
            return new Person[size];
        }
    };
}
