package com.tejaswi_yerukalapudi.hellomocks.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.tejaswi_yerukalapudi.hellomocks.lib.helper.Helper;

/**
 * Created by teja on 7/9/15.
 */
public class Physician implements Parcelable {

    private static final String DEFAULT_PHYSICIAN_NAME = "N/A";

    private String physicianId;
    private String firstName;
    private String lastName;
    private String NPINumber;
    private String specialty;

    public Physician() {

    }

    public Physician(String firstName, String lastName, String specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    public Physician(Parcel in) {
        this.physicianId = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.NPINumber = in.readString();
        this.specialty = in.readString();
    }

    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
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

    public String getNPINumber() {
        return NPINumber;
    }

    public void setNPINumber(String NPINumber) {
        this.NPINumber = NPINumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getFullName() {
        String fullName = Helper.getFullName(this.firstName, this.lastName);
        return (!fullName.isEmpty()) ? "Dr. " + Helper.getFullName(this.firstName, this.lastName) : DEFAULT_PHYSICIAN_NAME;
    }

    // Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.physicianId);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.NPINumber);
        dest.writeString(this.specialty);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Physician createFromParcel(Parcel in) {
            return new Physician(in);
        }

        public Physician[] newArray(int size) {
            return new Physician[size];
        }
    };
}
