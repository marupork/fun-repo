package com.sample.demo.service;

import java.util.Date;

public class PersonalInformationManager {

    private final static int MILLIS_IN_MINUTE = 60 * 1000;

    private final Calendar calendar;

    public PersonalInformationManager(Calendar calendar) {
        this.calendar = calendar;
    }

    /*
    The problem with addMeeting() method testing comes from its poor design.
    It is responsible for too many things - it deals with the creation of the Meeting object, and interacts with the calendar collaborator.
    If we were to split its functionality and, for example, introduce another collaborator responsible for the creation of proper Meeting objects,
        than there would be no issue with testing arguments of the addEvent() method!
     */
    public void addMeeting(Date startDate, int durationInMinutes) {
        Date endDate = new Date(startDate.getTime() + MILLIS_IN_MINUTE * durationInMinutes);

        Meeting meeting = new Meeting(startDate, endDate);

        calendar.addEvent(meeting);
    }
}

interface Calendar {
    void addEvent(Event event);
}

interface Event {
    Date getStartDate();
    Date getEndDate();
}

class Meeting implements Event {
    private final Date startDate;
    private final Date endDate;

    Meeting(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(startDate, meeting.startDate) &&
                Objects.equals(endDate, meeting.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }*/
}

