package co.edu.unicauca.events.infrastructure.input;

import co.edu.unicauca.events.aplication.ports.input.EventServicesPort;
import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Person;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/events")
public class EventRestAdapter {
  private final EventServicesPort eventService;

  public EventRestAdapter(EventServicesPort eventService) {
    this.eventService = eventService;
  }

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
