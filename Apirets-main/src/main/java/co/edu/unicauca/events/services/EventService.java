/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.events.services;

import co.edu.unicauca.events.dao.EventRepository;
import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Person;
import co.edu.unicauca.events.publisher.DTO.PersonDTO;
import co.edu.unicauca.events.publisher.Publisher;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author FABIAN G
 */
@Component
public class EventService implements IEventService {
  @Autowired
  Publisher publisher;

  @Autowired
  EventRepository eventDao;

  @Override
  @Transactional
  public List<Event> findAll() {
    return (List<Event>) eventDao.findAll();
  }

  @Override
  @Transactional
  public Event findById(Long id) {
    Event e = eventDao.findById(id).orElse(null);
    return e;
  }

  @Override
  @Transactional
  public Event create(Event event) {
    Event e =eventDao.save(event);
    Person person = event.getChair();
    PersonDTO personDTO = new PersonDTO(person.getId(), person.getName(), person.getEmail(), event.getId(),event.getName());
    publisher.sendEmail(personDTO);
    return e;
  }

  @Override
  @Transactional
  public Event update(Long id, Event event) {
    Event e = findById(id);
    e.setName(event.getName());
    return eventDao.save(e);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    eventDao.deleteById(id);
  }

  @Override
  public List<Person> findCommittee(Long eventId) {
    Optional<Event> event = eventDao.findById(eventId);

    if (event.isEmpty()) {
      throw new RuntimeException("Event not found");
    }

    return  event.get().getComite();
  }
}
