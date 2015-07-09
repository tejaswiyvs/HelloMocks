package com.tejaswi_yerukalapudi.hellomocks.models;

import java.util.Date;

/**
 * Created by Teja on 7/9/15.
 */
public class Session {
    private User currentUser;
    private Date loggedIn;

    // Currently unused, Might be useful in the future if we want to auto-logout the user based
    // on timestamp
    private Date lastInteractedOn;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Date getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Date loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Date getLastInteractedOn() {
        return lastInteractedOn;
    }

    public void setLastInteractedOn(Date lastInteractedOn) {
        this.lastInteractedOn = lastInteractedOn;
    }
}
