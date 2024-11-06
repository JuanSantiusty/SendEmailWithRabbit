package co.edu.unicauca.events.aplication.ports.input;

import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Person;

import java.util.List;

public interface EventServicesPort {
    List<Event> findAll();

    Event findById(Long id);

    Event create(Event event);

    void deleteById(Long id);

    List<Person> findCommittee(Long eventId);
}
