package com.sample.demo.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PersonalInformationManagerTest {

    private static final int ONE_HOUR = 60;
    private static final int MILLIS_IN_MINUTE = 1000 * 60;

    private static final Date START_DATE = new Date();
    private static final Date END_DATE = new Date(START_DATE.getTime()
            + ONE_HOUR * MILLIS_IN_MINUTE);

    @Disabled
    void shouldAddNewEventToCalendar() {
        Calendar calendar = mock(Calendar.class);
        PersonalInformationManager pim = new PersonalInformationManager(calendar);

        pim.addMeeting(START_DATE, ONE_HOUR);

        // NOTE: Meeting should override equals
        Meeting expectedMeeting = new Meeting(START_DATE, END_DATE);
        verify(calendar).addEvent(expectedMeeting);
    }

    @Test
    void shouldAddNewEventToCalendarArgumentCaptor() {
        Calendar calendar = mock(Calendar.class);
        PersonalInformationManager pim = new PersonalInformationManager(calendar);

        pim.addMeeting(START_DATE, ONE_HOUR);

        ArgumentCaptor<Meeting> argument
                = ArgumentCaptor.forClass(Meeting.class);

        verify(calendar).addEvent(argument.capture());

        Meeting meeting = argument.getValue();
        assertThat(meeting.getStartDate()).isEqualTo(START_DATE);
        assertThat(meeting.getEndDate()).isEqualTo(END_DATE);
    }

    @Test
    void shouldAddNewEventToCalendarHamcrestMatcher() {
        Calendar calendar = mock(Calendar.class);
        PersonalInformationManager pim = new PersonalInformationManager(calendar);

        pim.addMeeting(START_DATE, ONE_HOUR);

        verify(calendar).addEvent(argThat(event ->
                event.getStartDate().equals(START_DATE) &&
                event.getEndDate().equals(END_DATE))
        );
    }
}