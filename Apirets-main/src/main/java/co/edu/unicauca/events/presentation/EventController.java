package co.edu.unicauca.events.presentation;

import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Person;
import co.edu.unicauca.events.publisher.DTO.PersonDTO;
import co.edu.unicauca.events.publisher.Publisher;
import co.edu.unicauca.events.services.IEventService;
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
  public List<Event> findAll() {
    return eventService.findAll();
  }

  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public Event create(@RequestBody Event event) {
    return eventService.create(event);
  }

  /* Get a Event by ID */
  @GetMapping("/{id}")
  public Event getEventById(@PathVariable Long id) {
    return eventService.findById(id);
  }

  @GetMapping("/{id}/committee")
  public List<Person> getCommittee(@PathVariable Long id) {
    return eventService.findCommittee(id);
  }
}
