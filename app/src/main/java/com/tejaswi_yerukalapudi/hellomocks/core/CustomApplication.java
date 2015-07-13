package com.tejaswi_yerukalapudi.hellomocks.core;

import android.app.Application;
import android.content.Context;

import com.tejaswi_yerukalapudi.hellomocks.models.Appointment;
import com.tejaswi_yerukalapudi.hellomocks.models.Person;
import com.tejaswi_yerukalapudi.hellomocks.models.Physician;
import com.tejaswi_yerukalapudi.hellomocks.models.Session;
import com.tejaswi_yerukalapudi.hellomocks.models.User;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Teja on 7/9/15.
 */
public class CustomApplication extends Application {
    private Session mCurrentSession;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        // Hard coding user here. In the real app, this needs to be setup by the LoginActivity
        // with the right session.
        this.setupHardcodedSession();
        sContext = this;
    }

    // ugly stuff - necessary till API Integration
    private void setupHardcodedSession() {
        this.mCurrentSession = new Session();
        User currentUser = new User();
        Person p = new Person();
        p.setFirstName("Teja");
        p.setLastName("Y");
        p.setDateOfBirth(new Date(315532800));
        p.setPersonId(UUID.randomUUID().toString());

        Person child1 = new Person();
        child1.setPersonId(UUID.randomUUID().toString());
        child1.setFirstName("Fname1");
        child1.setLastName("Lname1");
        child1.setDateOfBirth(new Date(315532800));

        Person child2 = new Person();
        child2.setPersonId(UUID.randomUUID().toString());
        child2.setFirstName("Fname2");
        child2.setLastName("Lname2");
        child2.setDateOfBirth(new Date(315532800));

        Person child3 = new Person();
        child3.setPersonId(UUID.randomUUID().toString());
        child3.setFirstName("Fname3");
        child3.setLastName("Lname3");
        child3.setDateOfBirth(new Date(315532800));

        List<Person> children = new ArrayList<Person>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        Physician p1 = new Physician("PhyFName1", "PhyLname1", "Pediatrics");
        Physician p2 = new Physician("PhyFName1", "PhyLname1", "Dermatology");

        currentUser.setPerson(p);
        currentUser.setChildren(children);
        this.mCurrentSession.setCurrentUser(currentUser);
        this.mCurrentSession.setLoggedIn(new Date());

        List<Appointment> upcomingAppointments = new ArrayList<Appointment>();

        Appointment appt1 = new Appointment();
        appt1.setPerson(child1);
        appt1.setAppointmentDate(new DateTime().plusDays(2).toDate());
        appt1.setPhysician(p1);
        appt1.setReasonForVisit("Baz");

        Appointment appt2 = new Appointment();
        appt2.setPerson(child2);
        appt2.setAppointmentDate(new DateTime().plusDays(1).toDate());
        appt2.setPhysician(p2);
        appt2.setReasonForVisit("Foo");

        Appointment appt3 = new Appointment();
        appt3.setPerson(child1);
        appt3.setAppointmentDate(new DateTime().plusMinutes(10).toDate());
        appt3.setPhysician(p1);
        appt3.setReasonForVisit("Bar");

        upcomingAppointments.add(appt1);
        upcomingAppointments.add(appt2);
        upcomingAppointments.add(appt3);

        currentUser.setUpcomingAppointments(upcomingAppointments);
    }

    public Session getCurrentSession() {
        return mCurrentSession;
    }

    public void setCurrentSession(Session session) {
        mCurrentSession = session;
    }

    public static Context getContext() {
        return sContext;
    }
}
