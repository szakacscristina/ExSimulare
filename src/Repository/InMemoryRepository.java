
package Repository;

import Domain.Event;
import Domain.EventValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository {

    private Map<String, Event> storage = new HashMap<>();
    private EventValidator validator;

    public InMemoryRepository(EventValidator validator) {
        this.validator = validator;
    }

    /**
     * inserts an event
     * @param event
     * @throws RepositoryException if an event with that day already exists
     */
    public void insert(Event event) {
        if (storage.containsKey(event.getDay())) {
            throw new RepositoryException("An event with that day already exists");
        }
        validator.validate(event);
        storage.put(event.getDay(), event);
    }

    /**
     * @return a list with all events
     */
    public List<Event> getAll() {
        return new ArrayList<>(storage.values());
    }

}