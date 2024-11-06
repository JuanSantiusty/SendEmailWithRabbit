package co.edu.unicauca.events.aplication.ports.output;

import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Person;

import java.util.List;
import java.util.Optional;

public interface EventRepositoryPort {

    List<Event> findAll();

    Optional<Event> findById(Long id);

    Event save(Event event);

    void deleteById(Long id);

    List<Person> findCommittee(Long eventId);

}
