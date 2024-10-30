package co.edu.unicauca.events.dao;

import co.edu.unicauca.events.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author FABIAN G
 */
@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}