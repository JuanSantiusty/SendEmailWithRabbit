/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.events.services;

import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Person;

import java.util.List;

/**
 *
 * @author FABIAN G
 */
public interface IEventService {
  public List<Event> findAll();

  public Event findById(Long id);

  public Event create(Event event);

  public Event update(Long id, Event event);

  public void deleteById(Long id);

  public List<Person> findCommittee(Long eventId);
}
