package com.tejaswi_yerukalapudi.hellomocks.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.tejaswi_yerukalapudi.hellomocks.lib.helper.Helper;

import java.util.Date;

/**
 * Created by teja on 7/9/15.
 */

public class Appointment implements Parcelable, Comparable<Appointment> {
    private static String NULL_STRING = "N/A";

    private String appointmentId;
    private Date appointmentDate;
    private String reasonForVisit;
    private Physician physician;
    private Person person;
    private AppointmentStatus appointmentStatus;
    private String appointmentType;

    public Appointment() {

    }

    public Appointment(Parcel in) {
        this.appointmentId = in.readString();
        this.appointmentDate = new Date(this.appointmentDate.getTime());
        this.reasonForVisit = in.readString();
        this.physician = in.readParcelable(Physician.class.getClassLoader());
        this.person = in.readParcelable(Person.class.getClassLoader());
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPhysicianInfo() {
        if (this.physician == null) {
            return NULL_STRING;
        }
        String physicianName = this.physician.getFullName();
        String specialty = this.physician.getSpecialty();
        return physicianName + " - " + specialty;
    }

    // Comparable
    @Override
    public int compareTo(Appointment another) {
        if (this.appointmentDate == null) return -1;
        else if (another.appointmentDate == null) return 1;
        return this.appointmentDate.compareTo(another.appointmentDate);
    }

    // Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.appointmentId);
        dest.writeLong(this.appointmentDate.getTime());
        dest.writeString(this.reasonForVisit);
        dest.writeParcelable(this.physician, flags);
        dest.writeParcelable(this.person, flags);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Appointment createFromParcel(Parcel in) {
            return new Appointment(in);
        }
        public Appointment[] newArray(int size) {
            return new Appointment[size];
        }
    };

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
}
