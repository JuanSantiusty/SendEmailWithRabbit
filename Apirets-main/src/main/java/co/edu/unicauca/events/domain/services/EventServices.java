package co.edu.unicauca.events.domain.services;

import co.edu.unicauca.events.aplication.ports.input.EventServicesPort;
import co.edu.unicauca.events.aplication.ports.output.EventRepositoryPort;
import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Person;

import java.util.List;

public class EventServices implements EventServicesPort {

    private final EventRepositoryPort repository;

    public EventServices(EventRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<Event> findAll() {
        return repository.findAll();
    }

    @Override
    public Event findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Event create(Event event) {
        return repository.save(event);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Person> findCommittee(Long eventId) {
        return repository.findCommittee(eventId);
    }
}
