package com.tejaswi_yerukalapudi.hellomocks.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by teja on 7/9/15.
 */
public class Appointment implements Parcelable {
    private String appointmentId;
    private Date appointmentDateTime;
    private String reasonForVisit;
    private Physician physician;
    private Person person;

    public Appointment() {

    }

    public Appointment(Parcel in) {
        this.appointmentId = in.readString();
        this.appointmentDateTime = new Date(this.appointmentDateTime.getTime());
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

    public Date getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(Date appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
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

    // Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.appointmentId);
        dest.writeLong(this.appointmentDateTime.getTime());
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
}
