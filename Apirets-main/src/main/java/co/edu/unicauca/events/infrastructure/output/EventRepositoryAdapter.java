package co.edu.unicauca.events.infrastructure.output;

import co.edu.unicauca.events.aplication.ports.output.EventRepositoryPort;
import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Person;
import co.edu.unicauca.events.infrastructure.output.persistence.dao.EventRepository;
import co.edu.unicauca.events.infrastructure.output.persistence.entitys.EventEntity;
import co.edu.unicauca.events.infrastructure.output.persistence.maper.EventPersistenceMapper;
import co.edu.unicauca.events.infrastructure.output.publisher.DTO.PersonDTO;
import co.edu.unicauca.events.infrastructure.output.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EventRepositoryAdapter implements EventRepositoryPort {

    @Autowired
    private EventRepository repo;

    @Autowired
    Publisher publisher;

    @Override
    public List<Event> findAll() {
        return repo.findAll().stream()
                .map(EventPersistenceMapper::toEvent)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Event> findById(Long id) {
        Optional<EventEntity> entity = repo.findById(id);
        if(entity.isEmpty()) {
            return Optional.empty();
        }

        Event event = EventPersistenceMapper.toEvent(entity.get());

        return Optional.of(event);
    }

    @Override
    public Event save(Event event) {
        EventEntity entity = EventPersistenceMapper.toEventEntity(event);
        entity = repo.save(entity);
        Person chair=event.getChair();
        PersonDTO chairDTO=new PersonDTO(chair.getId(), chair.getName(), chair.getEmail(), event.getId(), event.getName());
        publisher.sendEmail(chairDTO);
        return EventPersistenceMapper.toEvent(entity);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Person> findCommittee(Long eventId) {
        Optional<Event> event = findById(eventId);
        if(event.isEmpty()) {
            return List.of();
        }
        return event.get().getComite();
    }
}
