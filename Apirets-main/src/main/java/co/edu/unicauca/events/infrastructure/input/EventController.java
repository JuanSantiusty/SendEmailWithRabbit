package co.edu.unicauca.events.infrastructure.input;

import co.edu.unicauca.events.infrastructure.output.persistence.entitys.EventEntity;
import co.edu.unicauca.events.infrastructure.output.persistence.entitys.PersonEntity;
import co.edu.unicauca.events.infrastructure.services.IEventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FABIAN G
 */
@RestController
@Component
@RequestMapping("/events")
public class EventController {
  @Autowired
  IEventService eventService;



  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<EventEntity> findAll() {
    return eventService.findAll();
  }

  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public EventEntity create(@RequestBody EventEntity event) {
    return eventService.create(event);
  }

  /* Get a Event by ID */
  @GetMapping("/{id}")
  public EventEntity getEventById(@PathVariable Long id) {
    return eventService.findById(id);
  }

  @GetMapping("/{id}/committee")
  public List<PersonEntity> getCommittee(@PathVariable Long id) {
    return eventService.findCommittee(id);
  }
}
