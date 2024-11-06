/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.events.infrastructure.services;

import co.edu.unicauca.events.infrastructure.output.persistence.entitys.EventEntity;
import co.edu.unicauca.events.infrastructure.output.persistence.entitys.PersonEntity;

import java.util.List;

/**
 *
 * @author FABIAN G
 */
public interface IEventService {
  public List<EventEntity> findAll();

  public EventEntity findById(Long id);

  public EventEntity create(EventEntity event);

  public EventEntity update(Long id, EventEntity event);

  public void deleteById(Long id);

  public List<PersonEntity> findCommittee(Long eventId);
}
