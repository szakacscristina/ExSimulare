package Service;

import Domain.Event;
import Repository.InMemoryRepository;

import java.util.List;

public class EventService {

    private InMemoryRepository eventRepository;

    public EventService(InMemoryRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * inserts an event
     * @param id the id of the event
     * @param name the name of the event
     * @param day  the day of the event
     * @param duration the duration of the event
     *@param starthour the starthour of the event
     */
    public void insert(String id, String name, String day, String duration, String starthour) {
        Event event = new Event(id, name, day, duration, starthour);
        eventRepository.insert(event);
    }

    /**
     * @return an List with all events
     */
    public List<Event> getAll() {
        return eventRepository.getAll();
    }


}
