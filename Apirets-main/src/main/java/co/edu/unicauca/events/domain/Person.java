package co.edu.unicauca.events.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author FABIAN G
 */
@Entity
@Table(name = "person")
public class Person implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public String name;

  private String email;

  @ManyToMany(mappedBy = "comite")
  private List<Event> events;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
