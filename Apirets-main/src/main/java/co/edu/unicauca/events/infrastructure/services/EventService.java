/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.events.infrastructure.services;

import co.edu.unicauca.events.infrastructure.output.persistence.dao.EventRepository;
import co.edu.unicauca.events.infrastructure.output.persistence.entitys.EventEntity;
import co.edu.unicauca.events.infrastructure.output.persistence.entitys.PersonEntity;
import co.edu.unicauca.events.infrastructure.output.publisher.DTO.PersonDTO;
import co.edu.unicauca.events.infrastructure.output.publisher.Publisher;
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
  public List<EventEntity> findAll() {
    return (List<EventEntity>) eventDao.findAll();
  }

  @Override
  @Transactional
  public EventEntity findById(Long id) {
    EventEntity e = eventDao.findById(id).orElse(null);
    return e;
  }

  @Override
  @Transactional
  public EventEntity create(EventEntity event) {
    EventEntity e =eventDao.save(event);
    PersonEntity person = event.getChair();
    PersonDTO personDTO = new PersonDTO(person.getId(), person.getName(), person.getEmail(), event.getId(),event.getName());
    publisher.sendEmail(personDTO);
    return e;
  }

  @Override
  @Transactional
  public EventEntity update(Long id, EventEntity event) {
    EventEntity e = findById(id);
    e.setName(event.getName());
    return eventDao.save(e);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    eventDao.deleteById(id);
  }

  @Override
  public List<PersonEntity> findCommittee(Long eventId) {
    Optional<EventEntity> event = eventDao.findById(eventId);

    if (event.isEmpty()) {
      throw new RuntimeException("Event not found");
    }

    return  event.get().getComite();
  }
}
