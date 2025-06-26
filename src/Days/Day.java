package Days;

import Event.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Day {

    private final Integer MAX_NUMBER_OF_EVENTS = 10;

    private String dayName;

    private Event eventSpecial;

    private ArrayList<Event> customEvents;

    private Day(Integer year, Integer dayOfYear){

        this.customEvents = new ArrayList<>();
        setDayName(year, dayOfYear);


    }

    private void setDayName(Integer year, Integer dayOfYear){
        LocalDate date = LocalDate.ofYearDay(year, dayOfYear);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        String day = String.valueOf(dayOfWeek);
        this.dayName = day.substring(0,3);
    }

    public void addEvent(String eventName) throws EventAlreadyIn, EventMaxCapacityAlready {
        Event event = new Event(eventName);
        if(this.customEvents.size() <= MAX_NUMBER_OF_EVENTS) {

            if(isEventIn(eventName)) throw new EventAlreadyIn();

            this.customEvents.add(event);

        }
        else throw new EventMaxCapacityAlready();
    }

    private boolean isEventIn(String eventName){
        for(Event event : this.customEvents){
            if(event.getName().equals(eventName)){
                return true;
            }
        }
        return false;
    }

    public void removeEvent(String eventName) throws EventNotIn {
        for(Event eventIn : this.customEvents){
            if(eventIn.getName().equals(eventName)){
                this.customEvents.remove(eventIn);
                return;
            }
        }
        throw new EventNotIn();
    }
}
