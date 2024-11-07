package co.edu.unicauca.events.infrastructure.output.persistence.dao;

import co.edu.unicauca.events.infrastructure.output.persistence.entitys.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FABIAN G
 */

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}