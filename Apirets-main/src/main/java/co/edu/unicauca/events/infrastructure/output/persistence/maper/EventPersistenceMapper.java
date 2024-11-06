package co.edu.unicauca.events.infrastructure.output.persistence.maper;

import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Person;
import co.edu.unicauca.events.infrastructure.output.persistence.entitys.EventEntity;
import co.edu.unicauca.events.infrastructure.output.persistence.entitys.PersonEntity;

import java.util.ArrayList;
import java.util.List;

public class EventPersistenceMapper {

    public static EventEntity toEventEntity(Event event) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(event.getId());
        eventEntity.setName(event.getName());
        eventEntity.setChair(PersonPersistenceMapper.toPersonEntity(event.getChair()));
        List<PersonEntity> persons=new ArrayList<>();
        for(Person p: event.getComite()){
            persons.add(PersonPersistenceMapper.toPersonEntity(p));
        }
        eventEntity.setComite(persons);
        return eventEntity;
    }

    public static Event toEvent(EventEntity eventEntity) {
        Event event = new Event();
        event.setId(eventEntity.getId());
        event.setName(eventEntity.getName());
        event.setChair(PersonPersistenceMapper.toPerson(eventEntity.getChair()));
        List<Person> persons=new ArrayList<>();
        for(PersonEntity p: eventEntity.getComite()){
            persons.add(PersonPersistenceMapper.toPerson(p));
        }
        event.setComite(persons);
        return event;
    }
}
