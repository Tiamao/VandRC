package VandRC.workermodule;

import com.vaadin.ui.Calendar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.calendar.CalendarComponentEvents;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Created by Kamil on 31.05.2017.
 */
public class CalendarLayout extends VerticalLayout {

    private Instant today;


    private Calendar calendar;
    CalendarLayout(){
        today = Instant.now();
        calendar = new Calendar();
        calendar.setStartDate(Date.from(today));
        calendar.setEndDate(Date.from(today.plus(Duration.ofDays(30))));

        calendar.setReadOnly(true);
        calendar.setHandler(new CalendarComponentEvents.DateClickHandler() {
            @Override
            public void dateClick(CalendarComponentEvents.DateClickEvent event) {
                
            }
        });


        addComponent(calendar);
    }
}
